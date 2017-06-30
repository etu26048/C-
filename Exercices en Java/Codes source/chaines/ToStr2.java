class PointN
{ public PointN (int x, int y, String nom)
  { this.x=x ; this.y=y ; this.nom = new String(nom) ;
  }
  public String toString()
  { String ch = "Je suis un point nomme " + nom
             + " et de coordonnees " + x + " " + y ;
    return ch ;
  }
  private int x, y ;
  private String nom ;
}

public class ToStr2
{ public static void main (String args[])
  { PointN a = new PointN (2, 5, "orig") ;
    PointN b = new PointN (3, 8, "extrem") ;
    System.out.println ("a = " + a) ;
    System.out.println ("b = " + b) ;
  }
}



