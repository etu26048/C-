<!DOCTYPE html>
<html> 
  <head> 
  	<meta charset="utf-8" />
  </head> 
  <body> 
  	<p>
  	iqjuisheuisfs
  	</p>
  	<p>
 	<?php
 		$nom = 'Homer';
 		$domaine = 'l\'énergie nucléaire';
 		$etude = true;
 		$salaire = 3000;
 	?>
 	Je m'appelle <?php echo $nom ?>
 	<?php 
 		$etude ? echo : 'j\'étudie' : echo 'j\'ai étudié';
 		echo $domaine
 	?>
 	Je voudrais gagner $<?php echo $salaire ?> par mois; 	
 	</p>
  </body> 
</html> 