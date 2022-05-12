window.onload = initialize; 
var customerArray = [];
var placerOrd =document.getElementById('placeOrder');
var editButton = document.getElementById('editOrder');
function initialize()
{
    var todayDate = new Date();
    document.getElementById('currentDate').innerHTML = todayDate;
}

function calcOrder() {
    // Pizzas Section
    var customer ={};
    var pizzaType, pizzaSize, numOfPizzas, pizzaCost, pizzaToppings;
    var toppingCost = 0;
    var toppingArray = [];
    var pizza = {};
    
    
    pizzaType = document.querySelector('form div input[name="pizzaType[]"]:checked').value;
    
    pizzaSize = document.getElementById('pizzaSize').value;
    
    switch (pizzaSize) {
        case 'Small':
            pizzaCost = 8.50;
            break;
        case 'Medium':
            pizzaCost = 11.50;
            break;
        case 'Large':
            pizzaCost = 14.00;
            break;
        case 'Extra Large':
            pizzaCost = 16.50;
            break;   
        default:
            pizzaCost = 0;
            break;
    
    }
    
    numOfPizzas = document.getElementById('numOfPizza').value;
    
    pizzaToppings = document.getElementsByName('pizzaToppings[]');
    
    for (var pt = 0; pt < pizzaToppings.length; pt++){
        
        if (pizzaToppings[pt].checked == true) {
            toppingCost += 1.75;
            toppingArray.push(pizzaToppings[pt].value);
        }
    
    }
    
    pizzaCost = (pizzaCost + toppingCost) * numOfPizzas;
    
    pizza.cost = pizzaCost;
    pizza.type = pizzaType;
    pizza.size = pizzaSize;
    pizza.quantity = numOfPizzas;
    pizza.toppings = toppingArray;    
    
    //Sandwiches Section
    var sandwichType, totalSandwichs, sandwichCost;
    var sandwich = {};
    
    sandwichType  = document.querySelector('form div input[name="sandwichType[]"]:checked').value;
    
    switch (sandwichType) {
        case 'All Garden Vegetarian':
            sandwichCost = 7.50;
            break;
        case 'Big Beef on a Bun':
            sandwichCost = 8.50;
            break;
        case 'Mixed Grill':  
            sandwichCost = 9.50;
            break;
        case 'Grilled Pork': 
            sandwichCost = 9.50;
            break;   
        default:
            sandwichCost = 0;
            break;
    
    }
    
    
    totalSandwichs = document.getElementById('totalSandwich').value;
    sandwichCost = sandwichCost * totalSandwichs; 
    sandwich.cost = sandwichCost;
    sandwich.type = sandwichType;
    sandwich.quantity = totalSandwichs;
    
    //Drinks Section
    var drinkType, drinkSize, totalDrink, drinkCost;
    var drink = {};
    drinkType = document.querySelector('form div input[name="drinkType[]"]:checked').value;
    
    drinkSize = document.getElementById('drinkSize').value;
    
    switch (drinkSize) {
        case 'Small':
            drinkCost = 1.25;
            break;
        case 'Medium':
            drinkCost = 1.75;
            break;
        case 'Large':
            drinkCost = 2.00;
            break;
        default:
            drinkCost = 0;
            break;
    
    }
    
    totalDrink = document.getElementById('totalDrinks').value;  
    
    drinkCost = drinkCost * totalDrink;
    
    drink.cost = drinkCost;
    drink.type = drinkType;
    drink.size = drinkSize;
    drink.quantity = totalDrink;
    
    var totalCost = pizza.cost + sandwich.cost + drink.cost;
    customer.details =[pizzaType,pizzaSize,numOfPizzas,pizzaCost,numOfPizzas,toppingArray,
                        sandwichType,totalSandwichs,sandwichCost,
                        drinkType,drinkSize,totalDrink,drinkCost];
    customerArray.push(customer);
    document.getElementById('placeOrder').disable = true;
    
    dispOrder(pizza,sandwich,drink,totalCost);
    }
    
    function dispOrder(pizza, sandwich, drink, totalCost) {    
        var fName, lName, address, phone;
        var receipt = '';
        var z=1;
        fName = document.getElementById('firstName').value;
        lName = document.getElementById('lastName').value;
        address = document.getElementById('address').value;
        phone = document.getElementById('phone').value;
    
        receipt += '<h3><strong><u>Customer Details</u></strong></h3>';
        receipt += fName + ' ' + lName+'<br>';
        receipt += address+'<br>';
        receipt += phone + '<br>';
        receipt += '<h3><strong><u>Order Details</u></strong></h3>';
        receipt += '<p>' + pizza.quantity + ' ' + pizza.size + ' ' + pizza.type + ' Pizza  $' + pizza.cost.toFixed(2) + '</p>';
        receipt += 'Toppings:'
        receipt += '<ul>';
        for (var pt = 0; pt < pizza.toppings.length; pt++) {
            receipt += '<li>' + pizza.toppings[pt] + '</li>';
        }
        receipt += '</ul>';
        receipt += sandwich.quantity + ' '  + sandwich.type + ' Sandwich  $' + sandwich.cost.toFixed(2) + '<br>';
        receipt += drink.quantity + ' '  + drink.size + ' ' + drink.type + ' $' + drink.cost.toFixed(2) + '<br>';
        receipt += "<p><b>Total Cost : </b>" + "$" + totalCost + "</p>";
        receipt += "<button onclick=\"editOrder("+z+")\">Edit Order</button>";
        document.getElementById('displayOrder').innerHTML = receipt;
    }

    function editOrder(z){
        placerOrd.disabled = true;
        editButton.disabled = false;

        editButton.addEventListener('click',function(){
            calcOrder();
        });

        var editCustomer = customerArray[0];
        var pizzaType = document.querySelector('form div input[name="pizzaType[]"]');
        var pizzaSize = document.getElementById('pizzaSize');
        var numOfPizzas = document.getElementById('numOfPizza');
        var pizzaToppings = document.getElementsByName('pizzaToppings[]');
        var sandwichType  = document.querySelector('form div input[name="sandwichType[]"]');
        var totalSandwichs = document.getElementById('totalSandwich');
        var drinkType = document.querySelector('form div input[name="drinkType[]"]:checked');
        var drinkSize = document.getElementById('drinkSize');
        var totalDrink = document.getElementById('totalDrinks');


        for (let i = 0; i < pizzaType.length; i++) {
            if(pizzaType[i].value == editCustomer.details[0]){
            pizzaType[i].checked = true;
            }
        }
        pizzaSize.value = editCustomer.details[1];
        numOfPizzas.value = editCustomer.details[2];


        for (let i = 0; i < pizzaToppings.length; i++) {
            var thisInput = pizzaToppings[i];
            for (let a = 0; a < editCustomer.details[5].length; a++) {
                var thisCustomerVa = editCustomer.details[a];
                if(thisCustomerVa == thisInput.value){
                    thisInput.checked = true;
                    }                  
            }
        }
        for (let i = 0; i < sandwichType.length; i++) {
            if(sandwichType[i].value == editCustomer.details[6]){
            sandwichType[i].checked == true;
            }
        }
        totalSandwichs.value = editCustomer.details[7];
        for (let i = 0; i < drinkType.length; i++) {
            if(drinkType[i].value == editCustomer.details[9]){
            pizzaType[i].checked == true;
            }
        }
        for (let i = 0; i < drinkSize.length; i++) {
            if(drinkSize[i].value == editCustomer.details[10]){
            drinkSize[i].checked == true;
            }
        }
        totalDrink.value = editCustomer.details[11];
    }