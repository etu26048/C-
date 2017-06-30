import java.awt.* ;
import java.awt.event.* ;
import javax.swing.* ;
class MaFenetre extends JFrame implements ActionListener
{ private static String texteN = "n = " ;
  private static String texteSomme = "Serie = " ;
  public MaFenetre ()
  { setTitle ("Serie harmonique") ;
    setSize (200, 150) ;
    Container contenu = getContentPane() ;
    pan = new JPanel () ;
    contenu.add(pan) ;
    boutPlus = new JButton ("N++") ;
    boutPlus.addActionListener (this) ;
    contenu.add (boutPlus, "North") ;
    boutMoins = new JButton ("N--") ;
    boutMoins.addActionListener (this) ;
    contenu.add (boutMoins, "South") ;
    n = 0 ;
    somme = 0. ;
    valeurN = new JLabel (texteN + n + "  ") ;
    pan.add (valeurN) ;
    valeurSomme = new JLabel (texteSomme + somme) ;
    pan.add (valeurSomme) ;
  }
  public void actionPerformed (ActionEvent e)
  { Object source = e.getSource() ;
    if (source == boutPlus)         { n++ ;
                                      somme += 1./n ;
                                    }
    if (source == boutMoins && n>0) { somme -= 1./n ;
                                      n-- ;
                                    }
    valeurN.setText (texteN + n + "   ") ;
    valeurSomme.setText (texteSomme + somme) ;
  }
  private JPanel pan ;
  private JButton boutPlus, boutMoins ;
  private JLabel valeurN, valeurSomme ;
  private int n ;
  private double somme ;
}
public class Serie
{ public static void main (String args[])
  { MaFenetre fen = new MaFenetre() ;
    fen.setVisible(true) ;
  }
}

