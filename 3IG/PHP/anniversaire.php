<html>
	<head>
	</head>
	<body>
		<?php
			
			//Permet d'enlever les balises HTML ouvrantes / fermantes
			print strip_tags($_POST['prenom'])."</br>";
			print "Jour naissance".$_POST['indiceJour']."</br>";
			print "Mois naissance".$_POST['groupRadioMois']."</br>";
			print "Année naissance".strip_tags($_POST['AnnéeNaiss'])."</br>";

		?>
	</body>
</html>