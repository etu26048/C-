public class TabArg1
{ public static void main (String args[])
  { final int N = 4 ;
    int t1[] = new int [N] ;
    int t2[] = new int [N] ;
    for (int i=0 ; i<N ; i++) t1[i] = i+1 ;
    for (int i=0 ; i<N ; i++) t2[i] = 2*i+1 ;

         // affichage des valeurs de t1 et de t2
    System.out.print ("t1 = ") ; affiche (t1) ;
    System.out.print ("t2 = ") ; affiche (t2) ;

    t1 = t2 ;
    t1[0] = 10 ; t2[1] = 20 ; t1[2] = 30 ; t2[3] = 40 ;

         // affichage des valeurs de t1 et de t2
    System.out.print ("t1 = ") ; affiche (t1) ;
    System.out.print ("t2 = ") ; affiche (t2) ;
  }
  static void affiche (int [] t)        // ou (depuis JDK 5.0)
  { for (int i=0 ; i<t.length ; i++)    // for (int v : t)
      System.out.print (t[i] + " ") ;   //   System.out.print (v + " ") ;
    System.out.println () ;
  }
}
