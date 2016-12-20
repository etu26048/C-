<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<?php
			$tab = array(
				'Simpson' => array(
					'père' => 'Homer',
					'mère' => 'Marge'),
				'Nahasapeemapetilon' => array ( 
			        'père' => 'Apu', 
			        'mère' => 'Manjula'), 
		    	'van Houten' => array (
		    		'père' => 'Kirk', 
		        	'mère' => 'Luann') 
		    	'Wiggum' => array(
		    		'père' => 'Clancy',
		    		'mère' => 'Sarah')
				);
		?>
		<style>
			.famille {
				text-transform: capitalize;

			}
			.parents {
				font-weight: bold;
			}
		</style>
	</head>
	<body>
		<?php
			echo "<ul>";
			foreach($tab as $famille => $nameF){
				echo "<li class = 'famille'>$famille</li>";
				echo "<ul>";
				foreach($nameF as $parent => $name){
					echo "<li><span class='parents'>$parent</span> : $name</li>";
				}
				echo "</ul>";
			}
			echo "</ul>";

			$tab = array(
				'Simpson' => array(
					'enfant1' => 'Bart',
					'enfant2' => 'Lisa',
					'enfant3' => 'Maggie'),
				'Nahasapeemapetilon' => array ( 
			        'enfant1' => 'esfs', 
			        'enfant2' => 'sef',
			        'enfant3' => 'sef',
			        'enfant4' => 'sf',
			        'enfant5' => 'hu',
			        'enfant6' => 'tfh'), 
		    	'van Houten' => array (
		    		'enfant1' => 'Milhouse') 
		    	'Wiggum' => array(
		    		'enfant1' => 'Ralph')
				);
			echo "<table><tr>";
			foreach($tab as $famille => $nameF){
				echo "<th>$famille</th>";
				//Ce truc là faut le mettre ailleurs 
				echo "</tr>";
				foreach($nameF as $enfant => $name){
					echo "<tr><td>$enfant</td><td>$name</td></tr>";
				}
			}
			echo "</table>";
		?>
	</body>
</html>