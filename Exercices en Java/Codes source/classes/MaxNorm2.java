class Point
{ public Point (int abs, int ord)      { x = abs ;  y = ord ; }
  public void affiche ()
  { System.out.println ("Coordonnees " + x + " " + y) ;
  }
  public Point MaxNorme (Point b)
  { double na = x*x + y*y ;    // ou encore this.x*this.x + this.y*this.y
    double nb = b.x*b.x + b.y*b.y ;
    if (na>nb) return this ;
          else return b ;
  }
  private double x ;   // abscisse
  private double y ;   // ordonnee
}
public class MaxNorm2
{ public static void main (String args[])
  { Point p1 = new Point (2, 5) ; System.out.print ("p1 : ") ; p1.affiche() ;
    Point p2 = new Point (3, 1) ; System.out.print ("p2 : ") ; p2.affiche() ;
    Point p = p1.MaxNorme (p2) ;  // ou p2.maxNorme(p1)
    System.out.print ("Max de p1 et p2 : ") ; p.affiche() ;
  }
}

