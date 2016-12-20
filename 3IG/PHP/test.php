<html> 
  <head> 
    <link rel="stylesheet" href="test.css"/>
    <script>
      function afficheHeure(){
        let heure = new Date();
        heure = heure.toLocaleTimeString();
        document.write(heure);
      }
    </script>
  </head> 
  <body> 
    <div>
    <h1>Bienvenue !</h1> 
      <p id="display_hours">Il est actuellement 
        <?php 
          $heure = date('H:i'); 
          echo $heure; 
        ?> 
        sur le serveur et <script>afficheHeure()</script> sur le navigateur et tout va très bien.</p> 
        <?php
          echo '<img src="../Images/Logo_php.jpg" width="150px" height="150px"/>'
        ?>
      <p>C'est <?php
          $jour = date('j');
          if($jour < 15)
            echo 'le début';
          else
            echo 'la fin'
        ?>
       du mois.
      </p>
      <p>Et nous somme le <?php
          $date = date('j/m/Y');
          echo $date;
        ?>
      </p>
      <p class="lorem">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris non maximus ipsum, consectetur blandit ante. Nam quis maximus ante. Integer ultricies, erat sit amet porttitor feugiat, arcu mauris suscipit ex, sit amet imperdiet diam nisl et neque. In at risus scelerisque, placerat massa quis, ornare purus. Phasellus rutrum dui eu massa elementum bibendum. Nam nec nibh in erat placerat iaculis non tristique nisl. Fusce condimentum blandit tristique. Vivamus bibendum nec odio nec luctus. Sed sit amet urna non tortor aliquet tempus. Maecenas eu magna nunc. Nunc id semper nibh. Nullam lobortis tellus ut sollicitudin cursus.</p>

      <p class="lorem">Pellentesque laoreet ipsum convallis facilisis iaculis. Donec felis ligula, egestas sit amet dignissim a, fermentum et sem. Duis facilisis pretium nibh, vitae auctor nulla aliquam sed. Cras eu dui sed urna fermentum tempus. Nunc sit amet semper nulla. Aliquam vel lacus molestie, ultrices tortor sed, lacinia risus. Donec rutrum bibendum accumsan. Morbi elementum vitae ex eu viverra. Vestibulum venenatis, massa iaculis molestie aliquam, mi sem mollis libero, a vulputate diam nibh sit amet diam. Sed blandit sagittis leo sed lobortis. Vivamus euismod varius urna sit amet interdum. Duis lacinia, dolor vitae viverra ullamcorper, sapien nisi porttitor metus, sed efficitur dui mi et nisl. Vestibulum euismod, justo ac egestas laoreet, ante nibh posuere felis, et pellentesque elit turpis sit amet lectus. Vestibulum sed arcu tincidunt, dignissim tellus id, consectetur mauris.</p>

      <p class="lorem">Etiam sit amet nisl fermentum, cursus justo ac, imperdiet elit. Proin dignissim congue ex, sed tempor eros ullamcorper eu. Sed vulputate leo purus, id scelerisque metus mollis sed. Quisque egestas mattis erat, posuere auctor augue lobortis sed. Pellentesque imperdiet felis vitae porta consequat. Nullam rhoncus rhoncus augue in tincidunt. Fusce facilisis massa sed sodales pretium. Vestibulum rhoncus porta sapien suscipit iaculis. Suspendisse potenti. Nulla tempor, lectus vitae efficitur posuere, ipsum dolor tincidunt nulla, et cursus ex velit a lectus. Nullam ut augue a neque lacinia aliquam a non magna.</p>

      <p class="lorem">Etiam non dui ante. Pellentesque aliquet fermentum leo semper euismod. Mauris a lectus elementum justo fringilla mattis in ac risus. Mauris ac luctus tortor. Curabitur finibus pharetra porta. Ut eu finibus ipsum. Donec quis justo blandit, sollicitudin eros non, gravida augue. Suspendisse faucibus, purus ac feugiat lacinia, nulla ipsum luctus magna, sed fermentum tortor ante id mi. Morbi eu nisl porttitor neque tincidunt lacinia. Aliquam ipsum eros, suscipit vitae vulputate non, rhoncus eu tellus. Donec vitae elit massa. Suspendisse porttitor, ligula id bibendum hendrerit, dui lectus aliquet ipsum, ut malesuada magna mauris maximus ligula. Etiam mollis congue consectetur. Aenean eu egestas nunc, ut faucibus eros. Mauris ornare ante a viverra elementum. Etiam sit amet euismod augue.</p>

      <p class="lorem">Nunc pellentesque porttitor justo, tincidunt molestie orci. Donec varius, tellus sed facilisis volutpat, tortor dolor pulvinar tellus, in fermentum lectus tortor non tellus. Morbi consequat arcu ac erat ultricies euismod. Nulla facilisi. Maecenas nec tortor velit. Vestibulum tempus, lacus nec fringilla egestas, augue quam blandit dui, mollis pharetra sem ipsum sit amet massa. Sed sit amet quam laoreet, ullamcorper diam at, eleifend est. </p>
    </div>
  </body> 
</html> 