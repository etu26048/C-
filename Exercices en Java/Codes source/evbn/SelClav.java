import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
class MaFenetre extends JFrame implements KeyListener
{ private static int nBoutons = 7 ;
  public MaFenetre ()
  { setTitle ("SELECTIONS PAR CLAVIER") ;
    setSize (350, 150) ;
    Container contenu = getContentPane() ;
    contenu.setLayout (new FlowLayout()) ;
    addKeyListener (this) ;
    boutons = new JButton [nBoutons] ;
    for (int i=0 ; i<nBoutons ; i++)
    { boutons[i] = new JButton ("BOUTON "+(i+1)) ;
      contenu.add(boutons[i]) ;
    }
  }
  public void keyPressed (KeyEvent e)  {}
  public void keyReleased (KeyEvent e) {}
  public void keyTyped (KeyEvent e)
  { char c = e.getKeyChar() ;
    int num = c -'0' ;
    if ( (num>0) && (num<=nBoutons))
      boutons[num-1].requestFocus() ;
  }
  private JButton boutons[] ;
}

public class SelClav
{ public static void main (String args[])
  { MaFenetre fen = new MaFenetre() ;
    fen.setVisible (true) ;
  }
}


