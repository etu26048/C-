public class Conjug
{ public static void main (String args[])
  { final String sujets[]        = { "je", "tu", "il/elle", "nous", "vous", "ils"} ;
    final String terminaisons [] = { "e", "es", "e", "ons", "ez", "ent" } ;
    String verbe ;
    int nbLettres ;

    System.out.print ("donnez un verbe regulier du premier groupe : ") ;
    while (true)
    { verbe = Clavier.lireString() ;
      nbLettres = verbe.length() ;
      String fin = verbe.substring (nbLettres-2, nbLettres) ;
      if (fin.equals("er")) break ;
      System.out.println ("*** il ne se termine pas par er - donnez-en un autre") ;
    }

    String rad = verbe.substring(0, nbLettres-2) ;
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
/*
donnez un verbe regulier du premier groupe : dire
*** il ne se termine pas par er - donnez-en un autre
chanter
je chante
tu chantes
il/elle chante
nous chantons
vous chantez
ils chantent
*/


