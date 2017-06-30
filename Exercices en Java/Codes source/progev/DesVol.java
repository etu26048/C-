import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
class MaFenetre extends JFrame
{ public MaFenetre ()
  { setTitle ("Crayon magique") ;
    setSize (300, 150) ;
    pan = new Panneau () ;
    pan.addMouseListener (pan) ;
    getContentPane().add(pan) ;
  }
  private Panneau pan ;
}
class Panneau extends JPanel implements MouseListener
{ public void paintComponent (Graphics g)
  { super.paintComponent(g) ;
    enCours = false ;
  }
  public void mouseClicked (MouseEvent e)
  { int xFin = e.getX() ; yFin = e.getY() ;
    if (enCours) { Graphics g = getGraphics() ;
                   g.drawLine (xDeb, yDeb, xFin, yFin) ;
                   g.dispose() ;
                 }
    xDeb = xFin ; yDeb = yFin ;
    enCours = true ;
  }
  public void mousePressed  (MouseEvent e) {}
  public void mouseReleased (MouseEvent e) {}
  public void mouseEntered  (MouseEvent e) {}
  public void mouseExited   (MouseEvent e) {}
  private boolean enCours = false ;
  private int xDeb, yDeb, xFin, yFin ;
}
public class DesVol
{ public static void main (String args[])
  { MaFenetre fen = new MaFenetre() ;
    fen.setVisible (true) ;
  }
}

