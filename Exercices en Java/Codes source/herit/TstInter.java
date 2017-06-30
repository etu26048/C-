interface Affichable
{ abstract public void affiche() ;
}
interface Transformable
{ abstract public void homothetie (double coef) ;
  abstract public void rotation (double angle) ;
}

class Point implements Affichable, Transformable
{ public void affiche() {}
  public void homothetie (double coef) {}
  public void rotation (double angle) {}
}

public class TstInter
{ public static void main (String args[])
  {
  }
}

/* public abstract facultatif dans methodes
*/
