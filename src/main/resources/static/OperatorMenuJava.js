var activeDropdown = {};

document.getElementById('Member-dropdown').addEventListener('click', showDropdown);
document.getElementById('Provider-dropdown').addEventListener('click', showDropdown);
document.getElementById('Manager-dropdown').addEventListener('click', showDropdown);
document.getElementById('Operator-dropdown').addEventListener('click', showDropdown);
document.getElementById('addMember').addEventListener('click', handleAddMember);
document.getElementById('removeMember').addEventListener('click', handleRemoveMember);
document.getElementById('editMember').addEventListener('click', handleEditMember);
document.getElementById('addProvider').addEventListener('click', handleAddProvider);
document.getElementById('removeProvider').addEventListener('click', handleRemoveProvider);
document.getElementById('editProvider').addEventListener('click', handleEditProvider);
document.getElementById('addManager').addEventListener('click', handleAddManager);
document.getElementById('removeManager').addEventListener('click', handleRemoveManager);
document.getElementById('editManager').addEventListener('click', handleEditManager);
document.getElementById('addOperator').addEventListener('click', handleAddOperator);
document.getElementById('removeOperator').addEventListener('click', handleRemoveOperator);
document.getElementById('editOperator').addEventListener('click', handleEditOperator);
document.getElementById('goBackButton').addEventListener('click', handleGoBack);







function showDropdown(event) {
  hideActiveDropdown();

  // Your logic for showing the nested dropdown
  var nestedDropdownElement = event.currentTarget.querySelector('.dropdown-selection');
  nestedDropdownElement.classList.add('active');
  
  // Add an event listener to the "Add Member" button
    hideActiveDropdown();
  
    // Your logic for showing the nested dropdown
    var nestedDropdownElement = event.currentTarget.querySelector('.dropdown-selection');
    nestedDropdownElement.classList.add('active');
    
  }
  
  // Additional logic specific to the nested dropdown if needed
function handleEntityAction(entity, action) {
  // Your logic for handling the entity action button click
  event.preventDefault();

  // Define the base URL for the entity actions
  var baseUrl = action + entity + "Page.html";

  // Redirect to the constructed URL
  window.location.href = baseUrl;

  // Add your functionality here, such as opening a modal or performing an action.
}

// Usage examples for each entity and action
function handleAddMember() {
  handleEntityAction("Member", "Add");
}

function handleEditMember() {
  handleEntityAction("Member", "Edit");
}

function handleRemoveMember() {
  handleEntityAction("Member", "Remove");
}

function handleAddProvider() {
  handleEntityAction("Provider", "Add");
}

function handleRemoveProvider() {
  handleEntityAction("Provider", "Remove");
}
function handleEditProvider() {
  handleEntityAction("Provider", "Edit");

}
function handleAddManager() {
  handleEntityAction("Manager", "Add");
}

function handleEditManager() {
  handleEntityAction("Manager", "Edit");
}

function handleRemoveManager() {
  handleEntityAction("Manager", "Remove");
}

function handleAddOperator() {
  handleEntityAction("Operator", "Add");
}

function handleEditOperator() {
  handleEntityAction("Operator", "Edit");
}

function handleRemoveOperator() {
  handleEntityAction("Operator", "Remove");
}
function handleGoBack(event) {
  event.preventDefault();
  window.location.href = "LoginPage.html";
}



function hideActiveDropdown() {
  if (activeDropdown.element) {
    activeDropdown.element.classList.remove('active');
  }
}

window.onclick = function (event) {
  // Close the active dropdown if the clicked element is not a dropdown button or part of the active dropdown
  if (!event.target.classList.contains('dropdown-button') && !event.target.closest('.dropdown-selection')) {
    hideActiveDropdown();
  }
};