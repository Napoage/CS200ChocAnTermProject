

function handleButtonClick(event) {
    event.preventDefault();
    var name = document.getElementsByName('Name')[0].value;
    var address = document.getElementsByName('Address')[0].value;
    var city = document.getElementsByName('City')[0].value;
    var state = document.getElementsByName('StateCode')[0].value;
    var zipCode = document.getElementsByName('ZipCode')[0].value;
    var email = document.getElementsByName('Email')[0].value;
    console.log(memberID, name, address, city, state, zipCode, email);
    var htmlTitle = document.title;
    var Role;

    if (!name || !address || !city || !state || !zipCode || !email) {
        console.log("Please fill in all fields");
    } else {
        if (htmlTitle === "ChocAnEditMemberPage") {
            var memberID = document.getElementsByName('MemberNumber')[0].value;
            let url = `http://localhost:8080/api/operator/editMember?memberID=${memberID}&name=${name}&email=${email}&address=${address}&city=${city}&state=${state}&zipCode=${zipCode}&status=true`;
            // If the title matches, assign a value to a variable
            fetch(url, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
            })
            .then(response => response.json())
            .then(data => {
                console.log('Success:', data);
                if (data == 0) {
                    openPopup();
                } else {
                    //window.location.href = 'EditMemberPage.html';}
                    console.log('Success');
                }
            })
                .catch((error) => {
                    console.error('Error:', error);
                    openPopup();
                });
        } else if (htmlTitle === "ChocAnEditProviderPage") {
            // If the title matches, assign a value to a variable
            var providerID = document.getElementsByName('ProviderNumber')[0].value;
            var providerName = name;
            var providerAddress = address;
            var providerCity = city;
            var providerStateCode = state;
            var providerZipCode = zipCode;
            var providerEmail = email;
            var username = document.getElementsByName('userName')[0].value;
            var password = document.getElementsByName('password')[0].value;
            fetch('http://localhost:8080/api/operator/editProvider', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({
                    providerName: providerName,
                    providerAddress: providerAddress,
                    providerCity: providerCity,
                    providerStateCode: providerStateCode,
                    providerZipCode: providerZipCode,
                    providerEmail: providerEmail,
                    providerStatus: true,
                    username: username,
                    password: password,
                    providerID: providerID,
                }),
            })
                .then(response => response.json())
                .then(data => {
                    console.log('Success:', data);
            if (data == 0) {
                openPopup();
            } else {
                window.location.href = 'EditProviderPage.html';
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

document.getElementById('submitButton').addEventListener('click', function (event) {
    handleButtonClick(event);
});

document.getElementById('goBackButton').addEventListener('click', function (event) {
    handlegoBackButtonClick(event);
});
document.getElementById('okButton').addEventListener('click', function (event) {
    closePopup(event);
});