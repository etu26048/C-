class Point
{ public Point (int x, int y) { this.x = x ; this.y = y ; }
  public static boolean identiques (Point a, Point b)
  { return ( (a.x==b.x) && (a.y==b.y) ) ; }
  public boolean identique (Point a)
  { return ( (a.x==x) && (a.y==y) ) ; }
  private int x, y ;
}
class PointNom extends Point
{ PointNom (int x, int y, char nom)
  { super (x, y) ; this.nom = nom ; }
  public static boolean identiques (PointNom a, PointNom b)
  { return (Point.identiques (a, b) && (a.nom==b.nom) ) ; }
  public boolean identique (PointNom a)
  { return (super.identique(a) && (nom==a.nom) ) ; }
  private char nom ;
}
public class LimPoly2
{ public static void main (String args[])
  { Point p = new Point (2, 4) ;
    PointNom pn1 = new PointNom (2, 4, 'A') ;
    PointNom pn2 = new PointNom (2, 4, 'B') ;
    System.out.println (pn1.identique(pn2)) ;
    System.out.println (p.identique(pn1)) ;
    System.out.println (pn1.identique(p)) ;
    System.out.println (Point.identiques(pn1, pn2)) ;
  }
}

/*
false
true
true
true
*/
