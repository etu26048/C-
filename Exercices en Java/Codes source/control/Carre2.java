import java.awt.* ;
import java.awt.event.* ;
import javax.swing.* ;
import javax.swing.event.* ;  //  utile pour DocumentListener
class MaFenetre extends JFrame implements DocumentListener
{ public MaFenetre ()
  { setTitle ("Carres") ;
    setSize (400, 100) ;
    Container contenu = getContentPane() ;
    contenu.setLayout (new FlowLayout() ) ;

    labNombre = new JLabel (etiqNombre) ;
    contenu.add(labNombre) ;
    nombre = new JTextField (10) ;
    contenu.add(nombre) ;
    nombre.getDocument().addDocumentListener (this) ;
    labCarre = new JLabel (etiqCarre) ;
    contenu.add(labCarre) ;
  }
  public void insertUpdate (DocumentEvent e)
  { actualise () ;
  }
  public void removeUpdate (DocumentEvent e)
  { actualise () ;
  }
  public void changedUpdate (DocumentEvent e)
  {
  }
  public void actualise()
  { try
    { String texte = nombre.getText() ;
      int n = Integer.parseInt(texte) ;
      long carre = (long)n*(long)n ;
      labCarre.setText (etiqCarre + carre) ;
    }
    catch (NumberFormatException ex)
    { //nombre.setText ("") ;  generait une exception
      labCarre.setText (etiqCarre) ;
    }
  }
  private JLabel labNombre, labCarre ;
  private JTextField nombre ;
  static private String etiqNombre = "Nombre : ", etiqCarre = "Carre : " ;
  private JButton boutonCalcul ;
}
public class Carre2
{ public static void main (String args[])
  { MaFenetre fen = new MaFenetre() ;
    fen.setVisible(true) ;
  }
}


