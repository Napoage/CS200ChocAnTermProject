function handleButtonClick(event) {
    event.preventDefault();

    // Add check if var is empty 
    var name = document.getElementsByName('Name')[0].value;
    var username = document.getElementsByName('Username')[0].value;
    var password = document.getElementsByName('Password')[0].value;

    var htmlTitle = document.title;
    var Role;
    if (!name || !username || !password){
        alert("Please fill in all fields");
    } else {
        if (htmlTitle === "ChocAnAddManagerPage") {
            console.log("In manager");
            Role = "Member";
            let manager = {
                // Fill in your manager fields here
                name: name,
                address: username,
                city: password,
            }
            fetch('http://localhost:8080/api/operator/addManager', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(manager),
            })
            .then(response => response.json())
            .then(data => {
                if(data == 0){
                    openPopup();
                } else {
                    openPopup2();
                }
            })
            .catch((error) => {
                console.error('Error:', error);
            });
        } else if (htmlTitle === "ChocAnAddOperatorPage") {
            console.log("In operator");
            let operator = {
                // Fill in your operator fields here
                name: name,
                address: username,
                city: password,
            }
            fetch('http://localhost:8080/api/operator/addOperator', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(operator),
            })
            .then(response => response.json())
            .then(data => {
                console.log('Success:', data);
              if (data == 0) {
openPopup();} else {
  openPopup2();
}
            })
            .catch((error) => {
                console.error('Error:', error);
              openPopup();
            });
        }
    }
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
let popup2 = document.getElementById("popup2");
function closePopup2(event) {
  event.preventDefault();
  popup2.classList.remove("open-popup2");
  var button2 = document.getElementById('okButton2');
  button2.style.visibility = 'hidden2';
  window.location.href = 'AddManagerPage.html'
}
// Corrected typo in function keyword
function openPopup2() {
  popup2.classList.add("open-popup2");
  var button = document.getElementById('okButton2');
  button.style.visibility = 'visible';
}

// Attach the function to the button click event
document.getElementById('submitButton').addEventListener('click', function (event) {
    handleButtonClick(event);
});

document.getElementById('goBackButton').addEventListener('click', function (event) {
    handlegoBackButtonClick(event);
});
document.getElementById('okButton').addEventListener('click', function (event) {
    closePopup(event);
});
document.getElementById('okButton2').addEventListener('click', function (event) {
    closePopup2(event);
});