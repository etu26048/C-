public class Affconv
{ public static void main (String args[])
  { byte b=1 ;
    short p=2 ;
    int n=3 ;
    final int N=10 ;
    long q=4 ;
    float x=5.f ;
    double y=6. ;

    b = n ;      // erreur : conversion de int en byte non autorisée par aff
    b = 25 ;     // OK : exception affectation constante (p61)
    b = 500 ;    // erreur : 500 non représentable en byte
    x = 2*q ;    // OK
    y = b*b ;    // OK
    p = b*b ;    // erreur : b*b de type int
    b = b+5 ;    // erreur
    p = 5*N-3 ;  // OK
  }
}

