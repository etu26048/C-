<html>
	<head>
		<meta charset="utf-8" />
	</head>
	<body>
		<?php
			$x = 5;
			$token = "*!";
			$chaine = '';
			echo 'Premier temps <br>';
			for($i = 0 ;$i < $x; $i++){
				echo $token;
				$chaine.=$token;
			}
			echo '<br>Deuxième temps <br>';
			echo $chaine;

			echo '<br>Modification<br>';
			$x = 7259;
			$tab = [7,2,5,9];

			//$x = array(7,2,5,9);
			for($i = 0; $i < count($tab);$i++) {
				for($j = 0;$j < $tab[$i];$j++) {
					echo "*!";
				}
				echo "<br>";
			}
		?>
	</body>
</html>