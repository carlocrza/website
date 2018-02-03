
//-------------------------------------------------------
var hello_text = document.getElementById("hello_text");
//var text_timer = setInterval(animateText, 120);
var text_id = 1;
function animateText() {
	var letter = document.getElementById("hello" + text_id);
	letter.style.visibility = 'visible';
	text_id++;
	if (text_id == 15)
		clearInterval(text_timer);
}

//var allTimer = setInterval(allTime, 100);
var allTimeCount = 0;
function allTime() {
	if ((allTimeCount > 40 && allTimeCount < 50) || (allTimeCount > 80 && allTimeCount < 92)){
		toggleVisibility('penguin_text');
	}
	allTimeCount++;
}
//-------------------------------------------------------

//MOBILE
var isMobile = {
    Android: function() {
        return navigator.userAgent.match(/Android/i);
    },
    BlackBerry: function() {
        return navigator.userAgent.match(/BlackBerry/i);
    },
    iOS: function() {
        return navigator.userAgent.match(/iPhone|iPad|iPod/i);
    },
    Opera: function() {
        return navigator.userAgent.match(/Opera Mini/i);
    },
    Windows: function() {
        return navigator.userAgent.match(/IEMobile/i);
    },
    any: function() {
        return (isMobile.Android() || isMobile.BlackBerry() || isMobile.iOS() || isMobile.Opera() || isMobile.Windows());
    }
};
if (isMobile.any()) {
	var penguin = document.getElementById('penguin');
	penguin.style.display = 'none';
}


//-------------------------------------------------------
function toggleVisibility(id) {
	var e = document.getElementById(id);
	console.log("hello")

	if (e.style.display == 'block')
		e.style.display = 'none';
	else
		e.style.display = 'block';
}

function toggleContact() {
	var contact = document.getElementById('contact');
	var email = document.getElementById('email');
	contact.style.display = 'none';
	email.style.display = 'inline';
}//-------------------------------------------------------


var penguined = 0

function animateElement(id){
	penguined += 1
	if (penguined > 1) {
		return;
	}
	var elem = document.getElementById(id);
	var timer = setInterval(move, 1);

	style = window.getComputedStyle(elem); //to extract style
	a = parseInt(style.getPropertyValue('top'));
	b = parseInt(style.getPropertyValue('right'));
	imgHeight = parseInt(style.getPropertyValue('height'));
	speed = .5;
	movement = add;

	function move(){
		a = movement(a, speed);
		elem.style.top = a + 'px';
		if (a < window.innerHeight / 3 && movement == sub)
			speed = .8
		if (a >= window.innerHeight / 3)
			speed = 1;
		if (a >= window.innerHeight / 1.7)
			speed = 1.5;
		if (a >= window.innerHeight-imgHeight-1){
			clearInterval(timer);
			var bounce = setBounce(elem, a, 150);
			var timer2 = setInterval(bounce, 1);
		}
	}
	function setBounce(elem, pos, height){
		movement = sub;
		count=0;
		var speed = 1;
		function bounce(){
			pos = movement(pos, speed);
			count = inverse(movement)(count, speed);
			if (count < height * .3)
				speed = 2
			else if (count < height *.87)
				speed = 1
			else
				speed = .3
			if (count > height || count < 0)
				movement = inverse(movement);
			if (count < 0)
				height -= 20;
			if (height == 0)
				clearInterval(timer2);
			elem.style.top = pos + 'px';
		}
		return bounce;
	}
}



//GENERAL
function add(...args){
	var sum = 0;
	for (let i = 0; i < args.length; i++)
		sum += args[i];
	return sum;
}

function sub(...args){
	var total = args[0];
	for (let i = 1; i < args.length; i++)
		total -= args[i];
	return total;
}

function inverse(func){
	if (func == add)
		return sub
	else
		return add
}



var currentLink = document.getElementById('first_link');
var currentGroupNum = 1;
openLink(currentLink, currentGroupNum);

function openLink(t, groupNum){
	currentLink.style.background = '#fffbf5';
	t.style.background = '#E6E9FF';
	currentLink = t;

	var group = document.getElementById('link' + groupNum);
	var currentGroup = document.getElementById('link' + currentGroupNum);
	currentGroup.style.display = 'none';
	group.style.display = 'block';
	currentGroupNum = groupNum;

}



