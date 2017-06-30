import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
class MaFenetre extends JFrame implements MouseListener
{ public MaFenetre ()
  { setTitle ("Evenements souris") ;
    setSize (300, 150) ;
    contenu = getContentPane() ;
    contenu.setLayout (new FlowLayout()) ;
    addMouseListener (this) ;
    bouton = new JButton ("A") ;
    contenu.add (bouton) ;
    bouton.addMouseListener (this) ;
  }
  public void mousePressed (MouseEvent e) {}
  public void mouseReleased (MouseEvent e) {}
  public void mouseClicked (MouseEvent e) {}
  public void mouseEntered (MouseEvent e)
  { if (e.getSource() == this)
      System.out.println ("la souris entre dans la fenetre") ;
    if (e.getSource() == bouton)
      System.out.println ("la souris entre dans le bouton") ;
  }
  public void mouseExited (MouseEvent e)
  { if (e.getSource() == this)
      System.out.println ("la souris quitte la fenetre") ;
    if (e.getSource() == bouton)
      System.out.println ("la souris quitte le bouton") ;
  }
  private JButton bouton ;
  private Container contenu ;
}
public class DpSour
{ public static void main (String args[])
  { MaFenetre fen = new MaFenetre() ;
    fen.setVisible (true) ;
  }
}


