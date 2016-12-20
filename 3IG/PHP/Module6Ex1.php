<?php

    class Personnage {
        private $nom;
        private $nbPtsVie;

        function subitBlessure($n){
        	if($this->nbPtsVie >= 0)
        		$this->nbPtsVie-=$n;
        	else
        		echo 'Personnage mort';
        }

        function __toString(){
        	return $this->nom." (".$this->nbPtsVie.")";
        }

        function __construct($nom, $pv){
        	$this->nom = $nom;
        	$this->nbPtsVie = $pv;
        }

        function getPV(){
        	return $this->nbPtsVie;
        }

        function getNom(){
        	return $this->nom;
        }

        function afficheEtat(){
    		echo $this->getNom()." : ".$this->getPV()." / ".static::MAXPV;
    	}

    	function blesse($adversaire){
    		$adversaire->subitBlessure(static::DEGAT);
    		echo $this->__toString()." a blessé ".$adversaire;
    	}

    }

    class Guerrier extends Personnage{

    	private $arme;
    	const MAXPV = 25;
    	const DEGAT = 5;

    	function __construct($nom, $pv, $arme){
    		parent::__construct($nom, $pv);
    		$this->arme = $arme;
    	}

    	function __toString(){
    		return parent::__toString().' [G]';
    	}
    	
    }

    class Magicien extends Personnage{
       
       	const MAXPV = 20;
       	const DEGAT = 3;

    	function __construct($nom, $pv){
    		parent::__construct($nom, $pv);
    	}

    	function __toString(){
    		return parent::__toString().' [M]';
    	}
    	
    }


    $perso1 = new Guerrier('Homer', 20, 'une hache');
    $perso2 = new Magicien('Harry', 10);
    echo $perso1;
 	echo $perso2;
 	$perso1->afficheEtat();
 	$perso2->afficheEtat();

 	$perso1->blesse($perso2);
 	$perso2->afficheEtat();

 	$perso2->blesse($perso1);
 	$perso1->afficheEtat();
 	
?>