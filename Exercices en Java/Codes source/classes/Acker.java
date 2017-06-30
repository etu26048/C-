class Util
{ public static int acker (int m, int n)
  { if ( (m<0) || (n<0) ) return 0 ;
    else if (m == 0) return n+1 ;
    else if (n == 0) return acker (m-1, 1) ;
    else return acker (m-1, acker(m, n-1)) ;
  }
}
public class Acker
{ public static void main (String args[])
  { int m, n ;
    System.out.print ("Premier parametre : ") ;
    m = Clavier.lireInt() ;
    System.out.print ("Second parametre  : ") ;
    n = Clavier.lireInt() ;
    System.out.println ("acker (" + m + ", " + n + ") = " + Util.acker(m, n)) ;
  }
}

