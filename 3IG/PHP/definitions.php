<?php

	$defs = array( 
		"classique" => array("def" => "habituelle", "auteur" => "martin", "source" => "wikipedia" ),
		"serveur" => array("def" => "machine où le site web est hébergé", "auteur" => "jason", "source" => "wikipedia"),
		"navigateur" => array("def" => "programme qui permet de naviguer sur le web", "auteur" => "bhilal", "source" => "wikipedia"),
		"Ajax" => array("def" => "Asynchroneous Javascript and XML", "auteur" => "yasser", "source" => "wikipedia")); 

	if(isset($_GET['mot'])){
		
		if(!array_key_exists($_GET['mot'], $defs)){
			
			$defs[$_GET['mot']]["trouve"] = false;
			print json_encode($defs[$_GET['mot']]);
		}else{
			
			$defs[$_GET['mot']]["trouve"] = true;
			print json_encode($defs[$_GET['mot']]);
		}
	}else{
		print "Appel sans mot à définir";
	}
?>