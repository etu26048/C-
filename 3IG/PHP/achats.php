<?php
	session_start();
	if(!isset($_SESSION['order']))
		$_SESSION['order'] = array();
	if(isset($_GET['clear']))			
		unset($_SESSION['order']);	
?>
<!DOCTYPE html>
<html> 
  <head> 
    <meta charset="utf-8" /> 
    <title>Achetez nos jeux !</title> 
	<style>
		body { 
		  background-color: black; 
		  font-family: "comic sans MS"; 
		  font-size: 80%; 
		} 
		#wrapper { 
		  width: 800px; 
		  background-color: beige; 
		  padding: 10px; 
		} 
		header { 
		  background-color: orange; 
		  padding: 10px; 
		  margin-bottom: 10px; 
		  display: flex; 
		  justify-content: space-around; 
		} 
		header button { 
		  width: 150px; 
		} 
		#main { 
		  text-align: center; 
		} 
		#main p { 
		  font-weight: bold; 
		} 
		#main table { 
		  margin-left: auto; 
		  margin-right: auto; 
		} 
		#basket { 
		  margin-top: 6px; 
		  padding: 6px; 
		  border: 2px solid orange; 
		} 
		#basket h2 { 
		  margin-top: 0; 
		  border-bottom: 2px solid darkorange; 
		} 
		#items tr:hover { 
		  background-color: orange; 
		}
	</style>
	<script>
	
		window.onload =  function(){
	
			document.getElementById("bRPG").addEventListener("click", goToRPG('rpg'));
			document.getElementById("bNonRPG").addEventListener("click", goToRPG('nonrpg'));
			document.getElementById("bEmpty").addEventListener("click", clear());
		}

		function goToRPG(genre){
			
			return function(){
				document.location.href = "http://vm-debian.iesn.be/ig10/Labo3/achats.php?games="+genre.trim();
			}
		}
		
		function ordering(genre, game_name){
	
			//pas besoin de return function(), pq ? aucune idée
			document.location.href = "http://vm-debian.iesn.be/ig10/Labo3/achats.php?games="+genre.trim()+"&order="+game_name.trim();
		}
		
		function clear(){
			
			return function(){
				document.location.href = "http://vm-debian.iesn.be/ig10/Labo3/achats.php?clear=true";
			}
		}
	</script>
  </head> 
  <body> 
	  <?php
		
		//BUGGGGGGGGGGGGGGGGGGGGG
		if(isset($_GET['games'])){

			$genre = $_GET['games'];
			
			if(strcmp($genre, "rpg") == 0){
				
				$nomFichier = "rpg";
				$fichier = fopen("rpg.json", "r"); //Ouverture du fichier en lecture
				$contenu = fread($fichier, filesize("rpg.json"));
				$items = json_decode($contenu, true);
			}
			
			if(strcmp($genre, "nonrpg") == 0){
				
				$nomFichier = "nonrpg";
				$fichier = fopen("nonrpg.json", "r"); //Ouverture du fichier en lecture
				$contenu = fread($fichier, filesize("nonrpg.json"));
				$items = json_decode($contenu, true);
			}
		}
		
		?>
    <div id="wrapper"> 
 
      <!-- EN-TETE --> 
      <header> 
        <button id="bRPG">Jeux de rôle</button> 
        <button id="bNonRPG">Autres jeux</button> 
        <button id="bCommande">Passer commande</button> 
        <button id="bEmpty">Vider votre panier</button> 
      </header> 
 
      <!-- MESSAGE ET LISTE DES ARTICLES --> 
	  
      <div id="main"> 
		<?php
			if(isset($_GET['order']) && isset($_GET['games'])){
				
				$game_name = $_GET['order'];
				$genre = $_GET['order'];
				$items = json_decode($contenu, true);
				$trouve = 0;
				foreach($items as $row => $games){
					if(strcmp($row, "$game_name") == 0){
						$trouve = 1;
						print "Commande : ".$game_name." ajouté";
						print "<br>";
						array_push($_SESSION['order'], array('name' => $row,
							  'price' => $games['price']));
						break;//Return
					}
				}
				if($trouve == 0)
					print "Commande : ".$game_name." incorrect !";
					
				
			}
		
		?>
        <div id="items"> 
		<?php

			print "<table><tr><th>Jeu</th><th>Prix</th><th>Genre</th><th>Editeur</th>";
			foreach($items as $row => $games){
				
				print "<tr><td>$row</td>";
				foreach($games as $game){
					if(strcmp("$games", "price") == 0)
						print "<td>$game&euro;</td>";
					else
						print "<td>$game</td>";
				}
				print "<td><button onclick='ordering(\"".$nomFichier."\", \"".$row."\")'>Commander</button></td>";
				print "</tr>";
			}
			print "</table>";
		?>
        </div> 
      </div> 
 
      <!-- PANIER --> 
      <div id="basket"> 
        <h2>Votre panier :</h2> 
        <div id="basketContents"> 
		<?php
			$total = 0;
			if(empty($_SESSION['order']))
				print "Votre panier est vide";
			else{
				
				foreach($_SESSION['order'] as $key => $value){
					
					print "-";
					print $value['name']." (";
					print $value['price'].")";
					$total += $value['price'];
					print "<br>";
				}
				print "<br>Total : $total &euro;";
			}
		
		?>
        </div> 
      </div> 
 
    </div> 
  </body> 
</html>