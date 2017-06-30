import java.util.* ;
public class ExoTraiteLlistStream
{ public static void main (String [] args)
  { Point p1 = new Point (2, 5),  p2 = new Point (-2, 3),
          p3 = new Point (6, -3), p4 = new Point (-3, -2) ;
    ArrayList<Point> l = new ArrayList<Point>() ; 
    l.add(p1) ; l.add(p2) ; l.add(p3) ; l.add(p4) ;
       // sélection des points d'abscisse positive, tri sur l'abscisse
    l.stream().filter(ee -> ee.getX() > 0)
              .sorted(Comparator.comparing (xx -> xx.getX()))
              .forEach(Point::affiche) ;
    System.out.println () ;
       // tri de tous les points suivant la somme des coordonnees
    l.stream().sorted (Comparator.comparing (xx -> xx.getX() + xx.getY()))
              .forEach  (xx -> System.out.print ("(abs=" + xx.getX()
                            + ", ord=" + xx.getY()) ) ;
  }
}
class Point
{ public Point (int x, int y) { this.x = x ; this.y = y ; }
  public int getX() { return x ; }
  public int getY() { return y ; }
  public void affiche () 
   { System.out.print(" [ " + x + ", " + y + "] ") ; }
  private int x, y ;
}
