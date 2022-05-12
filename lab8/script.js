/* Global Variables */

var customerArray = [];


/* Functions */

function addClient() {
	/* Client Structure */
	var customer = {};

	/* Selecting checked and typed inputs */
	var currentClient = document.querySelector('.current-client input:checked');
	var clientGender = document.querySelector('input[name="gender[]"]:checked');
	var clientAge = document.getElementById('clientAge');
	var homeStatus = document.querySelector('.home-status input:checked');
	var agi = document.getElementById('annualGrossIncome');

	/* placing inputs into clientInfo array */
	customer.clientInfo = [
		currentClient.value,
		clientGender.value,
		clientAge.value,
		homeStatus.value,
		agi.value
	];

	/* instantiating clientAssets array */
	customer.clientAssets = [];

	/* selecting any checked checkboxes */
	var clientAssetsSelected = document.querySelectorAll('.client-assets input:checked');

	/* pushing selected checkboxes in to clientAssets array */
	for (let i = 0; i < clientAssetsSelected.length; i++) {
		var thisCustomerSelectedAsset = clientAssetsSelected[i].value;
		customer.clientAssets.push(thisCustomerSelectedAsset);
	}


	/* Add the client object to the clientsArray */
	customerArray.push(customer);

	/* call displayClients function */
	displayClients();

}




function displayClients() {

/* Create displayClients variable to store all client info before posting */
var displayClients = "<h2>Registered Clients</h2>";

for (var i = 0; i < customerArray.length; i++) {
	var thisCustomer = customerArray[i];
	
	displayClients += "<h4>Client #"+i+"</h4>";
	

	displayClients += "<ul>";
	displayClients += "<li>Current Client: "+thisCustomer.clientInfo[0]+"</li>";
	displayClients += "<li>Gender: "+thisCustomer.clientInfo[1]+"</li>";
	displayClients += "<li>Client Age: "+thisCustomer.clientInfo[2]+"</li>";
	displayClients += "<li>Home Status: "+thisCustomer.clientInfo[3]+"</li>";
	displayClients += "<li>Annual Gross Income: "+thisCustomer.clientInfo[4]+"</li>";
	displayClients += "<li>Client Assets:<ul>";

	for (var a = 0; a < thisCustomer.clientAssets.length; a++) {
		displayClients += "<li>"+thisCustomer.clientAssets[a]+"</li>";
	}

	displayClients += "</ul></li></ul>";
	
}

/* Place displayClients string in to the display-clients element */
document.getElementById('display-clients').innerHTML = displayClients;

}

function clearForm(){
	var radioButtons = document

}

