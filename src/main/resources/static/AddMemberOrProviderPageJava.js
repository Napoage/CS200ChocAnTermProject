
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

    if (!name || !address || !city || !state || !zipCode || !email) {
        console.log("Please fill in all fields");
    } else {
        if (htmlTitle === "ChocAnAddMemberPage") {
            console.log("In member");
            // If the title matches, assign a value to a variable
            let member = {
                // Fill in your member fields here
                name: name,
                address: address,
                city: city,
                state: state,
                zipCode: zipCode,
                email: email
                // add other fields if they exist in your Member class
            };

            fetch('http://localhost:8080/api/operator/addMember', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(member),
            })
                .then(response => response.json())
                .then(data => {
                    console.log('Success:', data);
                    if (data == 0) {
console.log('error');
            openPopup();
                    } else {
                      console.log('Success');
                      window.location.href = "AddMemberPage.html";
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
let popup = document.getElementById("popup");
function closePopup(event) {
  event.preventDefault();
  popup.classList.remove("open-popup");
  var button = document.getElementById('okButton');
  button.style.visibility = 'hidden';
}
// Corrected typo in function keyword
function openPopup() {
  popup.classList.add("open-popup");
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
document.getElementById('okButton').addEventListener('click', function (event) {
    closePopup(event);
});