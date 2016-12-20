<html> 
  <head> 
  	<meta charset="utf-8" />
    <?php 
      $coulH = "blue"; 
      $coulF = "red"; 
      require_once("code.php");
     ?> 
     <link rel="stylesheet" type="text/css" href="DemoCss.css">
  </head> 
  <body> 
    <table id="pop"> 
      <tr> 
        <th>Catégorie</th><th>Femmes</th><th>Hommes</th><th>Graphique</th> 
      </tr> 
      <?php 
        ligne("Moins de 18 ans", 1112811, 1164347); 
        ligne("De 18 à 64 ans", 3438304, 3462994); 
        ligne("Plus de 64 ans", 1152835, 877753); 
        ligne("Total", 5703950, 5505094); 
      ?> 
    </table> 
  </body> 
</html>