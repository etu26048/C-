import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
class MaFenetre extends JFrame implements MouseListener
{ public MaFenetre ()
  { setTitle ("DOUBLES CLICS") ;
    setSize (300, 150) ;
    clicGauche = false ;
    addMouseListener (this) ;
  }
  public void mousePressed (MouseEvent e)  {}
  public void mouseReleased (MouseEvent e) {}
  public void mouseClicked (MouseEvent e)
  { int modifieurs = e.getModifiers () ;
    if ((modifieurs & InputEvent.BUTTON1_MASK) != 0)
     /* ici, on a affaire a un clic gauche */
    { if ((e.getClickCount() == 2) && clicGauche)
       { System.out.println ("Double clic gauche") ;
         clicGauche = false ;
       }
      else clicGauche = true ;
    }
    else clicGauche = false ;
  }
  public void mouseEntered (MouseEvent e) {}
  public void mouseExited (MouseEvent e ) {}
  private boolean clicGauche ;
}
public class DoubClic
{ public static void main (String args[])
  { MaFenetre fen = new MaFenetre() ;
    fen.setVisible (true) ;
  }
}


