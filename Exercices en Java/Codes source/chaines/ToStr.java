class PointN
{ public PointN (int x, int y, String nom)
  { this.x=x ; this.y=y ; this.nom =nom ;
  }
  public void affiche()
  { System.out.println ("Point nomme " + nom
             + " et de coordonnees " + x + " " + y) ;
  }
  private int x, y ;
  private String nom ;
}

public class ToStr
{ public static void main (String args[])
  { String nom = "orig" ;
    PointN a = new PointN (2, 5, "orig") ;

    PointN b = new PointN (3, 8, "extrem") ;
    System.out.print ("a = ") ; a.affiche() ;
    System.out.print ("b = ") ; b.affiche() ;
  }
}  
