function FlyingButton(text, eventFunction){
	
	this.text = text;
	this.button = document.createElement("button");
	this.button.classList.add("flyingButton");
	this.button.innerHTML = this.text;
	this.button.addEventListener("click", eventFunction);
	this.elem = this.button;
	this.buttons = [];
	this.buttons.push(this);
}


FlyingButton.prototype.setPosition = function(posX, posY){
	
	this.elem.clientWidth = posY;
	this.elem.clientHeight = posX;
	this.elem.style.top = posY + "px";
	this.elem.style.left = posX+ "px";
}

FlyingButton.prototype.move = function(){
	
	let vitesse_x = getRandomInt(-3, 3);
	let vitesse_y = getRandomInt(-3, 3);
	
	let posX = this.elem.clientHeight += vitesse_x;
	
	if(posX < 0 || (posX + this.elem.style.width) > 600){
		vitesse_x = vitesse_x * (-1);
		posX = this.elem.clientHeight += vitesse_x;
	}
	
	let posY = this.elem.clientWidth += vitesse_y;

	if(posY < 0 || (posY + this.elem.style.height) > 400){
		vitesse_y = vitesse_y * (-1);
		posY = this.elem.clientWidth += vitesse_y;
	}
	
	this.setPosition(posX, posY);
}

FlyingButton.prototype.moveAll = function(){
	
	/*for(let i = 0; i < this.buttons.length; i++){
		this.buttons[i].move();
	}*/
	this.buttons.forEach(this.move());
	
}

FlyingButton.prototype.startMove = function(){
	
	let idInterval = null;
	clearInterval(idInterval);
	idInterval = setInterval(this.moveAll, 30);
}
