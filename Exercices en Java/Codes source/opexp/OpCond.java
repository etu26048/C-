public class OpCond
{ public static void main(String[] args)
  { int n=10, p=5, q=10 ;

    n = p = q = 5 ;
    n += p += q ;
    System.out.println ("A : n = " + n + " p = " + p + " q = " + q) ;

    q = n < p ? n++ : p++ ;
    System.out.println ("B : n = " + n + " p = " + p + " q = " + q) ;

    q = n > p ? n++ : p++ ;
    System.out.println ("C : n = " + n + " p = " + p + " q = " + q) ;
  }
}

/*
A : n = 15 p = 10 q = 5
B : n = 15 p = 11 q = 10
C : n = 16 p = 11 q = 15
*/
