function handleButtonClick(event, report) {
    event.preventDefault();
    if (report = "Bill") {
      window.location.href = "BillPage.html";
    } else if (report = "Directory") {
      fetch('http://localhost:8080/api/provider/requestProviderDirectory', {
          method: 'POST',
          headers: {
              'Content-Type': 'application/json',
          },
      })
          .then(response => response.json())
          .then(data => {
              console.log('Success:', data);
          if (data != 0) {
openPopup();} 
          })
          .catch((error) => {
              console.error('Error:', error);
          });
    }
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
document.getElementById('billChocAnButton').addEventListener('click', function (event) {
    handleButtonClick(event,  "Bill");
});
document.getElementById('providerDirectoryButton').addEventListener('click', function (event) {
    handleButtonClick(event, "Directory");
});
document.getElementById('logOutButton').addEventListener('click', function (event) {
    handleLogOutButtonClick(event);
});
document.getElementById('okButton').addEventListener('click', function (event) {
    closePopup(event);
});