public class ExoII4c
{ public static void main(String[] args)
  { int i, n, som ;
    som = 0 ;
    i = 0 ;
   do
    { System.out.println ("donnez un entier ") ;
      n = Clavier.lireInt() ;
      som += n ;
      i++ ;
    }
    while (i<4) ;
    System.out.println ("Somme : " + som) ;
  }
}


