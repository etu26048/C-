import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
class MaFenetre extends JFrame
{ public MaFenetre ()
  { setTitle ("Evenements souris") ;
    setSize (300, 150) ;
    contenu = getContentPane() ;
    contenu.setLayout (new FlowLayout()) ;
    addMouseListener (new MouseAdapter()
        { public void mouseEntered (MouseEvent e)
          { System.out.println ("la souris entre dans la fenetre") ;
          }
          public void mouseExited (MouseEvent e)
          { System.out.println ("la souris quitte la fenetre") ;
          }
        }) ;
    bouton = new JButton ("A") ;
    contenu.add (bouton) ;
    bouton.addMouseListener (new MouseAdapter()
        { public void mouseEntered (MouseEvent e)
          { System.out.println ("la souris entre dans le bouton") ;
          }
          public void mouseExited (MouseEvent e)
          { System.out.println ("la souris quitte le bouton") ;
          }
        }) ;
  }
  private JButton bouton ;
  private Container contenu ;
}
public class DpSourb
{ public static void main (String args[])
  { MaFenetre fen = new MaFenetre() ;
    fen.setVisible (true) ;
  }
}


