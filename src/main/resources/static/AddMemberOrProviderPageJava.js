
function handleButtonClick(event) {
    event.preventDefault();
    console.log("Button clicked");
    var name = document.getElementsByName('Name')[0].value;
    var address = document.getElementsByName('Address')[0].value;
    var city = document.getElementsByName('City')[0].value;
    var state = document.getElementsByName('StateCode')[0].value;
    var zipCode = document.getElementsByName('ZipCode')[0].value;
    var email = document.getElementsByName('Email')[0].value;

    var htmlTitle = document.title;
    var Role;
    console.log(name, address, city, state, zipCode, email, htmlTitle);
    if (!name || !address || !city || !state || !zipCode || !email) {
        console.log("Please fill in all fields");
    } else {
        // ...
        if (htmlTitle === "ChocAnAddMemberPage") {
            console.log("In member");
            let url = `http://localhost:8080/api/operator/addMember?name=${name}&email=${email}&address=${address}&city=${city}&state=${state}&zipCode=${zipCode}&status=true`;
        
            fetch(url, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
            })
            .then(response => response.json())
            .then(data => {
                console.log('Success:', data);
                if (data === 0) {
                    console.log('error');

                } else {
                    console.log('Success');
                    openPopup2(data);
                }
            })
            .catch((error) => {
                console.error('Error:', error);
            });       
    } else if (htmlTitle === "ChocAnAddProviderPage") {
            // If the title matches, assign a value to a variable
          var userName = document.getElementsByName('userName')[0].value;
          var password = document.getElementsByName('password')[0].value;
            let provider = {
                // Fill in your member fields here
                name: name,
                address: address,
                city: city,
                state: state,
                zipCode: zipCode,
                email: email,
                username: userName,
                password: password
                // add other fields if they exist in your Member class
            };

            fetch('http://localhost:8080/api/operator/addProvider', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(provider),
            })
                .then(response => response.json())
                .then(data => {
                    console.log('Success:', data);
                    if(data == 0) {
                      openPopup();
                    } else {
                      window.location.href = "ChocAnAddProviderPage.html";
                    }
                })
                .catch((error) => {
                    console.error('Error:', error);
                });

        }
    }
    console.log("After if statement");
}

function handlegoBackButtonClick(event) {
    event.preventDefault();
    window.location.href = "OperatorMenuPage.html";
}
let popup2 = document.getElementById("popup2");
function closePopup2(event) {
  event.preventDefault();
  popup2.classList.remove("open-popup2");
  var button2 = document.getElementById('okButton');
  button2.style.visibility = 'hidden';
  window.location.href = 'AddMemberPage.html'
}
// Corrected typo in function keyword
function openPopup2(data) {
  popup2.classList.add("open-popup2");
  document.getElementById('output').textContent = data;
  var button = document.getElementById('okButton');
  button.style.visibility = 'visible';
}



// Attach the function to the button click event
document.getElementById('submitButton').addEventListener('click', function (event) {
    handleButtonClick(event);
    //writeToFile();
});
document.getElementById('goBackButton').addEventListener('click', function (event) {
    handlegoBackButtonClick(event);
});
document.getElementById('okButton2').addEventListener('click', function (event) {
    closePopup2(event);
});