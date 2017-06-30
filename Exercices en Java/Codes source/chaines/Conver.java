public class Conver
{ public static void main (String args[])
  { System.out.print ("donnez un nombre entier : ") ;
    int n = Clavier.lireInt() ;
    String ch = String.valueOf(n) ;
    for (int i=0 ; i<ch.length() ; i++)     // ou (depuis JDK 5.0) :
      System.out.println (ch.charAt(i)) ;   // for (char c : ch)
  }                                         //   System.out.println (c) ;
}
