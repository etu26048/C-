import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
public class AppRect extends JApplet  // ne pas oublier public
{ String nomsCouleurs[] = {"rouge",   "vert",      "bleu",     "jaune" } ;
  Color couleurs[]      = {Color.red, Color.green, Color.blue, Color.yellow} ;
  public void init ()
  { Container contenu = getContentPane () ;
    pan = new Panneau (this) ;
    contenu.add (pan) ;   // avec le gestionnaire BorderLayout, le panneau
                          // occupe toute la fenetre
     /* recuperation parametres dimension applet, dimension rectangle, couleur */
    String chLargeurApplet = getParameter ("width") ;
    String chHauteurApplet = getParameter ("height") ;
    String chLargeurRect   = getParameter ("Largeur") ;
    String chHauteurRect   = getParameter ("Hauteur") ;
    try
    { largeurApplet = Integer.parseInt (chLargeurApplet) ;
      hauteurApplet = Integer.parseInt (chHauteurApplet) ;
      largeurRect   = Integer.parseInt (chLargeurRect) ;
      hauteurRect   = Integer.parseInt (chHauteurRect) ;
    }
    catch (NumberFormatException ex)
    { /* on attribue des dimensions par defaut pour le rectangle */
           /*  (celles de l'applet sont toujours bonnnes) */
      largeurRect = 80 ; hauteurRect = 50 ;
    }
    nomCouleur = getParameter ("Couleur") ;
    couleur = Color.black ;   // couleur par defaut
    for (int i=0 ; i<nomsCouleurs.length ; i++)
    { if (nomCouleur.equals(nomsCouleurs[i])) couleur =  couleurs[i] ;
    }
  }
  public int getLargeurApplet () { return largeurApplet ; }
  public int getHauteurApplet () { return hauteurApplet ; }
  public int getLargeurRect ()   { return largeurRect ;   }
  public int getHauteurRect ()   { return hauteurRect ;   }
  public Color getCouleur ()     { return couleur ;       }
  private Panneau pan ;
  private int largeurApplet, hauteurApplet, largeurRect, hauteurRect ;
  private String nomCouleur ;
  private Color couleur ;
}
class Panneau extends JPanel
{ public Panneau (AppRect ap)
  { this.ap = ap ;
  }
  public void paintComponent (Graphics g)
  { super.paintComponent (g) ;
    int x = (ap.getLargeurApplet() - ap.getLargeurRect())/2 ;
    int y = (ap.getHauteurApplet() - ap.getHauteurRect())/2 ;
    g.setColor(ap.getCouleur()) ;
    g.fillRect(x, y, ap.getLargeurRect(), ap.getHauteurRect()) ;
  }
  AppRect ap ;
}



