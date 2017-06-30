class Triplet<T>
{ private T x, y, z ;      // les trois elements du triplet
  public Triplet (T premier, T second, T troisieme)
  { x = premier ; y = second ; z = troisieme ;
  }
  public T getPremier ()
  { return x ; 
  }
  public T getSecond ()
  { return y ;
  }
  public T getTroisieme ()
  { return z ;
  }
  public void affiche ()
  { System.out.println ("premiere valeur : " + x + " - deuxieme valeur : " + y 
		              + " - troisieme valeur : " + z) ;
  }
}
public class TstTriplet
{ public static void main (String args[])
  { Integer oi1 = 3 ;    // équivalent à :    Integer oi1 = new Integer (3) ;
    Integer oi2 = 5 ;    // équivalent à :    Integer oi2 = new Integer (5) ;
    Integer oi3 = 12 ;   // équivalent à :    Integer oi3 = new Integer (12) ;
    Triplet <Integer> ti  = new Triplet<Integer> (oi1, oi2, oi3) ;
            // on aurait pu aussi ecrire directement :
            //   Triplet <Integer> ti  = new Triplet<Integer> (3, 5, 12) ;
    ti.affiche () ;
    Triplet <Double>  td = new Triplet <Double>  (2.0, 12.0, 2.5) ;
              // on peut fournir des arguments de type double qui seront
              // convertis automatiquement en Double
    td.affiche() ;
    Integer n = ti.getTroisieme() ;
    System.out.println("troisieme element du triplet ti = " + n ) ;
    Double p = td.getPremier () ;
    System.out.println ("premier element du triplet td = " + p ) ;
   }
}
