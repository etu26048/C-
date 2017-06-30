class Point
{ public Point (double x, double y)
  { rho = Math.sqrt (x*x + y*y) ;
    theta = Math.atan (y/x) ;
  }
  public void deplace (double dx, double dy)
  { double x = rho * Math.cos(theta) + dx ;
    double y = rho * Math.sin(theta) + dy ;
    rho = Math.sqrt (x*x + y*y) ;
    theta = Math.atan2 (y, x) ;
  }
  public double abscisse () { return rho * Math.cos(theta) ; }
  public double ordonnee () { return rho * Math.sin(theta) ; }
  public void homothetie (double coef) { rho *= coef ; }
  public void rotation (double th)
  { theta += th ;
  }
  public double rho()    { return rho ; }
  public double theta () { return theta ; }
  public void afficheCart ()
  { System.out.println ("Cordonnees cartesiennes = " + rho*Math.cos(theta)
                         + " " + rho*Math.sin(theta) ) ;
  }
  public void affichePol ()
  { System.out.println ("Cordonnees polaires = " + rho + " " + theta) ;
  }
  private double rho ;     // rayon vecteur
  private double theta ;   // angle polaire
}

public class PntPol2
{ public static void main (String args[])
  { Point a ;
    a = new Point(1, 1) ;       a.afficheCart() ; a.affichePol() ;
    a.deplace(-1, -1) ;         a.afficheCart() ; a.affichePol() ;
    Point b = new Point(1, 0) ; b.afficheCart() ; b.affichePol() ;
    b.homothetie (2) ;          b.afficheCart() ; b.affichePol() ;
    b.rotation (Math.PI) ;      b.afficheCart() ; b.affichePol() ;
  }
}