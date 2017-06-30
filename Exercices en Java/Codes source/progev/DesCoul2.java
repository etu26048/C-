import javax.swing.* ;
import java.awt.event.* ;
import java.awt.* ;
class MaFenetre extends JFrame implements ActionListener
{ public MaFenetre ()
  { setTitle ("Dessin et Couleurs") ;
    setSize (300, 150) ;
    Container contenu = getContentPane() ;
    pan = new Panneau() ;
    contenu.add(pan) ;
    coulFond = new JButton ("Couleur fond") ;
    contenu.add(coulFond, "North") ;
    coulFond.addActionListener (this);
    coulTrait = new JButton ("Couleur trait") ;
    contenu.add (coulTrait, "South") ;
    coulTrait.addActionListener (this) ;
  }
  public void actionPerformed  (ActionEvent e)
  { if (e.getSource() == coulFond)  pan.changeCoulFond() ;
    if (e.getSource() == coulTrait) pan.changeCoulTrait() ;
  }
  private int numCouleur ;
  private JButton coulFond, coulTrait ;
  private Panneau pan ;
}
class Panneau extends JPanel
{ final Color[] couleurs = { Color.red, Color.yellow, Color.blue, Color.green,
                             Color.gray, Color.pink,  Color.cyan, Color.white } ;
  public void paintComponent (Graphics g)
  { super.paintComponent (g) ;
    setBackground (couleurs[numCoulFond]) ;
    setForeground (couleurs[numCoulTrait]) ;
    Dimension dim = getSize() ;
    int x = 5, y = 5 ;
    int l = dim.width, h = dim.height ;
        // trace du rectangle
    g.drawLine (x,   y,   l-x, y) ;
    g.drawLine (l-x, y,   l-x, h-y) ;
    g.drawLine (l-x, h-y, x,   h-y) ;
    g.drawLine (x,   h-y, x,   y) ;
      // trace des diagonales
    g.drawLine (x,   y,   l-x, h-y) ;
    g.drawLine (x,   h-y, l-x, y) ;
  }
  public void changeCoulFond()
  { numCoulFond++ ;
    if (numCoulFond >= couleurs.length) numCoulFond = 0 ;
    repaint() ;
  }
  public void changeCoulTrait()
  { numCoulTrait++ ;
    if (numCoulTrait >= couleurs.length) numCoulTrait = 0 ;
    repaint() ;
  }
  private int numCoulFond=0, numCoulTrait=1 ;
}
public class DesCoul2
{ public static void main (String args[])
  { MaFenetre fen = new MaFenetre() ;
    fen.setVisible (true) ;
  }
}


