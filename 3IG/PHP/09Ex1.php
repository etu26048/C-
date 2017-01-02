<?php
	$cTexte = "black";
	$cFond = "white";
	
	//print_r($_COOKIE) is way to debug/test for printing all COOKIES
	
	if(isset($_POST["cTexte"]) && isset($_POST["cFond"])){
		
		setCookie('cFond', $_POST['cFond'], time() + 60*60*24*7);
		setCookie('cTexte', $_POST['cTexte'], time() + 60*60*24*7);
		$cTexte = $_COOKIE['cTexte'];
		$cFond = $_COOKIE['cFond'];
	}
	
	/*if(isset($_COOKIE['texte']))
		$cTexte = $_COOKIE['texte'];
		
	if(isset($_COOKIE['fond']))
		$cFond = $_COOKIE['fond'];*/
		
	
?>
<!doctype HTML> 
<html> 
  <head> 
    <meta charset="utf-8" /> 
    <style> 
      body { 
        background-color: black; 
      } 
      #wrapper { 
        width: 800px; 
        padding: 8px; 
        margin-left: auto; 
        margin-right: auto; 
        background-color: lightgrey; 
      } 
      #info { 
        display: flex; 
        flex-direction: row; 
        align-items: stretch; 
        border: 1px solid black; 
        padding: 4px; 
      } 
      #info div { 
        border: 1px solid blue; 
        background-color: lightblue; 
        padding: 6px; 
        margin: 6px; 
        flex-grow: 1; 
      } 
      #pCookies { 
        height: 100px; 
        padding: 4px; 
        border: 1px solid grey; 
        background-color: white; 
      } 
      #main { 
        padding: 6px; 
        color: black;
		background-color: white; 
      } 
    </style> 
	<script>
		
		/*function addCookies(){
			
			document.cookie = "texte="+document.getElementById("cTexte").value;
			document.cookie = "fond="+document.getElementById("cFond").value;
			
		}*/
	
		function refresh(){
			
			let paraCookie = document.getElementById("pCookies");
			paraCookie.innerHTML = document.cookie;
		}
	
		function deleteCookies(){
			
			var moment = new Date();
			moment.setTime(moment.getTime() - 1000);
			
			document.cookie = "cTexte=cTexte;expires="+moment.toUTCString();
			document.cookie = "cFond=cFond;expires="+moment.toUTCString();
			
			refresh();
	
		}	
		
		function reloadPage(){
			
			location.reload();
		}
	</script>
  </head> 
  <body> 
    <div id="wrapper"> 
      <p id="main"> 
        Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
		Phasellus pellentesque lorem augue, in hendrerit tortor fermentum at. 
		In hac habitasse platea dictumst. Praesent nec iaculis magna, in 
		lacinia libero. Nulla vel tincidunt tellus, in varius nibh. Donec ut 
		odio ac odio malesuada auctor nec at nisi. Sed lobortis nibh quis erat 
		laoreet luctus. Interdum et malesuada fames ac ante ipsum primis in 
		faucibus. Ut auctor dignissim urna, nec aliquet leo aliquam at. 
		Integer eu lectus posuere, accumsan enim sit amet, placerat enim. Duis 
		in metus nisl. Maecenas consequat velit id turpis sagittis viverra. 
		Proin et ligula ut eros fermentum gravida nec eu nulla. 
      </p> 
	  <script>
		<?php
			print "document.getElementById('main').style.backgroundColor = '$cFond' ";
		?>;
		<?php
			print "document.getElementById('main').style.color = '$cTexte' ";
		?>;
	  </script>
      <div id="info"> 
        <div> 
          <form action="09Ex1.php" method="POST"> 
            <label for="cTexte">Couleur du texte :</label><br/> 
            <input type="text" id="cTexte" name="cTexte" /><br/> 
            <label for="cFond">Couleur du fond :</label><br/> 
            <input type="text" id="cFond" name="cFond" /> 
			<!--onclick="addCookies()"-->
            <p><button type="submit" id="bMAJ" >Mise à jour</button></p> 
          </form> 
        </div> 
        <div> 
          Vos cookies : 
          <p id="pCookies"></p> 
          <button id="bRafraichir" onclick="refresh()">Rafraîchir</button> 
        </div> 
        <div> 
          <button id="bSupprimer" onclick="deleteCookies()">Supprimer les cookies</button><br/> 
          <button id="bRecharger" onclick="reloadPage()">Recharger la page</button> 
        </div> 
      </div> 
    </div> 
  </body> 