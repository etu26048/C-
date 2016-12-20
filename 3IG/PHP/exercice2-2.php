<html> 
  <head> 
  	<meta charset="utf-8" />
  </head> 
  <body> 
  	<!-- Version PHP utilisable que là où c'est nécéssaire -->
  	<!--<p>
 	<?php
 		$nom = 'Homer';
 		$domaine = 'l\'énergie nucléaire';
 		$etude = true;
 		$salaire = 3000;
 	?>
 	Je m'appelle <?php echo $nom; ?> <br>
 	<?php 
 		//Le if raccourci à faire autrement
 		//$etude ? echo : 'j\'étudie' : echo 'j\'ai étudié';
 		if($etude)
 			echo " j'étudie ";
 		else
 			echo " j'ai étudié ";
 		echo $domaine;
 	?><br>
 	Je voudrais gagner <?php echo $salaire; ?>
 	par mois
 	</p>-->
 	<!--Version partout PHP-->
 	<?php
 		$nom = 'Homer';
 		$domaine = 'l\'énergie nucléaire';
 		$etude = true;
 		$salaire = 3000;

 		echo 'Je m\'appelle ';
 		echo $nom;
 		if($etude)
 			echo ' J\'étudie ';
 		else
 			echo ' J\'ai étudié ';
 		echo $domaine;
 		echo 'Je voudrais gagner ';
 		echo $salaire;
 	?>
  </body> 
</html> 