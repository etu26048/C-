public class Excep
{ public static void main (String args[])
  { double x1 = 1e200, x2 = 1e210 ;
    double y, z ;
    y = x1*x2 ;
    System.out.println ("valeur de y " + y) ;

    x2 = x1 ;
    z = y/(x2-x1)  ;
    System.out.println (y + " divise par " + (x2-x1) + " = " + z) ;
    y = 15 ;
    z = y/(x2-x1)  ;
    System.out.println (y + " divise par " + (x2-x1) + " = " + z) ;

    z = (x2-x1)/(x2-x1) ;
    System.out.println ((x2-x1) + " divise par " + (x2-x1) + " = " + z) ;
    System.out.println (z + "+1 = " + (z+1)) ;

    x1 = Float.POSITIVE_INFINITY ;
    x2 = Double.NEGATIVE_INFINITY ;
    z = x1/x2 ;
    System.out.println (x1 + "/" + x2 + " = " + z) ;
Clavier.lireInt();  }
}

/*
Infinity divise par 0.0 = Infinity
15.0 divise par 0.0 = Infinity
0.0 divise par 0.0 = NaN
NaN+1 = NaN
Infinity/-Infinity = NaN
*/
