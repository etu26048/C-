import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
class MaFenetre extends JFrame implements ActionListener, ItemListener
{ public MaFenetre ()
  { setTitle ("Geometrie et couleurs") ;
    setSize (400, 160) ;
    Container contenu = getContentPane () ;

    boutEfface = new JButton ("Efface") ;
    contenu.add (boutEfface, "North") ;
       // les boutons radio dans un panneau a gauche
    panRadios = new JPanel () ;
    contenu.add (panRadios, "West") ;
    ButtonGroup groupe = new ButtonGroup() ;
    rouge = ajouteBouton ("Rouge", panRadios, groupe, this) ;
    vert  = ajouteBouton ("Vert",  panRadios, groupe, this) ;
    jaune = ajouteBouton ("Jaune", panRadios, groupe, this) ;
       // les cases a cocher dans un panneau a droite
    panCases = new JPanel () ;
    contenu.add (panCases, "East") ;
    rectangle =  ajouteCase ("Rectangle",  panCases, this) ;
    diagonales = ajouteCase ("Diagonales", panCases, this) ;
    medianes   = ajouteCase ("Medianes",   panCases, this) ;
       // panneau pour le dessin au centre
    panDes = new JPanel () ;
    contenu.add (panDes) ;
  }
  public void actionPerformed (ActionEvent e)
  { Object source = e.getSource() ;
  }
  public void itemStateChanged (ItemEvent e)
  {
  }
  private static JRadioButton ajouteBouton (String libelle, Container contenu,
                                ButtonGroup groupe, ItemListener ecouteur)
  { JRadioButton bouton = new JRadioButton (libelle) ;
    contenu.add (bouton) ;
    groupe.add (bouton) ;
    bouton.addItemListener (ecouteur) ;
    return bouton ;
  }
  private static JCheckBox ajouteCase (String libelle, Container contenu,
                                       ItemListener ecouteur)
  { JCheckBox coche = new JCheckBox (libelle) ;
    contenu.add (coche) ;
    coche.addItemListener (ecouteur) ;
    return coche ;
  }
  private JButton boutEfface ;
  private JPanel panRadios, panCases, panDes ;
  private JRadioButton rouge, vert, jaune ;
  private JCheckBox rectangle, diagonales, medianes ;
}

public class GeoCoul
{ public static void main (String args[])
  { MaFenetre fen = new MaFenetre() ;
    fen.setVisible(true) ;
  }
}


// utilisation de polymorphisme avec interfaces

//item pour etre sur de recuperer modif par programme

// ilmanque beaucoup !!!!depuis plantage
