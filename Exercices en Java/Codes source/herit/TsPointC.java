class Point
{ public Point (int x, int y)  { this.x = x ; this.y = y ; }
  public void affCoord()
  { System.out.println ("Coordonnees : " + x + " " + y) ;
  }
  private int x, y ;
}
class PointNom extends Point
{ public PointNom (int x, int y, char nom)
  { super (x, y) ;
    this.nom = nom ;
  }
  public void affCoordNom()
  { System.out.print ("Point de nom " + nom + " ") ;
    affCoord() ;
  }
  private char nom ;
}
public class TsPointC
{ public static void main (String args[])
  { PointNom pn1 = new PointNom(1, 7, 'A') ;
    pn1.affCoordNom() ;                // methode de PointNom

    PointNom pn2 = new PointNom(4, 3, 'B') ;
    pn2.affCoordNom() ;                 // methode de PointNom
    pn2.affCoord() ;                    // methode de Point
  }
}

/*
Point de nom A Coordonnees : 1 7
Point de nom A Coordonnees : 1 7
Point de nom B Coordonnees : 4 3
Coordonnees : 4 3
*/

