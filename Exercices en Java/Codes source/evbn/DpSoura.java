import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
class MaFenetre extends JFrame
{ public MaFenetre ()
  { setTitle ("Evenements souris") ;
    setSize (300, 150) ;
    contenu = getContentPane() ;
    contenu.setLayout (new FlowLayout()) ;
    MouseAdapter ecout = new MouseAdapter()
        { public void mouseEntered (MouseEvent e)
          { if (e.getSource() == contenu)
              System.out.println ("la souris entre dans la fenetre") ;
            if (e.getSource() == bouton)
              System.out.println ("la souris entre dans le bouton") ;
          }
          public void mouseExited (MouseEvent e)
          { if (e.getSource() == contenu)
              System.out.println ("la souris quitte la fenetre") ;
            if (e.getSource() == bouton)
              System.out.println ("la souris quitte le bouton") ;
          }
        } ;
    contenu.addMouseListener (ecout) ;
    bouton = new JButton ("A") ;
    contenu.add (bouton) ;
    bouton.addMouseListener (ecout) ;
  }
  private JButton bouton ;
  private Container contenu ;
}
public class DpSoura
{ public static void main (String args[])
  { MaFenetre fen = new MaFenetre() ;
    fen.setVisible (true) ;
  }
}

