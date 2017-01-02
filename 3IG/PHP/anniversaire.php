<html>
	<head>
	</head>
	<body>
		<?php
			
			function createYearColumn(){
				
				for($i = 2015;i <= 2025; i++)
					print "<tr><td>$i</td></tr>";
				
			}
			
			function createBirthdateColumn(){
				print $_POST['indiceJour'].'/'.$_POST['groupRadioMois'].'/'.$_POST['AnnéeNaiss'];
			}
			
			function createBirthdateDayColumn(){
				
			}
			
			function createAgeColumn(){
				
			}
			
			//Permet d'enlever les balises HTML ouvrantes / fermantes
			print "Cher ".strip_tags($_POST['prenom'])."</br>";
			print "Jour naissance ".strip_tags($_POST['indiceJour'])."</br>";
			print "Mois naissance ".strip_tags($_POST['groupRadioMois'])."</br>";
			print "Année naissance ".strip_tags($_POST['AnnéeNaiss'])."</br>";

			print "<table>";
			createYearColumn();
			
			if(isset($_POST['dateAnnif']))
				createBirthdateColumn();
			
			if(isset($_POST['jourAnnif']))
				createBirthdateDayColumn();
			
			if(isset($_POST['age']))
				createAgeColumn();
			
			print "</table>";
		?>
	</body>
</html>