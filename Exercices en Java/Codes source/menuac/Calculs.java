import java.awt.*;
import java.awt.event.* ;
import javax.swing.* ;
import javax.swing.event.* ;

class FenCalculs extends JFrame implements ActionListener
{ public FenCalculs ()
  { setTitle ("CALCULS sur des rectangles") ;
    setSize (400, 150) ;
     /* creation barre des menus */
    barreMenus = new JMenuBar() ;
    setJMenuBar(barreMenus) ;
     /* creation menu dimensions */
    dimensions = new JMenu ("Dimensions") ;
    barreMenus.add (dimensions) ;
    longueur = ajoute (dimensions, "Nouvelle longueur", this) ;
    largeur = ajoute (dimensions, "Nouvelle largeur", this) ;
    infos = ajoute (dimensions, "Dimensions actuelles", this) ;
    calculs = new JMenu ("Calculs") ;
    barreMenus.add (calculs) ;
    perimetre = ajoute (calculs, "Perimetre", this) ;
    aire = ajoute (calculs, "Aire", this) ;
  }
  public void actionPerformed (ActionEvent e)
  { Object source = e.getSource() ;
    if (source == longueur){ int n = lire ("Donnez la longueur") ;
                             if (n > 0) L = n ;
                           }
    if (source == largeur) { int n = lire ("Donnez la largeur") ;
                             l = n ;
                           }
    if (source == perimetre)
       JOptionPane.showMessageDialog (null, "Perimetre = " + (2*(L+l))) ;
    if (source == aire)
       JOptionPane.showMessageDialog (null, "Aire = " + (L*l)) ;
    if (source == infos)
       JOptionPane.showMessageDialog (null, "Longueur = " + L
                                          + " Largeur = " + l) ;
  }
  private static JMenuItem ajoute (JMenu menu, String libelle,
                                   ActionListener ecouteur)
  { JMenuItem option = new JMenuItem (libelle) ;
    menu.add (option) ;
    option.addActionListener (ecouteur) ;
    return option ;
  }
  private static int lire (String question)
  {   /* ici on demande une valeur jusqu'a ce qu'elle soit correcte */
                    /*  c'est-a-dire entière et positive */
    boolean correct = false ;
    int valeur=0 ;
    do
    { String rep = JOptionPane.showInputDialog (null, question) ;
      if (rep == null) break ;  // on renvoie 0 si fermetur ou Cancel
      try
      { valeur = Integer.parseInt (rep) ;
        if (valeur >0) correct = true ;
      }
      catch (NumberFormatException ex) {}
      if (!correct) JOptionPane.showMessageDialog (null, "Valeur incorrecte ") ;
    }
    while (!correct) ;
    return valeur ;
  }
  private JMenuBar barreMenus ;
  private JMenu dimensions, calculs ;
  private JMenuItem longueur, largeur, perimetre, aire, infos ;
  private int l=0, L=0 ;
}

public class Calculs
{ public static void main (String args[])
  { FenCalculs fen = new FenCalculs() ;
    fen.setVisible(true) ;
  }
}

/*
Un mot sur le polymorphisme d'interface Listener

prevoir gestion valeurs non initialisees = en fait OK avec 0

*/

/* attention a ne pas ecrire
 private static void ajoute (JMenu menu, JMenuItem option, String libelle,
                              ActionListener ecouteur)
  { option = new JMenuItem (libelle) ;
    menu.add (option) ;
    option.addActionListener (ecouteur) ;
  }
*/
