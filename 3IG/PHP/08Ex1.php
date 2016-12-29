<!Doctype html>
<html>
	<head>
	
		<meta charset="utf-8" />
		<style>
			#div1{
				border : 2px solid black;
				width : 600px;
				height : 400px; 
				position : relative;
			}
		
			.flyingButton{
				position : absolute;
				width : 100px;
				height : 30px;
			}
		
			#para1{
			  width : 600px;
			  background-color: lightgrey;
			  border: 1px solid darkgrey;
			}
		</style>
		<script src="flyingButton.js"></script>
		<script>
			function init(){
				
				let f_random = getRandomInt(2, 10);
				let s_random = getRandomInt(2, 10);
				
				document.getElementById("para1").innerHTML = `Que vaut ${f_random} x ${s_random}`;
				let div = document.getElementById("div1");
				
				let y = getRandomInt(0, 350);
				let x = getRandomInt(0, 550);
				
				let button1 = new FlyingButton(`${f_random} x ${s_random} = ${f_random*s_random}`, redirectTo(f_random, s_random, (f_random*s_random)));
				let button2 = new FlyingButton(`${f_random} x ${s_random} = ${f_random+s_random}`, redirectTo(f_random, s_random, f_random+s_random));
				let button3 = new FlyingButton(`${f_random} x ${s_random} = ${(f_random*s_random) + 2}`, redirectTo(f_random, s_random, (f_random*s_random) + 2));
				let button4 = new FlyingButton(`${f_random} x ${s_random} = ${(f_random*s_random) + 6}`, redirectTo(f_random, s_random, (f_random*s_random) + 6));
				
				button1.setPosition(x, y);
				
				y = getRandomInt(0, 350);
				x = getRandomInt(0, 550);
				button2.setPosition(x, y);
				
				y = getRandomInt(0, 350);
				x = getRandomInt(0, 550);
				button3.setPosition(x, y);
				
				y = getRandomInt(0, 350);
				x = getRandomInt(0, 550);
				button4.setPosition(x, y);
				
				//On doit ajouter un élément du DOM (ici button créé via la fonction)
				div.appendChild(button1.button);
				div.appendChild(button2.button);
				div.appendChild(button3.button);
				div.appendChild(button4.button);
				
				//Mozilla plante
				/*while(1){
					button1.move();
				}*/
				
			}
			
			function getRandomInt(min, max) {
			  min = Math.ceil(min);
			  max = Math.floor(max);
			  return Math.floor(Math.random() * (max - min)) + min;
			}
	
			function redirectTo(nombre1, nombre2, reponse){
				return function(){
					location.href = "http://labophp.000webhostapp.com/Labo3/verification.php?nombre1="+nombre1+"&nombre2="+nombre2+"&reponse="+reponse;
				}
			}
			
			window.onload = init;
		
		</script>
	</head>
	<body>
		<p id = "para1"></p>
		<div id = "div1">
		</div>
		<p>Cliquez sur le réponse correcte ! </p>
	</body>
</html>