import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
class MaFenetre extends JFrame implements FocusListener
{ private static int nBoutons = 8 ;
  private static Color coulRepos = Color.yellow, coulSelec = Color.red ;
  public MaFenetre ()
  { setTitle ("SELECTIONS COLOREES") ;
    setSize (350, 150) ;
    Container contenu = getContentPane() ;
    contenu.setLayout (new FlowLayout()) ;
    for (int i=0 ; i<nBoutons ; i++)
    { bouton = new JButton ("BOUTON "+(i+1)) ;
      contenu.add(bouton) ;
      bouton.addFocusListener (this) ;
      bouton.setBackground (coulRepos) ;
    }
  }
  public void focusGained (FocusEvent e)
  { Object source = e.getSource() ;
    if (source instanceof JButton )
    { JButton  bSource = (JButton) source ;
       bSource.setBackground (coulSelec) ;
    }
  }
  public void focusLost (FocusEvent e)
  { Object source = e.getSource() ;
    if (source instanceof JButton )
    { JButton bSource = (JButton) source ;
      bSource.setBackground (coulRepos) ;
    }  
  }
  private JButton bouton ;
}

public class SelecCol
{ public static void main (String args[])
  { MaFenetre fen = new MaFenetre() ;
    fen.setVisible (true) ;
  }
}


