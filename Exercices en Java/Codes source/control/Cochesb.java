import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
class MaFenetre extends JFrame implements ActionListener, ItemListener
{ public MaFenetre (String libelles[])
  { setTitle ("Cases a cocher") ;
    setSize (400, 160) ;
    Container contenu = getContentPane () ;
       // les deux boutons
    boutRaz = new JButton ("RAZ") ;
    boutRaz.addActionListener (this) ;
    contenu.add (boutRaz, "North") ;
    boutEtat = new JButton ("Etat") ;
    boutEtat.addActionListener (this) ;
    contenu.add (boutEtat, "South") ;
       // les cases a cocher dans un panneau
    pan = new JPanel () ;
    contenu.add (pan) ;
    this.libelles = libelles ;
    nbCases = libelles.length ;
    cases = new JCheckBox [nbCases] ;
    for (int i=0 ; i<nbCases ; i++)
    { cases[i] = new JCheckBox (libelles[i]) ;
      pan.add (cases[i]) ;
      cases[i].addActionListener (this) ;
      cases[i].addItemListener (this) ;
    }
  }
  public void actionPerformed (ActionEvent e)
  { Object source = e.getSource() ;
    if (source == boutRaz)
      for (int i=0 ; i<nbCases ; i++)
        cases[i].setSelected (false) ;
    if (source == boutEtat)
    { System.out.print ("Cases selectionnees : ") ;
      for (int i=0 ; i<nbCases ; i++)
        if (cases[i].isSelected()) System.out.print (libelles[i]+ " ") ;
      System.out.println() ;
    }
    for (int i=0 ; i<nbCases ; i++)
      if (source == cases[i]) System.out.println ("Action case " + libelles[i]) ;
  }
  public void itemStateChanged (ItemEvent e)
  { Object source = e.getSource() ;
    for (int i=0 ; i<nbCases ; i++)
      if (source == cases[i])  System.out.println ("Item case " + libelles[i]) ;
  }
  private JButton boutRaz, boutEtat ;
  private JPanel pan ;
  private JCheckBox cases[] ;
  private String libelles[] ;
  private int nbCases ;
}

public class Cochesb
{ public static void main (String args[])
  { String libelles[] = {"Cercle", "Rectangle", "Triangle", "Pentagone",
                         "Ellipse", "Carre"} ;
    MaFenetre fen = new MaFenetre(libelles) ;
    fen.setVisible(true) ;
  }
}



