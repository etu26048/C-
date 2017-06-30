import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
class MaFenetre extends JFrame implements KeyListener
{ static int incx=5, incy=5 ;
  public MaFenetre ()
  { setTitle ("DESSIN AU CLAVIER") ;
    setSize (350, 150) ;
    addKeyListener (this) ;
    pan = new JPanel () ;
    getContentPane().add (pan) ;
  }
  public void keyPressed (KeyEvent e)
  { int code = e.getKeyCode () ;
    switch (code)
    { case KeyEvent.VK_UP :    dx = 0 ;     dy = -incy ; bouge = true ; break ;
      case KeyEvent.VK_DOWN :  dx = 0 ;     dy = incy  ; bouge = true ; break ;
      case KeyEvent.VK_LEFT :  dx = -incx ; dy = 0 ;     bouge = true ; break ;
      case KeyEvent.VK_RIGHT : dx = incx ;  dy = 0 ;     bouge = true ; break ;
    }
    if (bouge)
    { Graphics g = pan.getGraphics() ;
      g.drawLine (x, y, x+dx, y+dy) ;
      g.dispose() ;
      x += dx ;
      y += dy ;
    }
  }
  public void keyReleased (KeyEvent e) {}
  public void keyTyped (KeyEvent e)    {}
  private JPanel pan ;
  private int x=20, y=20 ;
  private int dx, dy ;
  private boolean bouge ;
}
public class DesClav
{ public static void main (String args[])
  { MaFenetre fen = new MaFenetre() ;
    fen.setVisible (true) ;
  }
}


