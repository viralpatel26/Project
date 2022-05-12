window.onload = initialize;
function initialize(){
    var todayDate= new Date();
    document.getElementById('currentDate').innerHTML= todayDate;
}
function calcOrder(){
    var pizzaType,pizzaSize,numOfPizzas,numOfPizzaToppings,pizzaCost;
    var toppingCost=0;
    var toppingArray=[];
    var pizza ={};
    pizzaType=document.querySelector('form div input[name ="pizzaType[]"]:checked').value;
    pizzaSize=document.getElementById('pizzaSize').value;
    
    switch(pizzaSize)
    {
        case 'Small':
            pizzaCost=8.50;
            break;
        case 'Medium':
            pizzaCost=11.50;
                break;
        case 'Large':
            pizzaCost=14.00;
            break;
        case 'ExtraLarge':
            pizzaCost=16.50;
            break;
        default:
            pizzaCost=0;
            break;
    }
    numOfPizzas=document.getElementById('totalPizza').value;

    numOfPizzaToppings= document.getElementsByName('pizzaTopping[]');
    for(var pt= 0;pt < numOfPizzaToppings.length;pt++)
    {
    if(numOfPizzaToppings[pt].checked == true)
    {
    toppingCost +=1.75;
    toppingArray.push(numOfPizzaToppings[pt].value);
    //toppingArray[pt]=numOfPizzaToppings[pt].value;
    }
    }
    pizzaCost=(pizzaCost+toppingCost)*numOfPizzas;
    pizza.cost=pizzaCost;
    pizza.type = pizzaType;
    pizza.size = pizzaSize;
    pizza.quantity = numOfPizzas;
    pizza.topping= toppingArray;
    dispOrder(pizza);
}
function dispOrder(pizza){
    var fname,lname,address,phone;
    var receipt=' ';
    fname= document.getElementById('firstName').value;
    lname= document.getElementById('lastName').value;
    address= document.getElementById('address').value;
    phone= document.getElementById('phone').value;
    receipt += '<h4> Customer Order</h4>';
    receipt += '<p><b>Full Name:</b>'+ fname +' '+ lname+'</p>';
    receipt += '<p><b>Address:</b>'+ address +'</p>';
    receipt += '<p><b>Phone Number:</b>'+ phone +'</p>';
    receipt += '<h4>Order Details</h4>';
    receipt +='<p>'+pizza.quantity+' '+pizza.size+' '+pizza.type+' $'+ pizza.cost.toFixed(2)+'<p>';
    receipt+= '<ul>'
    for(var pt =0;pt<pizza.topping.length;pt++){
       receipt +='<li>'+pizza.topping[pt]+'<li>';
    }
    receipt+='</ul>';
document.getElementById('displayOrder').innerHTML=receipt;
}

function setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
    var expires = "expires="+d.toUTCString();
    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
  }
  
  function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for(var i = 0; i < ca.length; i++) {
      var c = ca[i];
      while (c.charAt(0) == ' ') {
        c = c.substring(1);
      }
      if (c.indexOf(name) == 0) {
        return c.substring(name.length, c.length);
      }
    }
    return "";
  }

  function checkCookie() {
    var user = getCookie("username");
    if (user != "") {
      alert("Welcome again " + user);
    } else {
      user = prompt("Please enter your name:", "");
      if (user != "" && user != null) {
        setCookie("username", user, 365);
      }
    }