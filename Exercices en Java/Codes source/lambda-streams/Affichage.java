import java.util.function.* ;
public class Affichage
{ public static void main (String [] args)
  { int [] tab = {1, 4, -2, 9, -3, 5, -3 } ;
    System.out.print ("-- Les positifs de tab : ") ;
    affichage_selectif (tab, ee -> ee > 0) ;
  }
  public static void affichage_selectif (int [] t, IntPredicate f)
  { for (int val : t) if (f.test (val)) System.out.print (val + " * ") ;
    System.out.println () ;
  }
}
