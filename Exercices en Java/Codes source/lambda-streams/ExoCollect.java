import java.util.* ;
import java.util.stream.* ;
public class ExoCollect
{ public static void main (String [] args)
  { Point[] tabPoints = { new Point(2, 4), new Point(3, 8), new Point(1, 3),
                          new Point(-2, 4), new Point(3, 8), new Point(1,3)} ;
  Set<Point> ens = Stream.of(tabPoints).filter(xx -> xx.getX()>0)
                                       .collect(Collectors.toSet()) ;
  System.out.print("Ensemble : ") ;
  ens.forEach (pp -> System.out.print ("["+pp.getX()+", "
                                         + pp.getY() + "] ")) ;
  Integer [] tab = { 2, 15, -3, 2, -5, 23, -8, 12 } ;
  List<Point> liste = Stream.of(tab).map(xx -> new Point (xx, 2*xx))
                                    .collect(Collectors.toList()) ;
  System.out.print("\nListe : ") ;
  liste.forEach (pp -> System.out.print ("["+pp.getX()+", "+pp.getY()+"] ")) ;
  String [] mots = {"bonjour", "hello", "buongiorno", "hi", "chao",
                    "bom dia", "guten tag" } ;
  String mots_longs = Stream.of(mots).collect(Collectors.joining("|")) ;
  System.out.println ("\nchaine des mots longs : "+mots_longs) ;
  Map <String, List<String>> map = Stream.of(mots)
                 .filter(xx -> xx.length()>4)   
                 .collect(Collectors.groupingBy(xx ->(xx.substring(0,1)))) ;
  System.out.println ("MAP: "+map) ;
 }
}
class Point
{ public Point (int x, int y) { this.x = x ; this.y = y ; }
  public int getX() { return x ; }
  public int getY() { return y ; }
  private int x, y ;
}