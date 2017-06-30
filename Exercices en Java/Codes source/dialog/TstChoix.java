import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
class BoiteConfirme extends JDialog implements ActionListener
{ public BoiteConfirme (JFrame parent, String message)
  { super (parent, "CHOIX", true) ;
    setSize (200,100) ;
    // mise en place des composants : bouton OK, étiquette
    Container contenu = getContentPane() ;
    contenu.setLayout (new FlowLayout()) ;
    JLabel txt = new JLabel (message) ;
    contenu.add (txt) ;
    yes = new JButton ("Oui") ;
    yes.addActionListener (this) ;
    contenu.add (yes) ;
    no = new JButton ("Non") ;
    contenu.add (no) ;
    no.addActionListener (this) ;
    cancel = new JButton ("Annul") ;
    contenu.add (cancel) ;
    cancel.addActionListener (this) ;
  }
  public void actionPerformed (ActionEvent e)
  { if (e.getSource() == yes)    etat = 0 ;
    if (e.getSource() == no)     etat = 1 ;
    if (e.getSource() == cancel) etat = 2 ;
    setVisible (false) ;
  }
  public int getEtat() { return etat ; }
  private JButton yes, no, cancel ;
  private int etat = -1 ;
}

class Util
{ static int afficheConfirme (JFrame parent, String message)
  { // création de l'objet boite de dialogue
    BoiteConfirme boiteConf = new BoiteConfirme (parent, message) ;
    // affichage du dialogue
    boiteConf.setVisible (true) ;
    // fin du dialogue
    boiteConf.dispose() ;
    return boiteConf.getEtat() ;
  }
}

public class TstChoix
{ public static void main (String args[])
  { JFrame fen = new JFrame("Essai Boite Confirmation") ;
    fen.setSize (400, 300) ;
    fen.setVisible (true) ;
    int rep = Util.afficheConfirme (fen, "Voulez-vous continuer ?") ;
    System.out.println ("reponse = " + rep) ;
  }
}

