class Point
{ public Point (int abs, int ord)      { x = abs ;  y = ord ; }
  public void deplace (int dx, int dy) { x += dx ;  y += dy ; }
  public void affiche ()
  { System.out.println ("Je suis un point de coordonnees " + x + " " + y) ;
  }
  private double x ;   // abscisse
  private double y ;   // ordonnee
}
public class TstPnt
{ public static void main (String args[])
  { Point a ;
    a = new Point(3, 5) ;        a.affiche() ;
    a.deplace(2, 0) ;            a.affiche() ;
    Point b = new Point(6, 8) ;  b.affiche() ;
  }
}

