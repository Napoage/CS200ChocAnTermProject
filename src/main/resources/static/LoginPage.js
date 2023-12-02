function handleButtonClick(event) {
    event.preventDefault();

    var usernameIn = document.getElementById('username')[0].value;
    var passwordIn = document.getElementById('password')[0].value;
    
    var loginData = {
        username: usernameIn,
        password: passwordIn
    };

    fetch("http://localhost:8080/enterLogin", {
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
                window.location.href = "no username";
                break;
            case -1:
                window.location.href = "no password";
                break;
            case -2:
                window.location.href = "too many failed attempts";
                break;
            default:
                console.error('Invalid result:', result);
                break;
        }
    })
    .catch(error => console.error('Error:', error));
}

// Attach the function to the button click event
document.getElementById('submitButton').addEventListener('click', function (event) {
    handleButtonClick(event);
});