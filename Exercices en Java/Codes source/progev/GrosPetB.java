import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
class FenBoutDyn extends JFrame implements ActionListener
{ public static Dimension dimPetitBouton = new Dimension (70, 30),
                          dimGrosBouton  = new Dimension (110, 50) ;
  public static String etiqCompt = "COMPTE = " ;
  public FenBoutDyn ()
  { setTitle ("Gros et Petits Boutons") ;
    setSize (500, 200) ;
    Container contenu = getContentPane() ;

    grosBouton = new JButton ("GROS BOUTON") ;
    contenu.add (grosBouton, "North") ;
    grosBouton.addActionListener (this) ;

    petitBouton = new JButton ("PETIT BOUTON") ;
    contenu.add (petitBouton, "South") ;
    petitBouton.addActionListener (this) ;

    pan = new JPanel () ;
    contenu.add (pan) ;    // au centre par defaut
  }
  public void actionPerformed (ActionEvent e)
  { Object source = e.getSource() ;
    if (source == grosBouton)
    { JButton bouton = new JButton (etiqCompt) ;
      pan.add (bouton) ;
      bouton.addActionListener (new EcoutGrosBouton (pan, etiqCompt)) ;
      bouton.setPreferredSize (dimGrosBouton) ;
      pan.validate() ;
    }
    if (source == petitBouton)
    { JButton bouton = new JButton ("Petit") ;
      pan.add (bouton) ;
      bouton.addActionListener (new EcoutePetitBouton (pan)) ;
      bouton.setPreferredSize (dimPetitBouton) ;
      pan.validate() ;
    }
  }
  private JButton petitBouton, grosBouton ;
  private JPanel pan ;
}
class EcoutGrosBouton implements ActionListener
{ static int nMaxClics = 5 ;
  public EcoutGrosBouton (JPanel pan, String etiqCompt)
  { nActions = 0 ;
    this.pan = pan ;
    this.etiqCompt = etiqCompt ;
  }
  public void actionPerformed (ActionEvent e)
  { JButton bouton = (JButton)e.getSource() ;
    nActions++ ;
    if (nActions >= nMaxClics)
    { pan.remove (bouton) ;
      pan.validate() ;
    }
    else
    { bouton.setText (etiqCompt+nActions) ;
    }
  }
  private int nActions ;
  private JPanel pan ;
  private String etiqCompt ;
}
class EcoutePetitBouton implements ActionListener
{ public EcoutePetitBouton (JPanel pan)
  { this.pan = pan ;
  }
  public void actionPerformed (ActionEvent e)
  { JButton bouton = (JButton)e.getSource() ;
    pan.remove (bouton) ;
    pan.validate() ;
  }
  private JPanel pan ;
}

public class GrosPetB
{ public static void main (String args[])
  { FenBoutDyn fen = new FenBoutDyn() ;
    fen.setVisible(true) ;
  }
}



/*
 attention dans :
 JButton bouton = (JButton)e.getSource() ;
 si pas sur que tous les composants soient boutons
 tester par instanceOf
    if ((source == grosBouton) && (source instanceof JButton))
*/
