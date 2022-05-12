window.onload = initialize; 

function initialize()
{
    var todayDate = new Date();
    document.getElementById('currentDate').innerHTML = todayDate;
}

function calcOrder() {
    var customer = {};
    // Pizzas Section
    var pizzaNumber;
    var pizzaToppings1,pizzaToppings2,pizzaToppings3;
    var toppingCost1 = 0;
    var toppingCost2 = 0;
    var toppingCost3 = 0;
    var pizzaType = [];
    var pizzaSize = [];
    var toppingArray1 = [];
    var toppingArray2 = [];
    var toppingArray3 = [];
    var pizza = {};
    var pizza1,pizza2,pizza3;
    var pizzaSize1 = 0,pizzaSize2 = 0,pizzaSize3 = 0;
    var pizzaNumber1,pizzaNumber2,pizzaNumber3;
    var pizzaCost1,pizzaCost2,pizzaCost3,pizzaCost=0;
    
    pizzaType = document.querySelectorAll('form div input[name="pizzaType[]"]:checked');
    console.log(pizzaType);
    pizzaSize = document.getElementsByName('pizzaSize[]');
    pizzaNumber = document.getElementsByName('numOfPizza[]');
    for(var i=0;i< pizzaType.length;i++)
    {
        if (pizzaType[i].value =='Super Cheesy')
        {
            pizza1 = pizzaType[i].value;
            pizzaSize1 = pizzaSize[i].value;
            pizzaNumber1 = pizzaNumber[i].value;
            switch (pizzaSize1) {
                case 'Small':
                    pizzaCost1 = 8.50;
                    break;
                case 'Medium':
                    pizzaCost1 = 11.50;
                    break;
                case 'Large':
                    pizzaCost1 = 14.00;
                    break;
                case 'Extra Large':
                    pizzaCost1 = 16.50;
                    break;   
                default:
                    pizzaCost1 = 0;
                    break;
            
            }
        }
        else if(pizzaType[i].value == 'Extra Meaty'){
            pizza2 = pizzaType[i].value;
            pizzaSize2 = pizzaSize[i].value;
            pizzaNumber2 = pizzaNumber[i].value;
            switch (pizzaSize2) {
                case 'Small':
                    pizzaCost2 = 8.50;
                    break;
                case 'Medium':
                    pizzaCost2 = 11.50;
                    break;
                case 'Large':
                    pizzaCost2 = 14.00;
                    break;
                case 'Extra Large':
                    pizzaCost2 = 16.50;
                    break;   
                default:
                    pizzaCost2 = 0;
                    break;
            
            }
        }
        else if(pizzaType[i].value =='Really Veggy'){
            pizza3 = pizzaType[i].value;
            pizzaSize3 = pizzaSize[i].value;
            pizzaNumber3 = pizzaNumber[i].value;
            switch (pizzaSize3) {
                case 'Small':
                    pizzaCost3 = 8.50;
                    break;
                case 'Medium':
                    pizzaCost3 = 11.50;
                    break;
                case 'Large':
                    pizzaCost3 = 14.00;
                    break;
                case 'Extra Large':
                    pizzaCost3 = 16.50;
                    break;   
                default:
                    pizzaCost3 = 0;
                    break;
            }
            }
        }

    pizzaToppings1 = document.getElementsByName('pizzaToppings1[]');
    for (var pt = 0; pt < pizzaToppings1.length; pt++){
        
        if (pizzaToppings1[pt].checked == true) {
            toppingCost1 += 1.75;
            toppingArray1.push(pizzaToppings1[pt].value);
        }
    }
    pizzaToppings2 = document.getElementsByName('pizzaToppings2[]');
    for (var pt = 0; pt < pizzaToppings2.length; pt++){
        
        if (pizzaToppings2[pt].checked == true) {
            toppingCost2 += 1.75;
            toppingArray2.push(pizzaToppings2[pt].value);
        }
    }
    pizzaToppings3 = document.getElementsByName('pizzaToppings3[]');
    for (var pt = 0; pt < pizzaToppings3.length; pt++){
        
        if (pizzaToppings3[pt].checked == true) {
            toppingCost3 += 1.75;
            toppingArray3.push(pizzaToppings3[pt].value);
        }
    }
    
    pizzaCost1 = (pizzaCost1 + toppingCost1) * pizzaNumber1;
    pizzaCost2 = (pizzaCost2 + toppingCost2) * pizzaNumber2;
    pizzaCost3 = (pizzaCost3 + toppingCost3) * pizzaNumber3;
    pizzaCost = pizzaCost1 + pizzaCost2 + pizzaCost3;
    customer.costPizza1 = pizzaCost1;
    customer.typePizza1 = pizza1;
    customer.sizePizza1 = pizzaSize1;
    customer.quantityPizza1 = pizzaNumber1;
    customer.toppingsPizza1 = toppingArray1;  
    
    customer.costPizza2 = pizzaCost2;
    customer.typePizza2 = pizza2;
    customer.sizePizza2 = pizzaSize2;
    customer.quantityPizza2 = pizzaNumber2;
    customer.toppingsPizza2 = toppingArray2;  

    customer.costPizza3 = pizzaCost3;
    customer.typePizza3 = pizza3;
    customer.sizePizza3 = pizzaSize3;
    customer.quantityPizza3 = pizzaNumber3;
    customer.toppingsPizza3 = toppingArray3;  
    
    //Sandwiches Section
    var sandwichCost=0;
    var sandwich = {};
    var sandwichType = [];
    var sandwichNumber = [];
    sandwichType  = document.querySelectorAll('input[name="sandwichType[]"]:checked');
    sandwichNumber = document.getElementsByName('totalSandwich[]');
    var sandwich1,sandwich2,sandwich3,sandwich4;
    var sandwichNumber1,sandwichNumber2,sandwichNumber3,sandwichNumber4;
    var sandwichCost1,sandwichCost2,sandwichCost3,sandwichCost4;
    var sandwichTotalCost1,sandwichTotalCost2,sandwichTotalCost3,sandwichTotalCost4;
    for(var i;i<sandwichType.length; i++)
    {
        if(sandwichType[i].value == 'All Garden Vegetarian')
        {
            sandwich1=sandwichType[i].value;
            sandwichNumber1= sandwichNumber[i].value;
            sandwichCost1 = 7.50;
            sandwichTotalCost1 = sandwichNumber1 * sandwichCost1;
        }
        else if(sandwichType[i].value == 'Big Beef on a Bun')
        {
            sandwich2=sandwichType[i].value;
            sandwichNumber2= sandwichNumber[i].value;
            sandwichCost2 = 8.50; 
            sandwichTotalCost2 = sandwichNumber2 * sandwichCost2;
        }
        else if(sandwichType[i].value == 'Mixed Grill')
        {
            sandwich3=sandwichType[i].value;
            sandwichNumber3= sandwichNumber[i].value;
            sandwichCost3 = 9.50;
            sandwichTotalCost3 = sandwichNumber3 * sandwichCost3;  
        }
        else if(sandwichType[i].value == 'Grilled Pork')
        {
            sandwich4=sandwichType[i].value;
            sandwichNumber4= sandwichNumber[i].value;
            sandwichCost4 = 9.50;
            sandwichTotalCost4 = sandwichNumber4 * sandwichCost4;  
        }
    
    }
    sandwichCost = sandwichTotalCost1 + sandwichTotalCost2 + sandwichTotalCost3 +sandwichTotalCost4;
    console.log(sandwichCost);
    customer.costSandwich1 = sandwichTotalCost1;
    customer.typeSandwich1 = sandwich1;
    customer.quantitySandwich1 = sandwichNumber1;

    customer.costSandwich2 = sandwichTotalCost2;
    customer.typeSandwich2 = sandwich2;
    customer.quantitySandwich2 = sandwichNumber2;
    
    customer.costSandwich3 = sandwichTotalCost3;
    customer.typeSandwich3 = sandwich3;
    customer.quantitySandwich3 = sandwichNumber3;

    customer.costSandwich4 = sandwichTotalCost4;
    customer.typeSandwich4 = sandwich4;
    customer.quantitySandwich4 = sandwichNumber4;


    //Drinks Section
    var  drinkCost =0;
    var drink = {};
    var drinkType = [];
    var drinkSize = [];
    var drinkNumber = [];
    var drinkType1,drinkType2,drinkType3,drinkType4;
    var drinkSize1,drinkSize2,drinkSize3,drinkSize4;
    var drinkNumber1,drinkNumber2,drinkNumber3,drinkNumber4;
    var drinkCost1,drinkCost2,drinkCost3,drinkCost4;
    var drinkTotalCost1,drinkTotalCost2,drinkTotalCost3,drinkTotalCost4;
    drinkType = document.querySelectorAll('form div input[name="drinkType[]"]:checked');
    drinkSize = document.getElementsByName('drinkSize[]');
    drinkNumber = document.getElementsByName('totalDrinks[]');
    
    for(var i=0; i<drinkType.length; i++)
    {
        if(drinkType[i].value =='Cola')
        {
            drinkType1 = drinkType[i].value;
            drinkSize1 = drinkSize[i].value;
            drinkNumber1 = drinkNumber[i].value;
            switch (drinkSize1) {
                case 'Small':
                    drinkCost1 = 1.25;
                    break;
                case 'Medium':
                    drinkCost1 = 1.75;
                    break;
                case 'Large':
                    drinkCost1 = 2.00;
                    break;
                default:
                    drinkCost1 = 0;
                    break;
            }
            drinkTotalCost1 = drinkNumber1 * drinkCost1;
        }
        else if(drinkType[i].value =='Orange')
        {
            drinkType2 = drinkType[i].value;
            drinkSize2 = drinkSize[i].value;
            drinkNumber2 = drinkNumber[i].value;
            switch (drinkSize2) {
                case 'Small':
                    drinkCost2 = 1.25;
                    break;
                case 'Medium':
                    drinkCost2 = 1.75;
                    break;
                case 'Large':
                    drinkCost2 = 2.00;
                    break;
                default:
                    drinkCost2 = 0;
                    break;
            }
            drinkTotalCost2 = drinkNumber2 * drinkCost2;
        }
        else if(drinkType[i].value =='Lemon')
        {
            drinkType3 = drinkType[i].value;
            drinkSize3 = drinkSize[i].value;
            drinkNumber3 = drinkNumber[i].value;
            switch (drinkSize3) {
                case 'Small':
                    drinkCost3 = 1.25;
                    break;
                case 'Medium':
                    drinkCost3 = 1.75;
                    break;
                case 'Large':
                    drinkCost3 = 2.00;
                    break;
                default:
                    drinkCost3 = 0;
                    break;
            }
            drinkTotalCost3 = drinkNumber3 * drinkCost3;
        }
        else if(drinkType[i].value =='Root Beer')
        {
            drinkType4 = drinkType[i].value;
            drinkSize4 = drinkSize[i].value;
            drinkNumber4 = drinkNumber[i].value;
            switch (drinkSize4) {
                case 'Small':
                    drinkCost4 = 1.25;
                    break;
                case 'Medium':
                    drinkCost4 = 1.75;
                    break;
                case 'Large':
                    drinkCost4 = 2.00;
                    break;
                default:
                    drinkCost4 = 0;
                    break;
            }
            drinkTotalCost4 = drinkNumber4 * drinkCost4;
        }
    }
    drinkCost = drinkTotalCost1 + drinkTotalCost2 + drinkTotalCost3 + drinkTotalCost4;
    customer.costDrink1 = drinkTotalCost1;
    customer.typeDrink1 = drinkType1;
    customer.sizeDrink1 = drinkSize1;
    customer.quantityDrink1 = drinkNumber1;

    customer.costDrink2 = drinkTotalCost2;
    customer.typeDrink2 = drinkType2;
    customer.sizeDrink2 = drinkSize2;
    customer.quantityDrink2 = drinkNumber2;

    customer.costDrink3 = drinkTotalCost3;
    customer.typeDrink3 = drinkType3;
    customer.sizeDrink3 = drinkSize3;
    customer.quantityDrink3 = drinkNumber3;

    customer.costDrink4 = drinkTotalCost4;
    customer.typeDrink4 = drinkType4;
    customer.sizeDrink4 = drinkSize4;
    customer.quantityDrink4 = drinkNumber4;
    
    //Calculating the Total Cost
    var allCost = {};
    var totalCost=0;
    totalCost = pizzaCost + sandwichCost + drinkCost;
    console.log(totalCost);
    customer.totalCost = totalCost; 
    



    dispOrder(customer);
    
}
    //pizza, sandwich, drink, allCost
    function dispOrder(customer) {    
        var fName, lName, address, phone;
        var receipt = '';
        
        fName = document.getElementById('firstName').value;
        lName = document.getElementById('lastName').value;
        address = document.getElementById('address').value;
        phone = document.getElementById('phone').value;
    
        receipt += '<h3><strong><u>Customer Details</u></strong></h3>';
        receipt += fName + ' ' + lName+'<br>';
        receipt += address+'<br>';
        receipt += phone + '<br>';
        receipt += '<h3><strong><u>Order Details</u></strong></h3>';
        receipt += '<p>' + customer.quantityPizza1 + ' ' + customer.sizePizza1 + ' ' + customer.typePizza1 + ' Pizza  $' + customer.costPizza1.toFixed(2) + '</p>';
        receipt += 'Toppings:'
        receipt += '<ul>';
        for (var pt = 0; pt < customer.toppingsPizza1.length; pt++) {
            receipt += '<li>' + customer.toppingsPizza1[pt] + '</li>';
        }
        receipt += '</ul>';
        receipt += '<p>' + customer.quantityPizza2 + ' ' + customer.sizePizza2 + ' ' + customer.typePizza2 + ' Pizza  $' + customer.costPizza2.toFixed(2) + '</p>';
        receipt += 'Toppings:'
        receipt += '<ul>';
        for (var pt = 0; pt < customer.toppingsPizza2.length; pt++) {
            receipt += '<li>' + customer.toppingsPizza2[pt] + '</li>';
        }
        receipt += '</ul>';
        receipt += '<p>' + customer.quantityPizza3 + ' ' + customer.sizePizza3 + ' ' + customer.typePizza3 + ' Pizza  $' + customer.costPizza3.toFixed(2) + '</p>';
        receipt += 'Toppings:'
        receipt += '<ul>';
        for (var pt = 0; pt < customer.toppingsPizza3.length; pt++) {
            receipt += '<li>' + customer.toppingsPizza3[pt] + '</li>';
        }
        receipt += '</ul>';
        receipt += customer.quantitySandwich1 + ' '  + customer.typeSandwich1 + ' Sandwich  $' + customer.costSandwich1 + '<br>';
        receipt += customer.quantitySandwich2 + ' '  + customer.typeSandwich2 + ' Sandwich  $' + customer.costSandwich2 + '<br>';
        receipt += customer.quantitySandwich3 + ' '  + customer.typeSandwich3 + ' Sandwich  $' + customer.costSandwich3 + '<br>';
        receipt += customer.quantitySandwich4 + ' '  + customer.typeSandwich4 + ' Sandwich  $' + customer.costSandwich4 + '<br>';
        receipt += customer.quantityDrink1 + ' '  + customer.sizeDrink1 + ' ' + customer.typeDrink1 + ' $' + customer.costDrink1 + '<br>';
        receipt += customer.quantityDrink2 + ' '  + customer.sizeDrink2 + ' ' + customer.typeDrink2 + ' $' + customer.costDrink2 + '<br>';
        receipt += customer.quantityDrink3 + ' '  + customer.sizeDrink3 + ' ' + customer.typeDrink3 + ' $' + customer.costDrink3 + '<br>';
        receipt += customer.quantityDrink4 + ' '  + customer.sizeDrink4 + ' ' + customer.typeDrink4 + ' $' + customer.costDrink4 + '<br>';
        receipt += "<p><b>Total Cost : </b>" + "$" + customer.totalCost + "</p>";
        //allCost.totalCost
        document.getElementById('displayOrder').innerHTML = receipt;
    }

