<!doctype html> 
<html> 
  <head> 
    <meta charset="utf-8" /> 
    <title>Ajout de membre</title> 
    <style> 
      #commentaire { 
        color: red; 
        font-weight: bold; 
      } 
      .message { 
        color: blue; 
        font-weight: bold; 
      } 
    </style>
	<script>
	
		window.onload = disabled_button;
		
		function disabled_button(){
			
			document.getElementById("bSubmit").disabled = true;
		}
		function password_is_valid(){
			
			let commentaire = document.getElementById("commentaire");
			let password = document.getElementById("mdp").value;
			let x = print_commentaire(commentaire, password);
			
			if(x){
				document.getElementById("bSubmit").disabled = false;
			}else
			{
				disabled_button();
			}

		}
		
		function print_commentaire(commentaire, password){
		
			if(password.length < 6){
				commentaire.innerHTML = "Minimum 6 caractères";
				return false;
			}
			if(!/\d/.test(password)){
				commentaire.innerHTML = "Au moins 1 chiffre !";
				return false;
			}
			
			//Ne passera jamais ici sauf si le mdp est correct
			commentaire.innerHTML = "";
			return true;
		}
		
	</script>
	</head> 
  <body> 
	<?php
		
		include_once 'membres.php';
		
		if(isset($_POST['pseudo']) && isset($_POST['mdp']) && isset($_POST['admin'])){

			$estPresent = ajouteMembre($_POST['pseudo'], $_POST['mdp'], $_POST['admin']);
			if(estPresent){
				print "<p class='message'> Utilisateur $_POST[pseudo]";
				if(isset($_POST['admin']))
					print " (admin) ";
				print " ajouté ! </p>";
			}else{
				print "<p class='message'> Utilisateur $_POST[pseudo] déjà présent </p>";
			}
		}
	?>
    <form action="ajout.php" method="POST"> 
      <p> 
        <label for="pseudo">Pseudo : </label> 
        <input id="pseudo" name="pseudo" type="text" required=true /> 
      </p> 
      <p> 
        <label for="mdp">Mot de passe : </label> 
        <input id="mdp" name="mdp" type="password" required=true onchange="password_is_valid()"/> 
        <span id="commentaire"></span> 
      </p> 
      <p> 
        <input id="admin" name="admin" type="checkbox" value="true" /> 
        <label for="admin">Admin</label> 
      </p> 
      <button id="bSubmit" type="submit">Ajouter</button> 
    </form> 
  </body> 
</html> 