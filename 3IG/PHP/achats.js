window.onload =  function(){
	
	document.getElementById("bRPG").addEventListener("click", goToRPG('rpg'));
	document.getElementById("bNonRPG").addEventListener("click", goToRPG('nonrpg'));
}

function commander(genre, game_name){
	
	return function(){
		document.location.href = "http://vm-debian.iesn.be/ig10/Labo3/achats.php?games="+genre.trim()+"&order="+game_name.trim();
	}
}

function goToRPG(genre){
	
	return function(){
		document.location.href = "http://vm-debian.iesn.be/ig10/Labo3/achats.php?games="+genre.trim();
	}
}

