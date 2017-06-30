public class ExoII8
{ public static void main (String[] args)
  { int i, n ;

    for (i=0, n=0 ; i<5 ; i++) n++ ;
    System.out.println ("A : i = " + i + ", n = " + n) ;

    for (i=0, n=0 ; i<5 ; i++, n++) {}
    System.out.println ("B : i = " + i + ", n = " + n) ;

    for (i=0, n=50 ; n>10 ; i++, n-= i ) {}
    System.out.println ("C : i = " + i + ", n = " + n) ;

    for (i=0, n=0 ;
      i<3 ; i++, n+=i, System.out.println ("D : i = " + i + ", n = " + n)) ;
    System.out.println ("E : i = " + i + ", n = " + n) ;
  }
}


