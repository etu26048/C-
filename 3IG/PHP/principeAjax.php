<!doctype html> 
<html> 
  <head> 
    <meta charset="UTF-8" /> 
    <style> 
      mark { 
        border-bottom: 1px dashed blue; 
        background-color: transparent; 
      } 
      footer { 
        min-height: 20px; 
        background-color: beige; 
      } 
	  mark:hover{
		  background-color:darkgrey;
	  }
    </style> 
    <script> 
      var pDef;	
      window.onload = init; 
      function init() { 
        pDef = document.getElementById("pDefinition"); 
		//On récupère toutes les balises mark
		var elements = document.getElementsByTagName("mark");
		//Ensuite on leur associe l'event
		for(let i = 0; i < elements.length; i++){
			elements[i].addEventListener("click",affiche(elements[i].innerHTML));
		}
      } 
	  
	  function affiche(mot){
		  
		  return function(){
			  
			  var req = new XMLHttpRequest();
			  var url = "http://vm-debian.iesn.be/ig10/Labo3/definitions.php?";
			  url+="mot="+mot;
			  //Version asynchrone
			  req.open("GET", url);
			  req.onreadystatechange = function(){
				  if(req.readyState == 4 && req.status == 200){
					  try{
						var object = JSON.parse(req.responseText);
						if(object['trouve']){
							pDef.innerHTML = mot+"<br>"+object['def']+" par ("+object['auteur']+" )<br>Source : "+object['source'];
						}
						else
							pDef.innerHTML = "Aucune définition trouvée";
					  }catch(e){
						  alert("Parsing error : ",e);
					  }
				  }
			  }
			  req.send();
			  //Version synchrone, déconseillé par Mozilla apparemment ...
			  /*req.open("GET","http://vm-debian.iesn.be/ig10/Labo3/definitions.php?mot="+mot,false);
			  req.send();
			  pDef.innerHTML = req.responseText;*/
		  }
	  }
    </script> 
  </head> 
  <body> 
    <h1>Cliquez sur les mots soulignés en pointillés pour obtenir une 
		définition.</h1> 
		<p>Dans une application Web, la méthode <mark>classique</mark> de 
	dialogue entre un <mark>navigateur</mark> et un <mark>serveur</mark> 
	est la suivante : lors de chaque manipulation faite par l'utilisateur, 
	le <mark>navigateur</mark> envoie une <mark>requête</mark> contenant 
	une référence à une page Web, puis le <mark>serveur</mark> Web 
	effectue des calculs, et envoie le résultat sous forme d'une page Web 
	à destination du <mark>navigateur</mark>. Celui-ci affichera alors la 
	page qu'il vient de recevoir. Chaque manipulation entraîne la 
	<mark>transmission</mark> et l'affichage d'une nouvelle page. 
	L'utilisateur doit attendre l'arrivée de la réponse pour effectuer 
	d'autres manipulations.</p> 
		<p>En utilisant <mark>Ajax</mark>, le dialogue entre le 
	<mark>navigateur</mark> et le <mark>serveur</mark> se déroule la 
	plupart du temps de la manière suivante : un programme écrit en 
	langage de programmation <mark>JavaScript</mark>, incorporé dans une 
	page web, est exécuté par le <mark>navigateur</mark>. Celui-ci envoie 
	en arrière-plan des <mark>demandes</mark> au serveur Web, puis modifie 
	le contenu de la page actuellement affichée par le 
	<mark>navigateur</mark> Web en fonction du résultat reçu du 
	<mark>serveur</mark>, évitant ainsi la transmission et l'affichage 
	d'une nouvelle page complète.</p> 
    <footer> 
      <p id="pDefinition"></p> 
    </footer> 
  </body> 
</html> 