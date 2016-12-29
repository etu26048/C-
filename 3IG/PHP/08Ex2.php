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
				let libelleMois = ["Janvier",
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
					document.getElementById("mois").innerHTML +=("<input type='radio' name='groupRadioMois'><label name='moisSelection'>"+libelleMois[i]+"</label><br>");
				}
				
				for(let i = 1; i < 32; i++)
				{
					document.getElementById("naissOption").innerHTML +=("<option>"+i+"</option>");
				}
			}		
		
			function dateValide(date){
				
				function isLeap(year){
					return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
				}
				
				function lastDay(){
					
				}
				
				function format_is_valid(date){
					//valid date in dd/mm/yyyy format
					return date.match(/^(0[1-9]|[12][0-9]|3[01])[\- \/.](?:(0[1-9]|1[012])[\- \/.](19|20)[0-9]{2})$/);
				}
				
				if(!date_is_valid())
					document.getElementById("commentaire").innerHTML = "Cette date n'est pas valide";
			}
				
			function valid_form(){
				
			}
		</script>
	</head>
	<body>
		<form action="http://vm-debian.iesn.be/ig40/showGetPost.php" 
				method="post">
			<fieldset>
				<legend>Identification</legend>
				
				<label name="prenom">Prénom: </label>
				<input name="prenom" for="prenom" type="text" required=true><br>
			</fieldset>
			<fieldset>
				<legend>Date de naissance</legend>
				
				<p><label name="jourNaiss">Jour de naissance: </label>
				<select id="naissOption" for="jourNaiss"></select><br>
				<span id="commentaire"></span></p>
				
				<label name="moisNaiss">Mois de naissance: </label>
				<ul id="mois" for="moisNaiss" ></ul>
				
				<label name="AnnéeNaiss">Année de naissance: </label>
				<input for="AnnéeNaiss" type="number" step="1" value="2000" min="1900" max="2050">
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
			
			<button type="submit" id="submit" onclick="valid_form()">Afficher les anniversaires</button>
		</form>
	</body>
</html>