var clientArray=[];
document.onload = loadFileForSearch();




function initalize(){
    var searchByIdInput = document.getElementById('searchById');
    searchByIdInput.addEventListener('keyup',function())
}
function loadFileForSearch(){

    var filePath = '.assets/data/ClientData.json';
    var ajax = new XMLHttpRequest();


    ajax.onreadystatechange = function(){
        if(ajax.readyState == 4 && ajax.status == 200)
        {
            clientArray = JSON.parse(ajax.responseText);
            console.log(clientArray);
        }
    }
    ajax.open('GET',filePath,true);
    ajax.send();
}

function searchById(){
    alert('Search is running...');
}