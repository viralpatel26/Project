
function changeUnitSystem(unitType) {
	var impInputs, metInputs;
	impInputs = document.querySelectorAll('.imperial input');
	metInputs = document.querySelectorAll('.metric input');
	switch (unitType) {
		case 'imperial':
			//console.log(impInputs);
			for(var i = 0; i < impInputs.length; i++) {
				impInputs[i].disabled = false;
			}
			for(var m = 0; m < metInputs.length; m++) {
				metInputs[m].disabled = true;
			}
			break;
		case 'metric':
			//console.log(metInputs);
			for(var i = 0; i < impInputs.length; i++) {
				impInputs[i].disabled = true;
			}
			for(var m = 0; m < metInputs.length; m++) {
				metInputs[m].disabled = false;
			}
			break;
		default:
			break;
	}
}





function convertFromMiles(miles){
	var feet, inches;

	feet = miles * 5280;
	inches = miles * 63360;

	document.getElementById('feet').value = feet.toFixed(0);
	document.getElementById('inches').value = inches.toFixed(0);

}

function convertFromFeet(feet){
	var miles,inches;

	miles = feet * 0.000189394;
	inches = feet * 12;

	document.getElementById('miles').value = miles.toFixed(5);
	document.getElementById('inches').value = inches.toFixed(2);

}

function convertFromInches(inches){
	var miles, feet;

	miles = inches / 63360;
	feet = inches / 12;

	document.getElementById('miles').value = miles.toFixed(5);
	document.getElementById('feet').value = feet.toFixed(3)
}