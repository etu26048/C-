import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
class DialogueSaisieHeure extends JDialog implements ActionListener
{ public DialogueSaisieHeure (JFrame parent)
  { super (parent, "ENTREZ UNE HEURE", true) ;
    this.parent = parent ;
    setSize (240,120) ;
    // mise en place des composants
    Container contenu = getContentPane() ;
    contenu.setLayout (new FlowLayout()) ;
    JLabel etiqHeures = new JLabel ("Heures ") ;
    contenu.add (etiqHeures) ;
    saisieHeures =  new JTextField (3) ;
    contenu.add (saisieHeures) ;
    JLabel etiqMinutes = new JLabel ("Minutes ") ;
    contenu.add (etiqMinutes) ;
    saisieMinutes =  new JTextField (3) ;
    contenu.add (saisieMinutes) ;
    ok = new JButton ("OK") ;
    ok.addActionListener (this) ;
    contenu.add (ok) ;
    cancel = new JButton ("Annul") ;
    contenu.add (cancel) ;
    cancel.addActionListener (this) ;
  }
  public void actionPerformed (ActionEvent e)
  { if (e.getSource() == ok)
    {   // recuperation infos saisies
      String chHeures =  saisieHeures.getText() ;
      String chMinutes = saisieMinutes.getText() ;
        // essai de conversion en entiers
      try
      { heures =  Integer.parseInt (chHeures) ;
        minutes = Integer.parseInt (chMinutes) ;
      }
      catch (NumberFormatException eX)
      { JOptionPane.showMessageDialog (parent, "Valeurs non numériques") ;
        saisieHeures.setText ("") ;
        saisieMinutes.setText ("") ;
        return ;
      }
        // conversion reussie - verification des plages
      if ( (heures>=0) && (heures<24) && (minutes>=0) && (minutes<60))
        correct = true ;
      else
        { JOptionPane.showMessageDialog (parent, "Valeurs hors plage") ;
          saisieHeures.setText ("") ;
          saisieMinutes.setText ("") ;
          return ;
        }
    }
    setVisible (false) ;
  }
  public int getHeures()
  { return heures ;
  }
  public int getMinutes()
  { return minutes ;
  }

  public boolean lanceDialog ()
  { correct = false ;
     // affichage du dialogue
    setVisible (true) ;
    // fin du dialogue
    dispose() ;
    return correct ;
  }
  private JFrame parent ;
  private JButton ok, cancel ;
  private JTextField saisieHeures, saisieMinutes ;
  private int heures, minutes ;
  private boolean correct ;
}

public class TstHM
{ public static void main (String args[])
  { DialogueSaisieHeure boiteHeure ;
    JFrame fen = new JFrame("Essai boite saisie heure") ;
    fen.setSize (400, 300) ;
    fen.setVisible (true) ;

    boiteHeure = new DialogueSaisieHeure (fen) ;
    if (boiteHeure.lanceDialog () == true)
     { System.out.println ("Heure fournie : " + boiteHeure.getHeures() + "h "
                                              + boiteHeure.getMinutes() + "mn") ;
     }
    else
      System.out.println ("dialogue abandonne") ;
    boiteHeure.dispose() ;  
  }
}


// dire qu'on pourrait créer une fois et ....
