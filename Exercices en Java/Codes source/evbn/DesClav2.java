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
    bouge = false ;
    switch (code)
    { case KeyEvent.VK_UP :    dx = 0 ;     dy = -incy ; bouge = true ; break ;
      case KeyEvent.VK_DOWN :  dx = 0 ;     dy = incy  ; bouge = true ; break ;
      case KeyEvent.VK_LEFT :  dx = -incx ; dy = 0 ;     bouge = true ; break ;
      case KeyEvent.VK_RIGHT : dx = incx ;  dy = 0 ;     bouge = true ; break ;
    }
    if (bouge)
    { Graphics g = pan.getGraphics() ;
      g.setXORMode (pan.getBackground()) ;
         /* efface l'ancien curseur (s'il existe) et affiche le nouveau */
      if (debut) debut = false ;
         else afficheCurseur (g, x, y) ;
      afficheCurseur (g, x+dx, y+dy) ;
      g.setPaintMode() ;
        /* on ne trace que si la touche Shift est enfoncee */
      if ( (e.getModifiers() & InputEvent.SHIFT_MASK) != 0)
                g.drawLine (x, y, x+dx, y+dy) ;
      x += dx ;
      y += dy ;
      g.dispose() ;
    }
  }
  private void afficheCurseur (Graphics g, int x, int y)
  { int dx=2, dy=2 ;
    g.drawLine (x-dx, y-dy, x+dx, y+dy) ;
    g.drawLine (x-dx, y+dy, x+dx, y-dy) ;
  }
  public void keyReleased (KeyEvent e) {}
  public void keyTyped (KeyEvent e)    {}
  private JPanel pan ;
  private int x=20, y=20 ;
  private int dx, dy ;
  private boolean bouge ;
  private boolean debut = true ;
}
public class DesClav2
{ public static void main (String args[])
  { MaFenetre fen = new MaFenetre() ;
    fen.setVisible (true) ;
  }
}

