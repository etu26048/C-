<?php
	function ligne($ctg,$val1,$val2) { 
        echo "<tr><td>$ctg</td><td>$val1(".pourcentage($val1,$val2).")</td><td>$val2(".pourcentage($val1,$val2).")</td><td></td></tr>"; 
    }

    function pourcentage($val1, $val2) {
    	if($val1 >= 0 && $val2 >=0) {
    		$somme = $val1 + $val2;
    		return sprintf('%.2f', ($val1 / ($somme * 100)))."% et ".sprintf('%.2f',($val2 / $somme * 100))."%";
    	}
    }
