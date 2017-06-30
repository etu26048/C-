import java.awt.*;
import java.awt.event.* ;
import javax.swing.* ;
import javax.swing.event.* ;

class FenMenu extends JFrame implements ActionListener,MenuListener
{ static Color [] couleurs = {Color.red, Color.yellow, Color.blue, Color.green} ;
  static String[] nomsCouleurs = { "Rouge", "Jaune", "Bleu", "Vert" } ;
  public FenMenu ()
  { setTitle ("COULEURS") ;
    setSize (300, 150) ;
     /* creation panneau occupant toute la fenetre */
    panneau = new Panneau (this) ;
    getContentPane().add(panneau) ;
     /* creation barre des menus */
    barreMenus = new JMenuBar() ;
    setJMenuBar(barreMenus) ;
     /* creation menu Couleur et ses options */
    menuCouleur = new JMenu ("Couleur") ;
    barreMenus.add(menuCouleur) ;
    menuCouleur.addMenuListener (this) ;
    nbCouleurs = couleurs.length ;
    optionsCouleurs = new JRadioButtonMenuItem [nbCouleurs] ;
    ButtonGroup groupe = new ButtonGroup () ;
    for (int i=0 ; i<nbCouleurs ; i++)
      { optionsCouleurs[i] = new JRadioButtonMenuItem (nomsCouleurs[i]) ;
        menuCouleur.add (optionsCouleurs[i]) ;
        optionsCouleurs[i].addActionListener (this) ;
        groupe.add(optionsCouleurs[i]) ;
      }
    couleurCourante = couleurs [numCouleur] ;
  }
  public void actionPerformed (ActionEvent e)
  { Object source = e.getSource() ;
    for (int i=0 ; i<nbCouleurs ; i++)
      if (source == optionsCouleurs[i])
         { numCouleur = i ;
           couleurCourante = couleurs[numCouleur] ;
           repaint() ;  // pour forcer a repeindre toute la fenetre
         }
  }
  public void menuSelected (MenuEvent e)
  { couleurCourante = Color.white ;
  }
  public void menuDeselected (MenuEvent e)
  { couleurCourante = couleurs [numCouleur] ;
  }
  public void menuCanceled   (MenuEvent e) {}
  public Color getCouleur ()
  { return couleurCourante ;
  }
  private Panneau panneau ;
  private JMenuBar barreMenus ;
  private JMenu menuCouleur  ;
  private JRadioButtonMenuItem optionsCouleurs[] ;
  private int nbCouleurs ;
  private int numCouleur=0 ;
  private Color couleurCourante ;
}
class Panneau extends JPanel
{ public Panneau (FenMenu fen)
  { this.fen = fen ;
  }
  public void paintComponent (Graphics g)
  { super.paintComponent (g) ;
    setBackground (fen.getCouleur()) ;
  }
  private FenMenu fen ;
}
public class Coul1
{ public static void main (String args[])
  { FenMenu fen = new FenMenu() ;
    fen.setVisible(true) ;
  }
}

