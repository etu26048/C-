<?php
$json = "[{\"nom\":\"Air Max 90\", \"stock\":10},{\"nom\":\"Huarache\", \"stock\":5},{\"nom\":\"Flyknit Lunar 3\", \"stock\":2},{\"nom\":\"Free 5.0\", \"stock\":4},{\"nom\":\"Janoski\", \"stock\":9}]";

$fp = fopen('stock.json', 'w');
fwrite($fp, $json);
fclose($fp);
?>