import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
class FenBoutons extends JFrame
{ public FenBoutons (int nBout)
  { final String prefixeBouton = "BOUTON" ;
    this.nBout = nBout ;
    setTitle ("BOUTONS") ;
    setSize (200, 150) ;
    Container contenu = getContentPane() ;
    contenu.setLayout (new FlowLayout()) ;
    boutons = new JButton [nBout] ;
    Ecout ecouteur = new Ecout () ;
    for (int i=0 ; i<nBout ; i++)
    { boutons[i] = new JButton (prefixeBouton + (i+1)) ;
      contenu.add(boutons[i]) ;
      boutons[i].addActionListener (ecouteur) ;
      boutons[i].setActionCommand (String.valueOf(i+1)) ;
    }
  }
  private int nBout ;
  private JButton[] boutons ;
}
class Ecout implements ActionListener
{ public void actionPerformed (ActionEvent e)
  { String commande = e.getActionCommand () ;
    int num = Integer.parseInt(commande) ;
    for (int i=0 ; i<num ; i++)
      System.out.print("*") ;
    System.out.println () ;
  }
}
public class Boutonsb
{ public static void main (String args[])
  { System.out.print ("Combien de boutons ? ") ;
    int nBoutons = Clavier.lireInt() ;
    FenBoutons fen = new FenBoutons(nBoutons) ;
    fen.setVisible(true) ;
  }
}


