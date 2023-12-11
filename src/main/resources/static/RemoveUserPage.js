function handleButtonClick(event) {
    event.preventDefault();
    console.log("Before if2 statement");
    //need to check if id is empty and need to recieve from a java file if it was successfully removed
    var ID = document.getElementsByName('UserID')[0].value;

    var htmlTitle = document.title;
    console.log(htmlTitle);
    console.log(ID);
    if (!ID) {
        // At least one of the variables is empty
        console.log("Please fill in all the required fields.");
    } else {
        
        if (htmlTitle === "ChocAnRemoveMemberPage") {
            var url = `http://localhost:8080/api/operator/removeMember?memberID=${ID}`;
            fetch(url, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
            })
            .then(response => response.json())
            .then(data => {
                console.log('Success:', data);
                if (data == 1) {
                    console.log('Success');
                    window.location.href = "RemoveMemberPage.html";
                } else {
                    console.log('Failure');
                    //window.location.href = "RemoveMemberPage.html";
                }
            })
            .catch((error) => {
                console.error('Error:', error);
            });
    } else if (htmlTitle === "ChocAnRemoveProviderPage") {
        console.log("Before if3 statement");
        
        var providerID = ID;
        var url = `http://localhost:8080/api/operator/removeProvider?providerID=${providerID}`;
        console.log(providerID);
        fetch(url, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
        })
            .then(response => response.json())
            .then(data => {
                console.log('Success:', data);
            })
            .catch((error) => {
                console.error('Error:', error);
            });
    
    } else if (htmlTitle === "ChocAnRemoveManagerPage") {
        fetch('http://localhost:8080/api/operator/removeManager', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(ID),
        })
            .then(response => response.json())
            .then(data => {
                console.log('Success:', data);
            })
            .catch((error) => {
                console.error('Error:', error);
            });
    } else if (htmlTitle === "ChocAnRemoveOperatorPage") {
        fetch('http://localhost:8080/api/operator/removeOperator', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(ID),
        })
            .then(response => response.json())
            .then(data => {
                console.log('Success:', data);
            })
            .catch((error) => {
                console.error('Error:', error);
            });
    }
}
}

function handlegoBackButtonClick(event) {
    event.preventDefault();
    window.location.href = "OperatorMenuPage.html";
}

// Attach the function to the button click event
document.getElementById('submitButton').addEventListener('click', function (event) {
    console.log("Before if statement");
    handleButtonClick(event);
});
document.getElementById('goBackButton').addEventListener('click', function (event) {
    handlegoBackButtonClick(event);
});