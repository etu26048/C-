public class CourCir
{ public static void main (String args[])
  { int i=10, j=5 ;
    if (i<5 && j++<10)  System.out.println ("&&1 vrai") ;
                   else System.out.println ("&&1 faux") ;
    System.out.println ("i = " + i + "  j = " + j) ;
    if (i<5 & j++<10)   System.out.println ("& vrai") ;
                   else System.out.println ("& faux") ;
    System.out.println ("i = " + i + "  j = " + j) ;
    if (i<15 && j++<10) System.out.println ("&&2 vrai") ;
                   else System.out.println ("&&2 faux") ;
    System.out.println ("i = " + i + "  j = " + j) ;
    if (i<15 || j++<10) System.out.println ("|| vrai") ;
                   else System.out.println ("|| faux") ;
    System.out.println ("i = " + i + "  j = " + j) ;
  }
}

/*
&&1 faux
i = 10  j = 5
&faux
i = 10  j = 6
&&2 vrai
i = 10  j = 7
|| vrai
i = 10  j = 7
*/
