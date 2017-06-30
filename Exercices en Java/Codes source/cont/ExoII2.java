public class ExoII2
{ public static void main(String[] args)
  { int n ;
    n = Clavier.lireInt() ;
    switch (n)
    { case 0 :  System.out.println ("Nul") ;
      case 1 :
      case 2 :  System.out.println ("Petit") ;
                break ;
      case 3 :
      case 4 :
      case 5 :  System.out.println ("Moyen") ;
      default : System.out.println ("Grand") ;
    }
    do ;while ( (n = Clavier.lireInt()) != 10) ;   // instruction 2
  }
}


