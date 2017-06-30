import java.util.* ;
public class EssaiTri
{ public static void main (String args[])
  { ArrayList <Cercle> liste = new ArrayList <Cercle> () ;
    Cercle c1 = new Cercle (5, 3, 5.0) ; 
    Cercle c2 = new Cercle (1, 9, 3.5) ;
    Cercle c3 = new Cercle (2, 9, 2.5) ; 
    liste.add (c1) ; liste.add (c2) ; liste.add (c3) ;
      // tri suivant le rayon du cercle
    Collections.sort (liste) ;
    System.out.println ("-- Cercles tries par rayon croissant") ;
    for (Cercle c : liste) c.affiche () ;
   }
}
class Cercle implements Comparable<Cercle>
{ public Cercle (int x, int y, double rayon) 
  { this.x = x ; this.y = y ; this.rayon = rayon ; } 
  public void affiche ()
  { System.out.println ("Coordonnees : " + x + ", " + y 
                        + " ; rayon : " + rayon) ;
  }
  public int compareTo (Cercle c)
  { if (rayon < c.rayon ) return -1 ;
    else if ( rayon == c.rayon) return 0 ;
    else return 1 ;
  }
  public double getRayon () { return rayon ; }   // inutilisee ici
  public int getX () { return x ; }              // inutilisee ici
  private int x, y ;
  double rayon ;
}