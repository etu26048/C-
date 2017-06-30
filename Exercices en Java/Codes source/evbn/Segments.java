import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
class MaFenetre extends JFrame
{ public MaFenetre ()
  { setTitle ("SEGMENT") ;
    setSize (300, 150) ;
    pan =  new Panneau () ;
    getContentPane().add (pan) ;
    pan.addMouseListener (pan) ;
  }
  private Panneau pan ;
}
class Panneau extends JPanel implements MouseListener
{ public void paintComponent (Graphics g)
  { super.paintComponent (g) ;
    if (orConnue && extConnue) g.drawLine (xOr, yOr, xExt, yExt) ;
  }
  public void mousePressed (MouseEvent e)
  { int x=e.getX(), y=e.getY() ;
    int modifieurs = e.getModifiers() ;
    if ( (modifieurs & InputEvent.BUTTON1_MASK) != 0)
    { /* clic bouton gauche */
      xOr = x ; yOr = y ;
      orConnue = true ;
      repaint() ;
    }
    if ( (modifieurs & InputEvent.BUTTON3_MASK) != 0)
    { /* clic bouton droite */
      xExt = x ; yExt = y ;
      extConnue = true ;
      repaint() ;
    }

  }
  public void mouseReleased (MouseEvent e) {}
  public void mouseClicked (MouseEvent e)  {}
  public void mouseEntered (MouseEvent e)  {}
  public void mouseExited (MouseEvent e)   {}
  private int xOr, yOr, xExt, yExt ;
  private boolean orConnue=false, extConnue=false ;
}
public class Segments
{ public static void main (String args[])
  { MaFenetre fen = new MaFenetre() ;
    fen.setVisible (true) ;
  }
}


