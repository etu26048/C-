class Point
{ public Point (int x, int y)  { this.x = x ; this.y = y ; }
  public void affiche()
  { System.out.println ("Coordonnees : " + x + " " + y) ;
  }
  private int x, y ;
}
class PointNom extends Point
{ public PointNom (int x, int y, char Nom)
  { super (x, y) ;
    this.Nom = Nom ;
  }
  public void affiche()
  { System.out.print ("Point de nom " + Nom + " ") ;
    super.affiche() ;
  }
  private char Nom ;
}
public class TsPointR
{ public static void main (String args[])
  { Point p = new Point (3, 7) ;
    p.affiche() ;             // methode de Point
    PointNom pn = new PointNom(1, 7, 'A') ;
    pn.affiche() ;            // methode de PointNom
  }
}



