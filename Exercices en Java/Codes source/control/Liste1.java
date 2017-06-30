import java.awt.* ;
import java.awt.event.* ;
import javax.swing.* ;
import javax.swing.event.* ;   // pour ListSelectionlistener
class MaFenetre extends JFrame implements ListSelectionListener
{ public MaFenetre (String noms[])
  { setTitle ("Liste") ;
    setSize (300, 220) ;
    Container contenu = getContentPane() ;
    liste = new JList (noms) ;
    contenu.add (liste, "West") ;
    liste.addListSelectionListener (this) ;
    pan = new JPanel () ;
    contenu.add (pan) ;
  }
  public void valueChanged (ListSelectionEvent e)
  { if ((e.getSource() == liste) && (!e.getValueIsAdjusting()))
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
public class Liste1
{ public static void main (String args[])
  { String [] nomsLangages = {"Java", "C", "C++", "Pascal", "Basic", "Cobol",
                              "Fortran"} ;
    MaFenetre fen = new MaFenetre(nomsLangages) ;
    fen.setVisible(true) ;
  }
}

