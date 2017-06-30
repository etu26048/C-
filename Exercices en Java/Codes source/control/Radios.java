import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
class MaFenetre extends JFrame implements ActionListener
{ public MaFenetre (String[] libelles)
  { setTitle ("Boutons radio") ;
    setSize (400, 160) ;
    Container contenu = getContentPane () ;

    boutEtat = new JButton ("Etat") ;
    boutEtat.addActionListener (this) ;
    contenu.add (boutEtat, "South") ;
       // les boutons radio dans un panneau
    pan = new JPanel () ;
    contenu.add (pan) ;
    this.libelles = libelles ;
    nbBoutons = libelles.length ;
    ButtonGroup groupe = new ButtonGroup() ;
    boutons = new JRadioButton [nbBoutons] ;
    for (int i=0 ; i<nbBoutons ; i++)
    { boutons[i] = new JRadioButton (libelles[i]) ;
      pan.add (boutons[i]) ;
      groupe.add (boutons[i]) ;
      boutons[i].addActionListener (this) ;
    }
    if (nbBoutons > 0) boutons[0].setSelected(true) ;
  }
  public void actionPerformed (ActionEvent e)
  { Object source = e.getSource() ;
    if (source == boutEtat)
    { System.out.print ("Bouton selectionne = ") ;
      for (int i=0 ; i<nbBoutons ; i++)
        if (boutons[i].isSelected()) System.out.print (libelles[i]+ " ") ;
      System.out.println() ;
    }
    for (int i=0 ; i<nbBoutons ; i++)
      if (source == boutons[i]) System.out.println ("Action bouton " + libelles[i]) ;
  }
  private JButton boutDef, boutEtat ;
  private JPanel pan ;
  private JRadioButton boutons[] ;
  private String libelles[] ;
  private int nbBoutons ;
}

public class Radios
{ public static void main (String args[])
  { String libelles[] = {"Cercle", "Rectangle", "Triangle", "Pentagone",
                         "Ellipse", "Carre"} ;
    MaFenetre fen = new MaFenetre(libelles) ;
    fen.setVisible(true) ;
  }
}



