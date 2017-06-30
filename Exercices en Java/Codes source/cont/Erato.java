public class Erato
{ public static void main (String[] args)
  { final int nParLigne = 10 ;
    boolean raye [] ;                        // tableau servant de "crible"
    int nombre ;                             // dernier nombre entier raye
    int nMax ;                               // le plus grand entier a examiner
    int i ;
        /* preparation du crible */
    System.out.print("Donnez le plus grand nombre entier a examiner : ") ;
    nMax = Clavier.lireInt() ;
    raye = new boolean [nMax+1] ;
    for (i=1 ; i<=nMax ; i++) raye[i] = false ;
        /* on raye le nombre 1 */
    raye[1] = false ; nombre = 1 ;
    while (nombre*nombre <= nMax)
    {   /* recherche, a partir de nombre, du premier nombre non raye */
      while ( (raye[++nombre]) && (nombre<=nMax)) {}
        /* on raye tous ses multiples */
      for (i=2*nombre ; i<=nMax ; i+=nombre) raye[i] = true ;
    }
      /* affichage des resultats */
    System.out.println ("entre 1 et " + nMax + " les nombres premiers sont : ") ;
    int nAff = 0 ;  // nombre de valeurs affichees
    for (i=1 ; i<=nMax ; i++)
    { if (!raye[i]) { System.out.print (i + " ") ;
                      nAff++ ;
                      if (nAff == nParLigne) { nAff = 0 ;
                                               System.out.println () ;
                                             }
                    }
    }  
  }
}


