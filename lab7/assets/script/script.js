var linkArray=[];


function addLink(){
    var inputLink = document.getElementById('link').nodeValue;
    var protocol="https://";
    var protocolSearch= inputLink.search(protocol);
    if(protocolSearch>=0){
        inputLink = inputLink.substring(protocol.length,inputLink.length);
    }
    
    var newLink="<a target=\"_blank\" href=\"https://"+inputLink+"\">"+inputLink+"</a>";
    linkArray.push(newLink);
    console.log(linkArray);
    displayLink();
}


function displayLink(){
    var linkDisplay="<ul>";
    for(var i=0;i<linkArray.length;i++)
    {
        linkDisplay+="<li>";
        linkDisplay+= linkArray[i];
        linkDisplay+="<li>";
        document.getElementById('link-display').innerHTML+= linkArray[i];
    }
    linkDisplay+="<ul>";
    document.getElementById('link-display').innerHTML+=linkDisplay;
}