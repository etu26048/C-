<?php
	class Cours {
		private $nom;
		private $nbHeures;
		private $estInformatique;
		private static $HEURESTOTAL = 0;

		function __construct($nom, $nbHeures, $estInformatique){
			$this->nom = $nom;
			$this->estInformatique = $estInformatique;
			$this->nbHeures = $nbHeures;
			self::$HEURESTOTAL += $nbHeures;
		}

		function sortieSimple(){
			return $this->nom." pendant ".$this->nbHeures.($this->estInformatique?"(info)":"");
		}

		function ratio(){
			return ($this->nbHeures / self::$HEURESTOTAL) * 100;
		}

	}

	$programme[] = new Cours ("Business Intelligence", 50, false); 
	$programme[] = new Cours ("Environnements de développement de logiciel", 65, true); 
	$programme[] = new Cours ("Programmation mobile", 50, true); 
	$programme[] = new Cours ("Programmation web orientée objet", 45, true); 
	$programme[] = new Cours ("Développement d'applications web", 25, true); 
	$programme[] = new Cours ("BDD avancées", 55, true); 
	$programme[] = new Cours ("Langues", 50, false); 
	$programme[] = new Cours ("Stage", 320, true); 
	$programme[] = new Cours ("TFE", 25, true); 

	foreach($programme as $cours){
        echo $cours->sortieSimple();
        echo " pour ".$cours->ratio()." du cursus.";
    }


?>