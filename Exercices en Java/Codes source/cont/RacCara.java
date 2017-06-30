public class RacCara
{ public static void main (String[] args)
  { double x ;
    do
      {  System.out.print ("donnez un nombre positif : ") ;
         x = Clavier.lireDouble () ;
         if (x < 0) System.out.println ("svp positif") ;
         if (x <=0) continue ;
         System.out.println ("sa racine carree est : " + Math.sqrt (x) ) ;
      }
    while (x != 0) ;
  }
}


