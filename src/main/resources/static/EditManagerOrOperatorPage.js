function handleButtonClick(event) {
    event.preventDefault();

    var name = document.getElementsByName('Name')[0].value;
    var userName = document.getElementsByName('Username')[0].value;
    var password = document.getElementsByName('Password')[0].value;

    var htmlTitle = document.title;
    if (!name || !userName || !password) {
        alert("Please fill in all fields");
    } else {
        if (htmlTitle === "ChocAnEditOperatorPage") {
            let operator = {
                name: name,
                username: userName,
                password: password
            }
            fetch('http://localhost:8080/api/operator/editOperator', {
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
                        openPopup();
                    } else {
                        window.location.href = 'EditOperatorPage.html';
                    }
                })
                .catch((error) => {
                    console.error('Error:', error);
                });
        } else if (htmlTitle === "ChocAnEditManagerPage") {
            let manager = {
                name: name,
                username: userName,
                password: password
            }
            fetch('http://localhost:8080/api/operator/editManager', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(manager),
            })
                .then(response => response.json())
                .then(data => {
                    console.log('Success:', data);
                    if (data == 0) {
                        openPopup();
                    } else {
                        window.location.href = 'EditManagerPage.html';
                    }
                })
                .catch((error) => {
                    console.error('Error:', error);
                    openPopup();
                });
        }
        window.location.href = "DeveloperMenu.html";
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