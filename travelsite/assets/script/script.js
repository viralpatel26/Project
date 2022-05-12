var currentSlide=0;
var slides= document.querySelectorAll('.slide');
var slideInterval = setInterval(slideTransition, 3000);
var overlay= document.querySelector('.overlay');

document.onload=initialize();

function initialize(){
    slides[currentSlide].style.zIndex=1;
}

function nextSlide(){
    overlay.classList.add('hide');
    setTimeout(slideTransition,300);
    setTimeout( function(){
        overlay.classList.remove('hide'); 
    },300)
}

function slideTransition()
{
    currentSlide++;
    if(currentSlide>=slides.length){
        currentSlide=0;
    }

    for (var i = 0; i < slides.length; i++) {
         if(i==currentSlide){
             slides[i].style.zIndex=1;
         }
        else{
            slides[i].style.zIndex=0;
        }
    }
}