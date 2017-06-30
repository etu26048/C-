import java.awt.* ;
import java.awt.event.* ;
import javax.swing.* ;
class MaFenetre extends JFrame implements ActionListener
{ public MaFenetre (String noms[])
  { setTitle ("Liste") ;
    setSize (300, 220) ;
    Container contenu = getContentPane() ;
    liste = new JList (noms) ;
    contenu.add (liste, "West") ;
    ok = new JButton ("OK") ;
    contenu.add (ok, "South") ;
    ok.addActionListener (this) ;
    pan = new JPanel () ;
    contenu.add (pan) ;
  }
  public void actionPerformed (ActionEvent e)
  { if (e.getSource() == ok)
    { pan.removeAll () ;  // supprime tous les composants de pan
      Object noms[] = liste.getSelectedValues() ;
      for (int i=0 ; i<noms.length ; i++)
      { JButton bouton = new JButton ((String)noms[i]) ;
        pan.add (bouton) ;
      }
      pan.validate() ;
    }
  }
  private JList liste ;
  private JButton ok ;
  private JPanel pan ;
}
public class Liste
{ public static void main (String args[])
  { String [] nomsLangages = {"Java", "C", "C++", "Pascal", "Basic", "Cobol",
                              "Fortran"} ;
    MaFenetre fen = new MaFenetre(nomsLangages) ;
    fen.setVisible(true) ;
  }
}

