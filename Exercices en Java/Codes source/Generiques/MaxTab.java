public class MaxTab
{ public static void main (String args[])
  { Integer [] td = {2, 8, 1, 7, 4, 9 } ; 
    System.out.println( "maxi de td = " + max (td) ) ;
    String [] ts = {"bonjour", "hello", "salut"} ;
    System.out.println ("maxi de ts = " + max (ts) ) ;
  }
  static <T extends Comparable<T> > T max (T[] valeurs) 
  {  if (valeurs == null) return null ;
     if (valeurs.length == 0) return null ; 
     T maxi = valeurs[0] ;
     for (T v : valeurs) if (v.compareTo(maxi) > 0) maxi = v ;
     return maxi ;
  }
}
