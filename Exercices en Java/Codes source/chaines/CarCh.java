public class CarCh
{ public static void main (String args[])
  { System.out.print ("donnez une chaine : ") ;
    String ch = Clavier.lireString() ;
    System.out.print ("un caractere sur deux : ") ;
    for (int i = 0 ; i<ch.length() ; i+=2)
      System.out.print (ch.charAt(i)) ;
    System.out.println () ;
    System.out.println ("Premier caractere = " + ch.charAt(0)) ;
    System.out.println ("Dernier caractere = " + ch.charAt(ch.length()-1)) ;
  }
}

/*
donnez une chaine : java est plus portable que C++
un caractere sur deux : jv s lspral u +
Premier caractere = j
Dernier caractere = +
*/


