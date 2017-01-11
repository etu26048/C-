<?php

	$nomFichier = "stock.json";
	$fichier = fopen($nomFichier, "r");
	$content = fread($fichier, filesize($nomFichier));
	$items = json_decode($content);
	
	print $items;
	
	if(isset($_GET['produit'])){
		
		if(array_key_exists($_GET['produit'], $items)){
			
			if($items[$_GET['produit']['quantity'] > 1){
				
				$items[$_GET['produit']['quantity'] = $items[$_GET['produit']['quantity'] - 1;
				print $items;
			}
			else
			{
				$items[$_GET['produit']['quantity'] = "sold out";
				print $items;
			}
		}
		fclose($fichier);
		
		$fp = fopen('stock.json', 'w');
		if (flock($fp, LOCK_EX)) {
			fwrite($fp, json_encode($items););
			flock($fp, LOCK_UN);
		}
		fclose($fp);
	}
?>