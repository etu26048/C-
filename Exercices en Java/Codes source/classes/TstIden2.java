class Ident
{ public Ident ()
  { num = numCour ;
    numCour++ ;
  }
  public int getIdent()
  { return num ;
  }
  public static int getIdentMax()
  { return numCour-1 ;
  }
  private static int numCour ;   // prochaint numero a attribuer
  private int num ;              // numéro de l'objet
  static
  { System.out.print ("donnez le premier identificateur : ") ;
    do numCour = Clavier.lireInt() ; while (numCour <= 0) ;
  }
}
public class TstIden2
{ public static void main (String args[])
  { Ident a = new Ident(), b = new Ident() ;
    System.out.println ("numero de a : " + a.getIdent()) ;
    System.out.println ("numero de b : " + b.getIdent()) ;
    System.out.println ("dernier numero " + Ident.getIdentMax()) ;
    Ident c = new Ident() ;
    System.out.println ("dernier numero " + Ident.getIdentMax()) ;
  }
}


