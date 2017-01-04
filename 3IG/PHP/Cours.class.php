<?php

	class Cours {

		private $nom;
		private $nbHeures;
		private $estInformatique;
		private static $HEURESTOTAL = 0;
		//Pas de propriété de protection pour les const et pour la classe !!!!!!
		const CSS_CLASSINFO = "coursSpec";
		const CSS_CLASSNOM = "nomCours";

		function __construct($nom, $nbHeures, $estInformatique){
			$this->nom = $nom;
			$this->estInformatique = $estInformatique;
			$this->nbHeures = $nbHeures;
			self::$HEURESTOTAL += $nbHeures;
		}

		function sortieSimple(){
			return $this->nom." pendant ".$this->nbHeures." heure(s)".($this->estInformatique?" (info)":"");
		}

		function ratio(){
			return ($this->nbHeures / self::$HEURESTOTAL) * 100;
		}

		function sortieHTML(){
					
			if($this->estInformatique){
				//print '<link rel="stylesheet" href="$CSS_CLASSINFO.css">'
				return "<span style='color : blue' >".$this->sortieSimple()." ".round($this->ratio(),2)." %</span>";			
			}else{
				//print '<link rel="stylesheet" href="$CSS_CLASSNOM.css">'
				return "<span style='font-weight : bold'>".$this->sortieSimple()." ".round($this->ratio(),2)." %</span>";
			}
		}
		
		function divRatio($long){
			
			$ratio = $this->ratio();
			return "<div style:'height=12px; width:".$long."px; position:relative; background-color:lightgrey; '>
			<div style='height:12px; width:".$ratio." px; position:absolute; top:0;left:0;'></div></div>";
		}

		function getNom(){
			return $this->nom;
		}
		
		function getNbHeures(){
			return $this->nbHeures;
		}
	}
?>