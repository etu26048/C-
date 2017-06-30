class Point
{ public Point (char c, double x)   // constructeur
  { nom = c ;
    abs = x ;
  }
  public void affiche ()
  { System.out.println ("Point de nom " + nom + "  d'abscisse " + abs) ;
  }
  public void translate (double dx)
  { abs += dx ;
  }
  private char nom ;     // nom du point
  private double abs ;   // abscisse du point
}
public class TstPtAxe
{ public static void main (String args[])
  { Point a = new Point ('C', 2.5) ;
    a.affiche() ;
    Point b = new Point ('D', 5.25) ;
    b.affiche() ;
    b.translate(2.25) ;
    b.affiche() ;
  }
}


