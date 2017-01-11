<?php
$stock = file_get_contents("http://vm-debian.iesn.be/ig28/LaboAjax/ExRecap/stock.json");
$jsonItem = json_decode($stock, true);


if(isset($_GET['produit'])) {

	$param = $_GET['produit'];

	foreach($jsonItem as $key => $value) {
		if($value["nom"] == $param) {

			if($value["stock"] > 1) {
				$jsonItem[$key]["stock"] = $value["stock"]-1;
			} else {
				$jsonItem[$key]["stock"] = "sold out";
			}
			break;
		}
	}

 	$stockUpdate = json_encode($jsonItem);

	$fp = fopen('stock.json', 'w');
	if (flock($fp, LOCK_EX)) {
		fwrite($fp, $stockUpdate);
		flock($fp, LOCK_UN);
	}
	fclose($fp);
}
?>	