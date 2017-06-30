import java.awt.*;
import java.awt.event.* ;
import javax.swing.* ;
import javax.swing.event.* ;

class FenRect extends JFrame implements ActionListener
{ public FenRect (Color [] couleurs, String [] nomsCouleurs)
  { setTitle ("Menus surgissants composes") ;
    setSize (300, 150) ;
    this.couleurs = couleurs ;
    this.nomsCouleurs = nomsCouleurs ;
     /* creation menus surgissants Fond et Forme */
    menuFond = new JPopupMenu () ;
    menuForme = new JPopupMenu () ;
    menuFormeCouleur = new JMenu ("Couleur") ;
    menuForme.add (menuFormeCouleur) ;
    menuFormeDimensions = new JMenu ("Dimensions") ;
    menuForme.add (menuFormeDimensions) ;
     /* creation des options */
    nbCouleurs = couleurs.length ;
    optionsCouleurFond =  new JMenuItem [nbCouleurs] ;
    optionsCouleurForme = new JMenuItem [nbCouleurs] ;
    for (int i=0 ; i<nbCouleurs ; i++)
     { optionsCouleurForme[i] = new JMenuItem (nomsCouleurs[i]) ;
       optionsCouleurForme[i].addActionListener (this) ;
       menuFormeCouleur.add (optionsCouleurForme[i]) ;
       optionsCouleurFond[i] = new JMenuItem (nomsCouleurs[i]) ;
       optionsCouleurFond[i].addActionListener (this) ;
       menuFond.add  (optionsCouleurFond[i]) ;
     }
    optionHauteur = new JMenuItem ("Hauteur") ;
    optionLargeur = new JMenuItem ("Largeur") ;
    menuFormeDimensions.add (optionHauteur) ;
    menuFormeDimensions.add (optionLargeur) ;
    optionHauteur.addActionListener (this) ;
    optionLargeur.addActionListener (this) ;
     /* creation panneau de dessin */
    panneau = new Panneau (this, menuForme, menuFond) ;
    panneau.addMouseListener (panneau) ;
    getContentPane().add (panneau) ;
  }
  public void actionPerformed (ActionEvent e)
  { Object source = e.getSource() ;
    for (int i=0 ; i<nbCouleurs ; i++)
     { if (source == optionsCouleurFond[i])  couleurFond = couleurs[i] ;
       if (source == optionsCouleurForme[i]) couleurForme = couleurs[i] ;
     }
     if ((source == optionLargeur) || (source == optionHauteur))
     { int valeur=0 ;
       String question ;
       boolean ok=false ;
       if (source == optionLargeur) question = "Nouvelle largeur ?" ;
                              else  question = "Nouvelle hauteur ?" ;
       String rep = JOptionPane.showInputDialog (null, question) ;
       try
       { valeur = Integer.parseInt (rep) ;
         ok = true ;
       }
       catch (NumberFormatException ex)
       {
       }
       if (ok) if (source == optionLargeur)  l = valeur ;
                                        else h = valeur ;
     }
     panneau.repaint() ;  // pour forcer a repeindre l'ensemble de la fenetre
  }
  public Color getCouleurFond ()      { return couleurFond ;     }
  public Color getCouleurForme ()     { return couleurForme ;    }
  public int getLargeur ()            { return l ; }
  public int getHauteur ()            { return h ; }
  private Color[] couleurs ;
  private String[] nomsCouleurs ;
  private Panneau panneau ;
  private JPopupMenu menuFond, menuForme ;
  private JMenu menuFormeCouleur, menuFormeDimensions ;
  private JMenuItem[] optionsCouleurFond, optionsCouleurForme ;
  private JMenuItem optionHauteur, optionLargeur ;
  private int nbCouleurs ;
  private Color couleurFond=Color.white, couleurForme=Color.black ;
  private int l=100, h=50 ;
}
class Panneau extends JPanel implements MouseListener
{ private static int x=10, y=10 ;
  public Panneau (FenRect fen, JPopupMenu menuForme, JPopupMenu menuFond)
  { this.fen = fen ;
    this.menuForme = menuForme ;
    this.menuFond  = menuFond ;
  }
  public void mouseReleased (MouseEvent e)
  { if(!e.isPopupTrigger ()) return ;
    int xClic = e.getX(), yClic = e.getY() ;
    if ((xClic>=x) && (xClic<=x+largeur) && (yClic>=y) && (yClic<=y+hauteur) )
       menuForme.show (fen, xClic, yClic) ;
    else
      menuFond.show (fen, xClic, yClic) ;
  }
  public void mousePressed (MouseEvent e) {}
  public void mouseClicked (MouseEvent e) {}
  public void mouseEntered (MouseEvent e) {}
  public void mouseExited  (MouseEvent e) {}

  public void paintComponent (Graphics g)
  { super.paintComponent(g) ;
    setBackground (fen.getCouleurFond()) ;
    g.setColor (fen.getCouleurForme()) ;
    largeur = fen.getLargeur() ;
    hauteur = fen.getHauteur() ;
    g.fillRect (x, y, largeur, hauteur) ;
  }
  private FenRect fen ;
  private int largeur, hauteur ;
  private JPopupMenu menuForme, menuFond ;
}


public class Compsurg
{ private static Color [] couleurs =
         {Color.yellow, Color.red, Color.blue, Color.pink, Color.green } ;
  private static String[] nomsCouleurs =
         {"jaune",      "rouge",   "bleu",     "rose",     "vert"       } ;
  public static void main (String args[])
  { FenRect fen = new FenRect(couleurs, nomsCouleurs) ;
    fen.setVisible(true) ;
  }
}



