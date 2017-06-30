public class ExoII4a
{ public static void main(String[] args)
  { int i, n, som ;
    som = 0 ;
    for (i=0 ; i<4 ; i++)
    { System.out.println ("donnez un entier ") ;
      n = Clavier.lireInt() ;
      som += n ;
    }
    System.out.println ("Somme : " + som) ;
  }
}


