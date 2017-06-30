class Except extends Exception
{ public Except (int n) { this.n = n ; }
  public int n ;
}
public class Chemin
{ public static void main (String args[])
  { int n ;
    System.out.print ("donnez un entier : ") ;
    n = Clavier.lireInt() ;
    try
    { System.out.println ("debut premier bloc try") ;
      if (n!=0) throw new Except (n) ;
      System.out.println ("fin premier bloc try") ;
    }
    catch (Except e)
    { System.out.println ("catch 1 - n = " + e.n) ;
    }
    System.out.println ("suite du programme") ;
    try
    { System.out.println ("debut second bloc try") ;
      if (n!=1) throw new Except (n) ;
      System.out.println ("fin second bloc try") ;
    }
    catch (Except e)
    { System.out.println ("catch 2 - n = " + e.n) ;
      System.exit(-1) ;
    }
    System.out.println ("fin programme") ;
  }
}

/*
donnez un entier : 0
debut premier bloc try
fin premier bloc try
suite du programme
debut second bloc try
catch 2 - n = 0

donnez un entier : 1
debut premier bloc try
catch 1 - n = 1
suite du programme
debut second bloc try
fin second bloc try
fin programme


donnez un entier : 2
debut premier bloc try
catch 1 - n = 2
suite du programme
debut second bloc try
catch 2 - n = 2

*/

