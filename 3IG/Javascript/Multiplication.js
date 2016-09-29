function affichageList(){
	let cpt = 1;
	document.write("<ul>");
	while(cpt < 11){
		document.write("<li>"+_nombreDemande+" x "+cpt+" = "+_nombreDemande*cpt+"</li>");
		cpt++;
	}
	document.write("</ul>");
}

function affichageTableau(){
	document.write("<table> Tableau de multiplication");
	document.write("<tr><th>Nombre</th><th>Facteur</th><th>Résultat</th></tr>");
	for(let cpt = 1;cpt < 11;cpt++){
		let resultat = cpt * _nombreDemande;
		document.write("<tr><td>"+_nombreDemande+"</td><td>"+cpt+"<td>"+resultat+"</td></tr>");
	}
	document.write("</table>");
}

let _nombreDemande = prompt("Entrez un nombre : ");
Number(_nombreDemande);
while(!isFinite(_nombreDemande)){
	_nombreDemande = prompt("Entrez un nombre correct : ");
}