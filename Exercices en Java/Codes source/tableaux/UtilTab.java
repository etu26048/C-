class UtilTab
{ static double somme (double[] t)
  { double s=0. ;                                 // ou (depuis JDK 5.0) :
    for (int i=0 ; i<t.length ; i++) s+= t[i] ;   // for (int v : t) s+= v ;
    return s ;
  }

  static void incre (double[] t, double a)        
  { for (int i=0 ; i<t.length ; i++) t[i] += a ;  // for... each pas applicable
  }

  static void affiche (double[] t)
  { for (int i=0 ; i<t.length ; i++) System.out.print (t[i] + " ") ;
    // ou (depuis JDK 5.0) : for (int v : t) System.out.print (v + " ") ;
    System.out.println () ;
  }
}

public class TstUtil1
{ public static void main (String args[])
  { double t1[] = {1.25, 2.5, 3.5, 5.} ;
    System.out.print ("t1 initial     = ") ; UtilTab.affiche(t1) ;
    System.out.println ("  somme = " +UtilTab.somme(t1)) ;
    UtilTab.incre (t1, 1.25) ;
    System.out.print ("t1 incremente = ") ; UtilTab.affiche(t1) ;
    System.out.println ("  somme = " +UtilTab.somme(t1)) ;
  }
}
