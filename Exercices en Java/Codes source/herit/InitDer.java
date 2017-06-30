class Base
{ public Base (int n)
  { System.out.println ("Debut construction Base - p = " + p
                        + ", q = " + q + ", n = " + n) ;
    p = q * n ;
    System.out.println ("Fin construction Base -   p = " + p + ", q = " + q) ;
  }
  private int p ;
  private int q = 10 ;
}
class Derive extends Base
{ public Derive (int s)
  { super (s) ;
    System.out.println ("Construction Derive - s = " + s + ", r = " + r) ;
  }
  private int r=2 ;
}
public class InitDer
{ public static void main (String arg[])
  { Base b = new Base(5) ;
    Derive d = new Derive (20) ;
  }
}    
/*
Debut construction Base - p = 0, q = 10, n = 5
Fin construction Base -   p = 50, q = 10
Debut construction Base - p = 0, q = 10, n = 20
Fin construction Base -   p = 200, q = 10
Construction Derive - s = 20, r = 2
*/
// l'init de r dans Derive a peu d'interet
