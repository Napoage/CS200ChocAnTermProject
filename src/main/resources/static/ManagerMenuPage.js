function handleMemberButtonClick(event) {
    event.preventDefault();
    fetch('http://localhost:8080/api/inMemberReport/memberReport', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(),
    })
        .then(response => response.json())
        .then(data => {
            console.log('Success:', data);
            if (data != 0) {
              openPopup();
            }
        })
        .catch((error) => {
            console.error('Error:', error);
        });
}
function handleProviderButtonClick(event) {
    event.preventDefault();
    fetch('http://localhost:8080/api/inProviderReport/providerReport', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(),
    })
        .then(response => response.json())
        .then(data => {
            console.log('Success:', data);
            if (data != 0) {
              openPopup();
            }
        })
        .catch((error) => {
            console.error('Error:', error);
        });
}

function handleLogOutButtonClick(event) {
    event.preventDefault();
    window.location.href = "LoginPage.html";
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
document.getElementById('providerReportButton').addEventListener('click', function (event) {
    handleProviderButtonClick(event);
});
document.getElementById('memberReportButton').addEventListener('click', function (event) {
    handleMemberButtonClick(event);
});
document.getElementById('summaryReportButton').addEventListener('click', function (event) {
    handleButtonClick(event, "s");
});
document.getElementById('logOutButton').addEventListener('click', function (event) {
    handleLogOutButtonClick(event);
});
document.getElementById('okButton').addEventListener('click', function (event) {
    closePopup(event);
});