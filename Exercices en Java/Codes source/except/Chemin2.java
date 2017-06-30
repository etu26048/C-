class Erreur extends Exception
{}
class A
{ public A(int n) throws Erreur
  { if (n==1) throw new Erreur() ;
  }
}
public class Chemin2
{ public static void main (String args[])
  { f(true) ;  System.out.println ("apres f(true)") ;
    f(false) ; System.out.println ("apres f(false)") ;
  }
  public static void f(boolean ret)
  { try
    { A a = new A(1) ;
    }
    catch (Erreur e)
    { System.out.println ("** Dans f - exception Erreur " ) ;
      if (ret) return ;
    }
    System.out.println ("suite f") ;
  }
}



/*
** Dans f - exception Erreur
apres f(true)
** Dans f - exception Erreur
suite f
apres f(false)
*/


