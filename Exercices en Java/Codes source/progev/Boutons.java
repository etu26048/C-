import javax.swing.* ;
import java.awt.* ;     
import java.awt.event.* ;
class FenBoutons extends JFrame
{ public FenBoutons (int nBout)
  { setTitle ("BOUTONS") ;
    setSize (300, 200) ;
    Container contenu = getContentPane() ;
    contenu.setLayout (new FlowLayout()) ;
    for (int i=0 ; i<nBout ; i++)
    { unBouton = new JButton ("ESSAI") ;
      contenu.add(unBouton) ;
    }
  }
  private JButton unBouton ;
}
public class Boutons
{ public static void main (String args[])
  { final int nBoutons = 5 ;
    FenBoutons fen = new FenBoutons(nBoutons) ;
    fen.setVisible(true) ;
  }
}

