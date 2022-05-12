
function convertFromMiles(miles) {
    var kilometers;
    kilometers = miles *1.60934;
    document.getElementById('kilometers').value = kilometers.toFixed(5);  
}

function convertFromFeet (feet) {
    var meters;
    meters = feet * 0.3048;
    document.getElementById('meters').value = meters.toFixed(4);
}

function convertFromInches (inches) {
    var centimeters;
    centimeters = inches * 2.54;
    document.getElementById('centimeters').value = centimeters.toFixed(2);
}

function convertFromKilometers(kilometers) {
    var miles;
    miles = kilometers *0.621371;
    document.getElementById('miles').value = miles.toFixed(5);
}

function convertFromMeters (meters) {
    var feet;
    feet = meters * 3.28084;
    document.getElementById('feet').value = feet.toFixed(4); 
}

function convertFromCentimeters (centimeters) {
    var inches;
    inches = centimeters *0.393701;
    document.getElementById('inches').value = inches.toFixed(5);
}

function convertFromPounds (Pounds) {
    var grams;
    grams = Pounds *453.592;
    document.getElementById('grams').value = grams.toFixed(3);
}

function convertFromGrams (grams) {
    var pounds;
    pounds = grams *0.00220462;
    document.getElementById('pounds').value = pounds.toFixed(5);
}