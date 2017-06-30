public class TraiteListe
{ public static void main (String [] args)
  { Point [] tab = { new Point(2, 5), new Point(-3, 4),
                     new Point(2, 3), new Point(6, -3) } ;
    ArrayList<Point> l = new ArrayList<Point>() ;
    for (Point p : tab) l.add(p) ;
       // selection des points d'abscisse positive,
       // tri sur l'abscisse utilisant Comparator.comparing 
    traiteListe (l, ee -> ee.getX()>0, 
                 Comparator.comparing(Point::getX), 
                 Point::affiche) ;
    System.out.println () ;
       // meme chose avec un comparateur sous forme d’expression lambda
    traiteListe (l, ee -> ee.getX()>0, 
                 (pp1, pp2) -> ((Integer)(pp1.getX()))
                 .compareTo (((Integer)(pp2.getX()))),         
                 Point::affiche) ;
    System.out.println () ;
       // tri de tous les points suivant la somme des coordonnees
       //     avec Comparator.comparing
    traiteListe (l, xx -> true, 
                 Comparator.comparing (xx -> xx.getX() + xx.getY()),
                 (xx -> System.out.print ("(abs = " + xx.getX() 
                              + ", ord = " + xx.getY() + ") ") )) ;
  }
  public static void traiteListe (ArrayList<Point> liste,
                                  Predicate<Point> selec,
                                  Comparator<Point> comp,
                                  Consumer<Point> aff)
  { ArrayList<Point> liste2 = new ArrayList <Point>() ;
    liste.forEach (ee -> { if (selec.test(ee)) liste2.add(ee) ; }) ;
    liste2.sort(comp);
    liste2.forEach(ee -> aff.accept(ee)) ;
  }
}
class Point
{ public Point (int x, int y) { this.x = x ; this.y = y ; }
  public int getX() { return x ; }
  public int getY() { return y ; }
  public void affiche () { System.out.print(" [ " + x + ", " + y + "] ") ; }
  private int x, y ;
 }
