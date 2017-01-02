<!doctype html> 
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
	<script src="achats.js"></script>
  </head> 
  <body> 
	  <?php
		
		//BUGGGGGGGGGGGGGGGGGGGGG
		if(isset($_GET['games'])){

			$genre = $_GET['games'];
			
			if(strcmp($genre, "rpg") == 0){
				$fichier = fopen("rpg.json", "r"); //Ouverture du fichier en lecture
				$contenu = fread($fichier, filesize("rpg.json"));
				$items = json_decode($contenu, true);
			}
			
			if(strcmp($genre, "nonrpg") == 0){
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
			if(isset($_GET['order'])){
				print "Commande : $_GET['order']";
			}
		
		?>
        <div id="items"> 
		<?php

			print "<table><tr><th>Jeu</th><th>Prix</th><th>Genre</th><th>Editeur</th>";
			foreach($items as $row => $games){
				
				print "<tr><td>$row</td>";
				foreach($games as $game){
					/*if(strcmp($game, "price"))
						print "<td>$game &euro;</tr>";
					else*/
						print "<td>$game</td>";
				}
				print "<td><buttonn>Commander</button></td>";
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
        </div> 
      </div> 
 
    </div> 
  </body> 
</html>