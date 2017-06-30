import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
class MaFenetre extends JFrame
{ public MaFenetre ()
  { setTitle ("Dessin permanent") ;
    setSize (300, 150) ;
    pan = new Panneau () ;
    pan.addMouseListener (pan) ;  // le panneau sera son propre ecouteur
    getContentPane().add(pan) ;
  }
  private Panneau pan ;
}
class Panneau extends JPanel implements MouseListener
{ private static final int x = 30, y = 20, l = 120, h = 50 ;
  private static final Color[] couleurs = {Color.yellow, Color.blue,
                                           Color.green,  Color.red } ;
  public void paintComponent (Graphics g)
  { super.paintComponent(g) ;
      // trace du rectangle
    g.drawLine (x,   y,   x+l, y) ;
    g.drawLine (x+l, y,   x+l, y+h) ;
    g.drawLine (x+l, y+h, x,   y+h) ;
    g.drawLine (x,   y+h, x,   y) ;
      // trace des diagonales
    g.drawLine (x,   y,   x+l, y+h) ;
    g.drawLine (x,   y+h, x+l, y) ;
  }
  public void mouseClicked (MouseEvent e)
  { setBackground (couleurs[numCoul]) ;
    numCoul++ ;
    if (numCoul >= couleurs.length) numCoul = 0 ;
  }
  public void mousePressed  (MouseEvent e) {}
  public void mouseReleased (MouseEvent e) {}
  public void mouseEntered  (MouseEvent e) {}
  public void mouseExited   (MouseEvent e) {}
  private int numCoul = 0 ;
}
public class DesCoul
{ public static void main (String args[])
  { MaFenetre fen = new MaFenetre() ;
    fen.setVisible (true) ;
  }
}





