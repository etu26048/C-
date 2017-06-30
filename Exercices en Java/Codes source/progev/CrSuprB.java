import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
class FenBoutDyn extends JFrame implements ActionListener
{ public FenBoutDyn (int nBoutMax)
  { setTitle ("Creation - suppression de boutons (maxi " + nBoutMax + ")") ;
    setSize (500, 180) ;
    Container contenu = getContentPane() ;

    creation = new JButton ("CREATION") ;
    contenu.add (creation, "North") ;
    creation.addActionListener (this) ;

    suppression = new JButton ("SUPPRESSION") ;
    contenu.add (suppression, "South") ;
    suppression.addActionListener (this) ;

    pan = new JPanel () ;
    contenu.add (pan) ;    // au centre par defaut

    boutons = new JButton [nBoutMax] ;
    boutSelec = new boolean [nBoutMax] ;
  }
  public void actionPerformed (ActionEvent e)
  { Object source = e.getSource() ;
    if (source == creation)
    { boutons[nBout] = new JButton ("BOUTON " + (nBout+1)) ;
      boutons[nBout].setBackground (Color.yellow) ;
      boutSelec[nBout] = false ;
      pan.add (boutons[nBout]) ;
      boutons[nBout].addActionListener (this) ;
      pan.validate(); // pour forcer le recalcul par le gestionnaire
      nBout++ ;
    }
    if (source == suppression)
    { for (int i=0 ; i<nBout ; i++)
        if (boutSelec[i]) pan.remove(boutons[i]); ;
      pan.validate() ;
    }
    for (int i=0 ; i<nBout ; i++)
    { if (source == boutons[i])
        if (boutSelec[i])
         { boutSelec[i] = false ;
           boutons[i].setBackground(Color.yellow) ;
         }
       else
         { boutSelec[i] = true ;
           boutons[i].setBackground (Color.red) ;
         }
    }
  }
  private JButton creation, suppression ;
  private JPanel pan ;
  private static int nBout = 0 ;
  private JButton [] boutons ;
  private boolean[] boutSelec ;
}

public class CrSuprB
{ public static void main (String args[])
  { FenBoutDyn fen = new FenBoutDyn(50) ;
    fen.setVisible(true) ;
  }
}

