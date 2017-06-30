import javax.swing.* ;
import java.awt.* ;
class MaFenetre extends JFrame
{ public MaFenetre ()
  { setTitle ("Dessin permanent") ;
    setSize (300, 150) ;
    pan = new Panneau () ;
    getContentPane().add(pan) ;
  }
  private Panneau pan ;
}
class Panneau extends JPanel
{ private static final int x = 30, y = 20, l = 120, h = 50 ;
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
}
public class DesPer
{ public static void main (String args[])
  { MaFenetre fen = new MaFenetre() ;
    fen.setVisible (true) ;
  }
}





