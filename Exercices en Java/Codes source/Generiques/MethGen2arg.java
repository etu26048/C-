public class MethGen2arg
{ public static void main (String args[])
  { Integer i1 = 3 ; Integer i2 = 5 ;
    System.out.println ("hasard (i1, i2) = " + hasard (i1, i2)) ;
    String s1 = "Salut" ; String s2 = "bonjour" ;
    System.out.println ("hasard (s1, s2) = " + hasard (s1, s2)) ;
    System.out.println ("hasard (i1, s1) = " + hasard (i1, s1)) ;
    // Les appels suivants seont rejetés en compilation :
    //   MethGen2arg.<Integer> hasard (i1, s1) ;
    //   MethGen2arg.<String>  hasard (i1, s1) ;
    // En revanche, ceux-ci seront acceptés :
    //   MethGen2arg.<Integer> hasard (i1, i2) ;
    //   MethGen2arg.<Number>  hasard (i1, i2) ;
  }
  public static <T> T hasard (T x, T y)
  { double v = Math.random () ;
    if (v < 0.5) return x ;
            else return y ;
  }
}
