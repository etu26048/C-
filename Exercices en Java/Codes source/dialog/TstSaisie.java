import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
class BoiteSaisie extends JDialog implements ActionListener
{ public BoiteSaisie (JFrame parent, String message)
  { super (parent, "SAISIE", true) ;
    setSize (240,150) ;
    // mise en place des composants
    Container contenu = getContentPane() ;
    contenu.setLayout (new FlowLayout()) ;
    JLabel txt = new JLabel (message) ;
    contenu.add (txt) ;
    saisie =  new JTextField (20) ;
    contenu.add (saisie) ;
    ok = new JButton ("OK") ;
    ok.addActionListener (this) ;
    contenu.add (ok) ;
    cancel = new JButton ("Annul") ;
    contenu.add (cancel) ;
    cancel.addActionListener (this) ;
  }
  public void actionPerformed (ActionEvent e)
  { if (e.getSource() == ok)
     { infoLue = saisie.getText() ;
     }
    setVisible (false) ;
  }
  public String getInfo ()
  { return infoLue ;
  }
  private JButton ok, cancel ;
  private JTextField saisie ;
  private String infoLue = null ;
}

class Util
{ static String afficheSaisie (JFrame parent, String message)
  { // création de l'objet boite de dialogue
    BoiteSaisie boiteSaisie = new BoiteSaisie (parent, message) ;
    // affichage du dialogue
    boiteSaisie.setVisible (true) ;
    // fin du dialogue
    boiteSaisie.dispose() ;
    return boiteSaisie.getInfo() ;
  }
}

public class TstSaisie
{ public static void main (String args[])
  { String rep ;
    JFrame fen = new JFrame("Essai Boite de saisie") ;
    fen.setSize (400, 300) ;
    fen.setVisible (true) ;
    do  // on interroge l'utilisateur jusqu'a ce qu'il reponde "fin"
    { rep = Util.afficheSaisie (fen, "Donnez un texte ?") ;
      if (rep != null)
        System.out.println ("reponse = " + rep) ;
    }
    while ((rep == null) || !rep.equals("fin")) ;
  }
}

