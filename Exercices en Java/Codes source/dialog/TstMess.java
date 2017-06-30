import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
class Util
{ static void afficheMessage (JFrame parent, String message)
  { // création de l'objet boite de dialogue
    JDialog boiteMessage = new JDialog (parent, "MESSAGE", true) ;
    boiteMessage.setSize (200,100) ;
    // mise en place des composants : bouton OK, étiquette
    Container contenu = boiteMessage.getContentPane() ;
    contenu.setLayout (new FlowLayout()) ;
    JLabel txt = new JLabel (message) ;
    contenu.add (txt) ;
    JButton ok = new JButton ("OK") ;
    contenu.add (ok) ;
    ok.addActionListener (new EcouteOK(boiteMessage)) ;
    // affichage du dialogue
    boiteMessage.setVisible (true) ;
    // fin sur OK - rien à tester ici
    boiteMessage.dispose() ;
  }
}
class EcouteOK implements ActionListener
{ public EcouteOK (JDialog bd)
  { this.bd = bd ;
  }
  public void actionPerformed (ActionEvent e)
  { bd.setVisible (false) ;
  }
  private JDialog bd ;
}

public class TstMess
{ public static void main (String args[])
  { JFrame fen = new JFrame("Essai afficheMessage") ;
    fen.setSize (400, 300) ;
    fen.setVisible (true) ;
    Util.afficheMessage (fen, "bonjour") ;
    Util.afficheMessage (fen, "et au revoir") ;
  }
}

