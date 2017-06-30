public class AffElarg
{ public static void main (String args[])
  { byte b=1 ;
    char c=2 ;
    short p=2 ;
    int n=3 ;
    final int N=10 ;
    long q=4 ;
    float x=5.f ;
    double y=6. ;

    c = c + 1 ;    // 1   Erreur
    c++       ;    // 2
    c += 3    ;    // 3
    b += c    ;    // 4
    p += b    ;    // 5
    p = p + b ;    // 6   Erreur
    n += x    ;    // 7
    n = n + x ;    // 8   Erreur
    x++       ;    // 9 
  }
}

