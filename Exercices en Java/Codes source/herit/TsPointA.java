class Point
{ public void initialise (int x, int y) { this.x = x ; this.y = y ; }
  public void deplace (int dx, int dy)  { x += dx ; y += dy ; }
  public int getX() { return x ; }
  public int getY() { return y ; }
  private int x, y ;
}
class PointA extends Point
{ void affiche()
  { System.out.println ("Coordonnees : " + getX() + " " + getY()) ;
  }
}
public class TsPointA
{ public static void main (String args[])
  { Point p = new Point () ;
    p.initialise (2, 5) ;
    System.out.println ("Coordonnees : " + p.getX() + " " + p.getY() ) ;
    PointA pa = new PointA () ;
    pa.initialise (2, 5) ;  // on utilise la methode initialise de Point
    pa.affiche() ;          // et la méthode affiche de PointA
  }
}

