import javax.swing.* ;
import java.awt.event.* ;
import java.awt.* ;
class MaFenetre extends JFrame implements MouseListener
{ final Color[] couleurs = { Color.red, Color.yellow, Color.blue, Color.green } ;
  public MaFenetre ()
  { setTitle ("Couleurs") ;
    setSize (300, 150) ;
    Container contenu = getContentPane() ;
    coul = new JButton ("Couleur") ;
    contenu.add(coul, "North") ;
    coul.addMouseListener(this);
    pan = new JPanel() ;
    contenu.add(pan) ;
  }
  public void mouseClicked(MouseEvent ev)
  { numCouleur++ ;  
    if (numCouleur >= couleurs.length) numCouleur = 0 ;
    pan.setBackground (couleurs[numCouleur]) ;
  }
  public void mousePressed (MouseEvent ev) {}
  public void mouseReleased(MouseEvent ev) {}
  public void mouseEntered (MouseEvent ev) {}
  public void mouseExited  (MouseEvent ev) {}
  private int numCouleur ;
  private JButton coul ;
  private JPanel pan ;
}
public class Couleurs
{ public static void main (String args[])
  { MaFenetre fen = new MaFenetre() ;
    fen.setVisible (true) ;
  }
}


/*
Changer la couleur de la fenetre à chaque clic
sur un bouton placé en haut
donner "North"
*/

/*
Je croyais que :  Ici, pas besoin de panneau, ni de paintComponent
  car setBackground entraine automatiqumenet
En fait, ca clignote et ca redevient gris
Idem avec appel de repaint

Mais : on vous l'avait bien dit qu'il ne fallait
pas dessiner directement !!!!

Si on fait un panneau et qu'on cherche à intercepter clic
dans fenetre --> rien


En revanche, avec setBackground sur panneau, pas besoin de paintComponent
ni de repaint
*/


/* remarques :
  voir si on pourrait avoir adaptateur car pb
  transmission info fenetre concernee
*/
