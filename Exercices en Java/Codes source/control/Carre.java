import java.awt.* ;
import java.awt.event.* ;
import javax.swing.* ;
class MaFenetre extends JFrame implements ActionListener
{ public MaFenetre ()
  { setTitle ("Carres") ;
    setSize (400, 100) ;
    Container contenu = getContentPane() ;
    contenu.setLayout (new FlowLayout() ) ;

    labNombre = new JLabel (etiqNombre) ;
    contenu.add(labNombre) ;
    nombre = new JTextField (10) ;
    contenu.add(nombre) ;
    boutonCalcul = new JButton ("CALCUL") ;
    contenu.add(boutonCalcul) ;
    boutonCalcul.addActionListener(this) ;
    labCarre = new JLabel (etiqCarre) ;
    contenu.add(labCarre) ;
  }
  public void actionPerformed (ActionEvent e)
  { if (e.getSource() == boutonCalcul)
    try
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
public class Carre
{ public static void main (String args[])
  { MaFenetre fen = new MaFenetre() ;
    fen.setVisible(true) ;
  }
}

