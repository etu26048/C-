<?php

	function ligne($ctg,$val1,$val2,$coulF, $coulH) { 
        print "<tr><td>$ctg</td><td>$val1(".pourcentage($val1,$val2).")</td><td>$val2(".pourcentage($val2,$val1).")</td><td>".barre($val1, $val2, $coulF, $coulH, 20)."</td></tr>"; 
    }

    function pourcentage($val1, $val2) {
    	if($val1 >= 0 && $val2 >=0) {
    		$somme = $val1 + $val2;
    		return sprintf('%.2f', ($val1 / $somme * 100))."%";
    	}
    }
		
	function barre($val1, $val2, $coul1, $coul2, $taille = 20){

		if($val1 >= 0 && $val2 >= 0 && $taille >= 0){
			
			$val1 = round(pourcentage($val1, $val2)/10, 0);
			$val2 = round(pourcentage($val2, $val1)/10, 0);
			
			return printByColor($coul2, repete(($taille - $val1), "$")).printByColor($coul1, repete(($taille - $val2), "$"));
		}
	}
	
	function repete($nb, $txt = "$"){
		
		$msg = '';
		for($i = 0; $i < $nb; $i++){
			$msg = $msg.$txt;
		}
		return $msg;
	}
	
	function printByColor($coul, $mes){
		
		return "<span style='color :$coul'>".$mes."</span>";
	}
	
?>