<?php
	class Cours {
		private $nom;
		private $nbHeures;
		private $estInformatique;
		private static $HEURESTOTAL = 0;
		const CSS_CLASSINFO = "coursSpec";
		const CSS_CLASSNOM = "nomCours";

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
			return ($this->nbHeures / self::$HEURESTOTAL) * 100." %";
		}

		function sortieHTML(){
			return $this->sortieSimple()." ".$this->ratio();
		}

	}
?>