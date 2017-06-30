public class ExoII7
{ public static void main(String[] args)
  { int n, p ;

    n=p=0 ;
    while (n<5) n+=2 ; p++ ;
    System.out.println ("A : n = " + n + ", p = " + p) ;

    n=p=0 ;
    while (n<5) { n+=2 ; p++ ; }
    System.out.println ("B : n = " + n + ", p = " + p) ;
  }
}


