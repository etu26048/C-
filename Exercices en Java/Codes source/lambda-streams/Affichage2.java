import java.util.function.* ;
public class Affichage
{ public static void main (String [] args)
  { int [] tab = {1, 4, -2, 9, -3, 5, -3, 12, 7,-11, 0, 6 } ;
    System.out.println ("-- Les positifs : ") ;
    affichage_selectif (tab, ee -> ee > 0 )  ;               // lambda
    affichage_selectif (tab, Affichage::filtragePositifs) ;  // reference
    System.out.println ("-- Les negatifs : ") ; 
    affichage_selectif (tab, ee -> ee < 0) ;                 // lambda 
    affichage_selectif (tab, Affichage::filtrageNegatifs) ;  // reference
    System.out.println ("-- Les pairs    : ") ;               
    affichage_selectif (tab, ee -> 2 * (ee/2) == ee ) ;      // lambda
    affichage_selectif (tab, Affichage::filtragePairs) ;     // reference
  }
  public static void affichage_selectif (int [] t, IntPredicate f)
  { for (int val : t) if (f.test (val)) System.out.print (val + " * ") ;
    System.out.println () ;
  }
  public static Boolean filtrageNegatifs (int n)  { return n < 0 ; }
  public static Boolean filtragePositifs (int n)  { return n > 0 ; }
  public static Boolean filtragePairs    (int n)  { return 2*(n/2)==n ; }
}
