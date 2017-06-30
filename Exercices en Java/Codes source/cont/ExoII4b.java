public class ExoII4b
{ public static void main(String[] args)
  { int i, n, som ;
    som = 0 ;
    i = 0 ;
    while (i<4)
    { System.out.println ("donnez un entier ") ;
      n = Clavier.lireInt() ;
      som += n ;
      i++ ;
    }
    System.out.println ("Somme : " + som) ;
  }
}


