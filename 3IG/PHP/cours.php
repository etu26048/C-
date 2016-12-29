<html> 
  <head> 
  	<meta charset="utf-8" />
    <?php

        $programme[] = new Cours ("Business Intelligence", 50, false); 
        $programme[] = new Cours ("Environnements de développement de logiciel", 65, true); 
        $programme[] = new Cours ("Programmation mobile", 50, true); 
        $programme[] = new Cours ("Programmation web orientée objet", 45, true); 
        $programme[] = new Cours ("Développement d'applications web", 25, true); 
        $programme[] = new Cours ("BDD avancées", 55, true); 
        $programme[] = new Cours ("Langues", 50, false); 
        $programme[] = new Cours ("Stage", 320, true); 
        $programme[] = new Cours ("TFE", 25, true); 

        function __autoload($classe){
          require_once "$classe.class.php";
        }

      ?>  
  </head> 
  <body> 
    <h1>Vos cours</h1>
	<?php
	
		foreach($programme as $cours){
			  echo $cours->sortieSimple();
			  echo " pour ".$cours->ratio()." du cursus.";
		}
    ?>
  </body> 
</html>