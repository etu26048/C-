public class ArgLC
{ public static void main (String args[])
  { int nbArgs = args.length ;
    if (nbArgs != 2) { System.out.println ("nombre arguments incorrect") ;
                       System.exit(-1) ;
                     }
    int n1, n2 ;
    n1 = Integer.parseInt (args[0]) ;
    n2 = Integer.parseInt (args[1]) ;
    System.out.println (n1 + " + " + n2 + " = " + (n1+n2)) ;
  }
}

/*
 - arguments ligne de commande
 - conversion chaine en numérique
*/


/* commentaires :
  - penser avec EDI à fournir les paramètres ...
*/
/*
12 + 58 = 70
*/

/* titre :
*/

/* Ennoncé :
  Ecrire un programme (main) qui récupère deux nombres entiers
  par la ligne de commande et en affiche la somme.
*/


/* notes perso
  - vérifier exit(-1)
  - voir ce qu'on a pour arguments non numériques
*/
