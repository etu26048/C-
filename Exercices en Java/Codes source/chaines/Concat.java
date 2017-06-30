public class Concat
{ public static void main (String args[])
  { final String sujets[]        = { "je", "tu", "il/elle", "nous", "vous", "ils"} ;
    final String terminaisons [] = { "e", "es", "e", "ons", "ez", "ent" } ;
    int nbLettres ;
    System.out.print ("donnez un verbe regulier du premier groupe : ") ;
    while (true)
    { String verbe = Clavier.lireString() ;
      nbLettres = verbe.length() ;
      String fin = verbe.substring (nbLettres-2, nbLettres) ;
          System.out.println ("fin = " + fin") ;//provisoire
      if (fin.equals."er) break ;
      System.out.println ("*** il ne se termine pas par er - donnez-en un autre") ;
    }

    String rad = verbe.substring(0, nbLettres-2) ;
      System.out.println ("rad=" + rad) ;  // tempo
    int n = terminaisons.length ;
    for (int i=0 ; i<n ; i++)
      System.out.println (sujets[i] + " " + rad + terminaisons[i]) ;
  }
}

/*
 extraction de sous-chaines
 comparaison
 éventuellement concaténation
*/


/* commentaires :
  - attention pour comparer equals, pas ==
    precautions equals cf cours,
    peut etre compareTo
*/

/* titre :
*/

/* Ennoncé :
 Ecrire un programme (main) qui lit au clavier un verbe
 du premier groupe (terminé) par er et qui en affiche la
 conjuguaison au présent de l'indicatif. Le programme vérifera
 que le verbe se termine bien par er ; dans le cas contraire, il redemandera...
 On supposera que le verbe est régulier (expliquer)
*/


/* notes perso
  - pas adapté concat (on peut ne pas l'utiliser)
*/
