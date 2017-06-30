import java.awt.* ;
import java.awt.event.* ;
import javax.swing.* ;
class MaFenetre extends JFrame implements ActionListener, FocusListener
{ public MaFenetre ()
  { setTitle ("Carres") ;
    setSize (400, 100) ;
    Container contenu = getContentPane() ;
    contenu.setLayout (new FlowLayout() ) ;

    labNombre = new JLabel (etiqNombre) ;
    contenu.add(labNombre) ;
    nombre = new JTextField (10) ;
    contenu.add(nombre) ;
    nombre.addFocusListener (this) ;    // pour la perte de focus
    nombre.addActionListener (this) ;   // pour la validation
    labCarre = new JLabel (etiqCarre) ;
    contenu.add(labCarre) ;
  }
  public void actionPerformed (ActionEvent e)
  { actualise () ;
  }
  public void focusLost (FocusEvent e)
  { actualise () ;
  }
  public void focusGained (FocusEvent e)
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
    { nombre.setText ("") ;
      labCarre.setText (etiqCarre) ;
    }
  }
  private JLabel labNombre, labCarre ;
  private JTextField nombre ;
  static private String etiqNombre = "Nombre : ", etiqCarre = "Carre : " ;
  private JButton boutonCalcul ;
}
public class Carre1
{ public static void main (String args[])
  { MaFenetre fen = new MaFenetre() ;
    fen.setVisible(true) ;
  }
}

