<html> 
	<head> 
	</head> 
	<body>
		
		<p>Résultat : 
		
		<?php

			if(isset($_GET) && !isset($_GET['nombre1'])
						&& !isset($_GET['nombre2'])
						&& !isset($_GET['reponse']))
				echo 'Vous ne pouvez pas accéder directement à cette page';
				

			if(isset($_GET) && isset($_GET['reponse']) && isset($_GET['nombre1']) && isset($_GET['nombre2'])){
				$reponse = $_GET['reponse'];
				$nombre1 = $_GET['nombre1'];
				$nombre2 = $_GET['nombre2'];
				
				if(($nombre1 * $nombre2) == $reponse)
					echo 'Réponse correct';
				else
					echo 'Réponse incorrect';
			}

		?>
		</p>
	</body>
</html>