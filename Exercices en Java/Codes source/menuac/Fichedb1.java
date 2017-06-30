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
    ouvrir = ajoute ("Ouvrir", fichier) ;
    sauvegarder = ajoute ("Sauvegarder", fichier) ;
    fermer = ajoute ("Fermer", fichier) ;
     /* creation menu Edition et ses options */
    edition = new JMenu ("Edition") ;
    barreMenus.add (edition) ;
    copier = ajoute ("Copier", edition) ;
    coller = ajoute ("Coller", edition) ;
  }
  private static JMenuItem ajoute (String libelle, JMenu menu)
  { JMenuItem option = new JMenuItem (libelle) ;
    menu.add (option) ;
    return option ;
  }
  private JMenuBar barreMenus ;
  private JMenu fichier, edition ;
  private JMenuItem ouvrir, sauvegarder, fermer, copier, coller ;
}

public class Fichedb1
{ public static void main (String args[])
  { FenMenu fen = new FenMenu() ;
    fen.setVisible(true) ;
  }
}
