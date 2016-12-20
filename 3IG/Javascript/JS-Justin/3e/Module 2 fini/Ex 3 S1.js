let nombre;	
nombre = prompt ("Entrez une valeur : ", 0);
while(!isFinite(nombre))
{
	nombre = prompt ("Entrez une valeur : ", 0);
}			
function affichage()
{
	document.write("<p class='nombre'>"+nombre+"</p>");
}
function tableau()
{
	let i ;
	for(i = 1 ; i <=10; i++)
	{
		document.write("<tr><td>"+nombre+"</td><td>"+i+"</td><td>"+nombre*i+"</td></tr>");
	}
}