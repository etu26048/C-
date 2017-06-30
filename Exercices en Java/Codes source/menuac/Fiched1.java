import java.awt.*;
import javax.swing.* ;

class FenMenu extends JFrame
{ public FenMenu ()
  { setTitle ("Exemple de menus") ;
    setSize (300, 150) ;
     /* creation barre des menus */
    barreMenus = new JMenuBar() ;
    setJMenuBar(barreMenus) ;
     /* creation menu Fichier et ses options */
    fichier = new JMenu ("Fichier") ;
    barreMenus.add(fichier) ;
    ouvrir = new JMenuItem ("Ouvrir") ;
    fichier.add (ouvrir) ;
    sauvegarder = new JMenuItem ("Sauvegarder") ;
    fichier.add (sauvegarder) ;
    fermer = new JMenuItem ("Fermer") ;
    fichier.add (fermer) ;
     /* creation menu Edition et ses options */
    edition = new JMenu ("Edition") ;
    barreMenus.add (edition) ;
    copier = new JMenuItem ("Copier") ;
    edition.add (copier) ;
    coller = new JMenuItem ("Coller") ;
    edition.add (coller) ;
  }
  private JMenuBar barreMenus ;
  private JMenu fichier, edition ;
  private JMenuItem ouvrir, sauvegarder, fermer, copier, coller ;
}

public class Fiched1
{ public static void main (String args[])
  { FenMenu fen = new FenMenu() ;
    fen.setVisible(true) ;
  }
}
