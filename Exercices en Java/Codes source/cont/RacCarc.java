public class RacCarc
{ public static void main (String[] args)
  { double x ;
    do
    { System.out.print ("donnez un nombre positif : ") ;
      x = Clavier.lireDouble() ;

      if (x < 0) { System.out.println ("svp positif ") ;
                    continue ;
                  }
      if (x>0) System.out.println ("sa racine carree est : " + Math.sqrt (x)) ;
      if (x==0) break ;
    }
    while (true) ;
  }
}


