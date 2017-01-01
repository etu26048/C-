<html>
	<head>
		<meta charset = "utf-8" />
		<style>
			form {
				background-color : blue;
			}
			
			fieldset {
				background-color : lightgrey;
				border : 2px solid black;
				border-radius : 6px 6px 6px 6px;
			}
			
			legend {
				background-color : grey;
				border-radius : 10px 10px 10px 10px;
				color : white;
				padding : 6px 6px 6px 6px;
				margin-bottom : 10px; 
				margin-top : 10px;
			}
		
			#submit {
				
				text-align : center;
				padding : 10px 10px 10px 10px;
				margin : 10px 10px 10px 10px;
			}
		</style>
		<script>
			window.onload = function (){
				var libelleMois = ["Janvier",
					"Février",
					"Mars",
					"Avril",
					"Mai",
					"Juin",
					"Juillet",
					"Aout",
					"Septembre",
					"Octobre",
					"Novembre",
					"Décembre"]
				for(let i = 0; i < 12; i++)
				{
					document.getElementById("mois").innerHTML +=("<input type='radio' name='groupRadioMois'>"+libelleMois[i]+"</input><br>");
				}
				
				for(let i = 1; i < 32; i++)
				{
					document.getElementById("naissOption").innerHTML +=("<option name='indiceJour'>"+i+"</option>");
				}
				
				document.getElementById("submit").addEventListener("click",dateValide());
			}		
		
			function dateValide(){
				
				if(!format_is_valid()){
					document.getElementById("commentaire").innerHTML = "Cette date n'est pas valide";
					return false;
				}else{
					return true;
				}
			}
				
			function isLeap(year){
				return (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0));
			}
			
			function lastDay(mois, annee){
				
				if(mois == 2){
					if(isLeap(annee)) return "29";
					else return "28";
				}
				
				if(mois%2 == 0){
					return "30";
				}else return "31";
				
			}
				
			function format_is_valid(date){
				//valid date in dd/mm/yyyy format
				return date.match(/^(0[1-9]|[12][0-9]|3[01])[\- \/.](?:(0[1-9]|1[012])[\- \/.](19|20)[0-9]{2})$/);
			}
						
			function valid_form(){
				
			}
			//http://vm-debian.iesn.be/ig40/showGetPost.php
		</script>
	</head>
	<body>
		
		<form action="anniversaire.php" 
				method="post">
			<fieldset>
				<legend>Identification</legend>
				
				<label name="prenom">Prénom: </label>
				<input name="prenom" for="prenom" type="text" required=true><br>
			</fieldset>
			<fieldset>
				<legend>Date de naissance</legend>
				
				<p><label name="jourNaiss">Jour de naissance: </label>
				<select id="naissOption" for="jourNaiss" onchange="dateValide()"></select><br>
				<span id="commentaire"></span></p>
				
				<label name="moisNaiss">Mois de naissance: </label>
				<ul id="mois" for="moisNaiss" onchange="dateValide()" ></ul>
				
				<label name="AnnéeNaiss">Année de naissance: </label>
				<input name="AnnéeNaiss" for="AnnéeNaiss" type="number" step="1" value="2000" min="1900" max="2050" onchange="dateValide()">
			</fieldset>
			<fieldset>
				<legend>Colonnes à afficher</legend>
				
				<input type="checkbox" for="dateAnnif">
				<label name="dateAnnif">dates d'anniversaire</label>
				<br>
				<input type="checkbox" for="jourAnnif">
				<label name="jourAnnif">jours d'anniversaire</label>
				<br>
				<input type="checkbox" for="age">
				<label name="age">âge</label>
			</fieldset>
			
			<button type="submit" id="submit">Afficher les anniversaires</button>
		</form>
	</body>
</html>