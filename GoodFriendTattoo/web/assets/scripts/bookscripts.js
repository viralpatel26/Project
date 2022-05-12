/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function validateform() {
    var artist = document.getElementById('artistname').value;
    var name = document.getElementById('name').value;
    var mail = document.getElementById('mail').value;
    var date = document.getElementById('date').value;
    var time = document.getElementById('time').value;

    if (artist == null || artist == "") {
        alert("Please select artist");
        event.preventDefault();
        return false;
    }
    if (name == null || name == "") {
        alert("Name can't be blank");
        event.preventDefault();
        return false;
    }
    if (date == null || date == "") {
        alert("Please select the date");
        event.preventDefault();
        return false;
    }
    if (time == null || time == "") {
        alert("Please select time");
        event.preventDefault();
        return false;
    }
    if (mail == "") {
        alert("Please enter your email address");
        event.preventDefault();
    } 
       
        var regex = /^\S+@\S+\.\S+$/;
        if (regex.test(mail) === false) {
            alert("Please enter a valid email address");
            event.preventDefault();
        } 
    }
