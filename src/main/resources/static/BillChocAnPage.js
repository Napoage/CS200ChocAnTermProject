
function handleButtonClick(event) {
  event.preventDefault();
  console.log("Button clicked");
  var date = document.getElementsByName('Date')[0].value
  var dateRecorded = document.getElementsByName('Date-Recorded')[0].value;
  var memberNumber = document.getElementsByName('memberNumber')[0].value;
  var providerNumber = document.getElementsByName('providerNumber')[0].value;
  var code = document.getElementsByName('serviceCode')[0].value;
  var comments = document.getElementsByName('Comments')[0].value;


  if (!date || !code || !memberNumber || !providerNumber || !dateRecorded) {
    alert('Please fill in all fields');
    openPopup();
  } else {
    fetch('http://localhost:8080/api/provider/billChocAn', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        date: date,
        dateRecorded: dateRecorded,
        code: code,
        memberNumber: memberNumber,
        providerNumber: providerNumber,
        comments: comments
      }),
    })
      .then(response => response.json())
      .then(data => {
        if (data == 0) {
            //openPopup();
        } else {
            window.location.href = 'BillChocAnPage.html';
        }
        console.log('Success:', data);
      })
      .catch((error) => {
        console.error('Error:', error);
        //openPopup();
      });
  }
}

function handleGoBackButtonClick(event) {
  event.preventDefault();
  window.location.href = "ProviderMenuPage.html";
}
/*let popup = document.getElementById("popup");
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
}*

// Attach the function to the button click event
document.getElementById('billChocAnButton').addEventListener('click', function (event) {
  handleButtonClick(event);
});

document.getElementById('goBackButton').addEventListener('click', function (event) {
  handleGoBackButtonClick(event);
});
/*document.getElementById('okButton').addEventListener('click', function (event) {
    closePopup(event);
});*/