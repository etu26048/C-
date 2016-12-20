<html> 
  <head> 
    <script>
      /*function goToPHP(){
        location.href = "http://labophp.000webhostapp.com/Labo1/command.php?article="+document.getElementById('Order').value;
      }*/

      //Pourquoi mettre une fonction dans une fonction ?
      function goToPHP(i){
        function act(){
          location.href = "http://labophp.000webhostapp.com/Labo1/command.php?article="+i;
        }
        return act;
      }

      function createButton(i){
        var noeud = document.createElement("button");
        noeud.type = "button";
        noeud.innerHTML = i;
        noeud.onclick = goToPHP(i);
        //l'ajoute à la fin du corps du document
        document.body.appendChild(noeud);
      }
      
      function init(){
        const numMax = <?php
          $nbPoints = 15;
          //Ecrit le nombre de points dans le fichier
          echo $nbPoints;
        ?>;
        <?php
          //Vérifie si il y a un paramètre dans l'URL
          if (isset($_GET) && isset($_GET['ordreCroissant'])) 
            echo 'for (var i = numMax ; i >= 1 ; i--)';
          else
            echo 'for (var i = 1 ; i <= numMax ; i++)';?>
          createButton(i);
      }
      window.onload = init;
    </script>
  </head> 
  <body> 
    <!--Article : 
    <input type="text" name="Order" id="Order">
    <button onclick="goToPHP()">Commande</button>-->
  </body> 
</html> 