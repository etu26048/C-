import java.awt.*;
import javax.swing.* ;

class FenMenu extends JFrame
{ public FenMenu ()
  { setTitle ("Exemple de menus") ;
    setSize (300, 120) ;
     /* creation barre des menus */
    barreMenus = new JMenuBar() ;
    setJMenuBar(barreMenus) ;
     /* creation menu Fichier et ses options */
    fichier = new JMenu ("Fichier") ;
    barreMenus.add(fichier) ;
    int nOptionsFichier = nomsOptionsFichier.length ;
    optionsFichier = new JMenuItem [nOptionsFichier] ;
    for (int i=0 ; i<nOptionsFichier ; i++)
    { optionsFichier[i] = new JMenuItem (nomsOptionsFichier[i]) ;
      fichier.add (optionsFichier[i]) ;
    }
     /* creation menu Edition et ses options */
    edition = new JMenu ("Edition") ;
    barreMenus.add (edition) ;
    int nOptionsEdition = nomsOptionsEdition.length ;
    optionsEdition = new JMenuItem [nOptionsEdition] ;
    for (int i=0 ; i<nOptionsEdition ; i++)
    { optionsEdition[i] = new JMenuItem (nomsOptionsEdition[i]) ;
      edition.add (optionsEdition[i]) ;
    }
  }
  private JMenuBar barreMenus ;
  private JMenu fichier, edition ;
  private JMenuItem [] optionsFichier, optionsEdition ;
  private String[] nomsOptionsFichier = {"Ouvrir", "Sauvegarder", "Fermer"} ;
  private String[] nomsOptionsEdition = { "Copier", "Coller"} ;
}

public class Fiched1a
{ public static void main (String args[])
  { FenMenu fen = new FenMenu() ;
    fen.setVisible(true) ;
  }
}

