public class Serie
{ public static void main (String[] args)
  { int nt ;          // nombre de termes de la serie harmonique
    float som ;       // pour la somme de la serie
    int i ;

    do
      { System.out.print ("combien de termes : ") ;
        nt = Clavier.lireInt() ;
      }
    while (nt<1) ;
    for (i=1, som=0 ; i<=nt ; i++) som += (float)1/i ;
    System.out.println ("Somme des " + nt + " premiers termes = " + som) ;
  }
}

