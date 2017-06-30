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
    Ecout ecouteur = new Ecout (prefixeBouton) ;
    for (int i=0 ; i<nBout ; i++)
    { boutons[i] = new JButton (prefixeBouton + (i+1)) ;
      contenu.add(boutons[i]) ;
      boutons[i].addActionListener (ecouteur) ;
    }
  }
  private int nBout ;
  private JButton[] boutons ;
}
class Ecout implements ActionListener
{ public Ecout (String prefixe)
  { this.prefixe = prefixe ;
  }
  public void actionPerformed (ActionEvent e)
  { String commande = e.getActionCommand () ;
    String chNum = commande.substring (prefixe.length()) ;
    int num = Integer.parseInt(chNum) ;
    for (int i=0 ; i<num ; i++)
      System.out.print("*") ;
    System.out.println () ;
  }
  private String prefixe ;
}
public class Boutons2
{ public static void main (String args[])
  { System.out.print ("Combien de boutons ? ") ;
    int nBoutons = Clavier.lireInt() ;
    FenBoutons fen = new FenBoutons(nBoutons) ;
    fen.setVisible(true) ;
  }
}


