import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
class Util
{ static void afficheMessage (JFrame parent, String message)
  { BoiteMessage boiteMessage = new BoiteMessage (parent, message) ;
    boiteMessage.setVisible (true) ;
    boiteMessage.dispose() ;
  }
}
class BoiteMessage extends JDialog implements ActionListener
{ public BoiteMessage(JFrame parent, String message)
  { super (parent, "MESSAGE", true) ;
    setSize (200,100) ;
    Container contenu = getContentPane() ;
    contenu.setLayout (new FlowLayout()) ;
    JLabel txt = new JLabel (message) ;
    contenu.add (txt) ;
    JButton ok = new JButton ("OK") ;
    contenu.add (ok) ;
    ok.addActionListener (this) ;
  }
  public void actionPerformed (ActionEvent e)
  { setVisible (false) ;
  }
}

public class TstMess2
{ public static void main (String args[])
  { JFrame fen = new JFrame("Essai afficheMessage") ;
    fen.setSize (400, 300) ;
    fen.setVisible (true) ;
    Util.afficheMessage (fen, "bonjour") ;
    Util.afficheMessage (fen, "et au revoir") ;
  }
}

