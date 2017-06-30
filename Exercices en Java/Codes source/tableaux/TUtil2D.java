class Util2D
{ public static boolean regulier (double[][] t)
  { int n = t[0].length ;   // longueur premiere ligne
    for (int i=1 ; i<t.length ; i++)  // parcoure les lignes a partir de la seconde
       if (t[i].length != n) return false ;
    return true ;
  }
  public static double[] sommeLignes (double[][] t)
  { int nLignes = t.length ;
    double[] res = new double[nLignes] ;
    for (int i=0 ; i<nLignes ; i++)
    { res[i] = 0. ;
      for (int j=0 ; j<t[i].length ; j++) res[i] += t[i][j] ;
    }
    return res ;
  }
  public static double[][] somme (double[][] t1, double[][] t2)
  { if (!regulier(t1) || !regulier(t2)) return null ;
    if (t1.length != t2.length)         return null ;
    if (t1[0].length != t2[0].length)   return null ;
    int nLig = t1.length ; int nCol=t1[0].length ;
    double[][] som = new double[nLig][nCol] ;
    for (int i=0 ; i<nLig ; i++)
      for (int j=0 ; j<nCol ; j++)
        som[i][j] = t1[i][j] + t2[i][j] ;
    return som ;
  }
  public static void affiche (double[][] t)
  { for (int i=0 ; i<t.length ; i++)
      { for (int j=0 ; j<t[i].length ; j++)
          System.out.print (t[i][j] + " ") ;
        System.out.println () ;
      }
  }
}
public class TUtil2D
{ public static void main (String args[])
  { double[][] a = { {1, 2, 3}, {4, 5, 6}} ;
    double[][] b = { {6, 5, 4}, {3, 2, 1}} ;
    double[][] c = Util2D.somme (a, b) ;
    System.out.println ("a = ") ; Util2D.affiche(a) ;
    System.out.println ("b = ") ; Util2D.affiche(b) ;
    System.out.println ("c = ") ; Util2D.affiche(c) ;

    double[][] d = { { 1, 2}, {1, 2, 3}, {1}, {1, 2, 3, 4, 5}} ;
    double [] sLig = Util2D.sommeLignes(d) ;
    System.out.println ("d = ") ; Util2D.affiche(d) ;
    System.out.print ("somme lignes de d = ") ;
    for (int i=0 ; i<sLig.length ; i++) System.out.print (sLig[i] + " ") ;
  }
}



