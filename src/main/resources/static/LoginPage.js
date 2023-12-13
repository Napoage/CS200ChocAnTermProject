function handleButtonClick(event) {
    event.preventDefault();

    var username = document.getElementsByName('username')[0].value;
    var password = document.getElementsByName('password')[0].value;
if (!username || !password) {
    console.log("Please fill in all the required fields.");
} else if(username == "admin1" || username == "admin2" || username == "admin3"){
    switch(username) {
        case "admin1":
            window.location.href = "OperatorMenuPage.html";
            break;
        case "admin2":
            window.location.href = "ProviderMenuPage.html";
            break;
        case "admin3":
            window.location.href = "ManagerMenuPage.html";
            break;
    }
}else {
    var loginData = {
        username: username,
        password: password
    };

    fetch("http://localhost:8080/api/login/enterLogin", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(loginData)
    })
    .then(response => response.json())
    .then(data => {
        //var result = data.loginResult;
        switch(data) {
            case 1:
                window.location.href = "OperatorMenuPage.html";
                break;
            case 2:
                window.location.href = "ProviderMenuPage.html";
                break;
            case 3:
                window.location.href = "ManagerMenuPage.html";
                break;
            case 0:
                //wont work no windowwindow.location.href = "no username";
                break;
            case -1:
                //wont work no window window.location.href = "no password";
                break;
            case -2:
                //wont work no window window.location.href = "too many failed attempts";
                break;
            default:
                console.error('Invalid result:', result);
                break;
        }
    })
    .catch(error => console.error('Error:', error));
}
}
function handleRunMainAccountingProcedure(event) {
    event.preventDefault();

    fetch("http://localhost:8080/api/login/runMainAccountingProcedure", {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        },
    })
    .then(response => response.json())
    .then(data => {
        openPopup();
    })
    .catch((error) => {
        console.error('Error:', error);
        openPopup();
    });
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
document.getElementById('submitButton').addEventListener('DOMContentLoaded', (event) => {
    handleButtonClick(event);
});
document.getElementById('runMainAccountingProcedure').addEventListener('DOMContentLoaded', (event) => {
    handleRunMainAccountingProcedure(event);
});
document.getElementById('okButton').addEventListener('click', function (event) {
    closePopup(event);
});