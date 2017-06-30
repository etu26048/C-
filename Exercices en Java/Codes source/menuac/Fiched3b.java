import java.awt.*;
import java.awt.event.* ;
import javax.swing.* ;
import javax.swing.event.* ;
class FenMenu extends JFrame implements ActionListener, MenuListener
{ public FenMenu ()
  { setTitle ("Exemple de menus") ;
    setSize (300, 130) ;
     /* creation barre des menus */
    barreMenus = new JMenuBar() ;
    setJMenuBar(barreMenus) ;
     /* creation menu Fichier et ses options */
    fichier = new JMenu ("Fichier") ;
    barreMenus.add(fichier) ;
    fichier.addMenuListener (this) ;
    ouvrir = new JMenuItem ("Ouvrir") ;
    fichier.add (ouvrir) ;
    ouvrir.addActionListener (this) ;
    sauvegarder = new JMenuItem ("Sauvegarder") ;
    fichier.add (sauvegarder) ;
    sauvegarder.addActionListener (this) ;
    fermer = new JMenuItem ("Fermer") ;
    fichier.add (fermer) ;
    fermer.addActionListener (this) ;
     /* creation menu Edition et ses options */
    edition = new JMenu ("Edition") ;
    barreMenus.add (edition) ;
    edition.addMenuListener(this) ;
    copier = new JMenuItem ("Copier") ;
    edition.add (copier) ;
    copier.addActionListener (this) ;
    coller = new JMenuItem ("Coller") ;
    edition.add (coller) ;
    coller.addActionListener (this) ;
     /* etat initial : pas de fichier ouvert, pas d'info copiee */
    fichierOuvert = false ; infoCopiee = false ;
    nomFichier = null ;
  }
  public void actionPerformed (ActionEvent e)
  { Object source = e.getSource() ;
    if (source == ouvrir)
    { String nom = JOptionPane.showInputDialog (this, "nom fichier a ouvrir") ;
      if ((nom == null) || (nom.equals(""))) return ;
      if (fichierOuvert) System.out.println ("On ferme " + nomFichier) ;
      nomFichier = nom ; fichierOuvert = true ;
      System.out.println ("On ouvre " + nomFichier) ;
    }
    if (source == fermer)
    { System.out.println ("On ferme " + nomFichier) ;
      fichierOuvert = false ;
    }
    if (source == sauvegarder)
    { System.out.println ("on sauvegarde " + nomFichier) ;
    }
    if (source == copier)
    { System.out.println ("copie d'information") ;
      infoCopiee = true ;
    }
    if (source == coller)
    { System.out.println ("collage d'information") ;
      infoCopiee = false ;
    }
  }
  public void menuSelected (MenuEvent e)
  {  /* activation - desactivation des options */
    copier.setEnabled (true) ;
    coller.setEnabled (infoCopiee) ;

    ouvrir.setEnabled (true) ;
    sauvegarder.setEnabled (fichierOuvert) ;
    fermer.setEnabled (fichierOuvert) ;
  }
  public void menuDeselected (MenuEvent e) {}
  public void menuCanceled (MenuEvent e)   {}

  private JMenuBar barreMenus ;
  private JMenu fichier, edition ;
  private JMenuItem ouvrir, sauvegarder, fermer, copier, coller ;
  private boolean fichierOuvert, infoCopiee ;
  private String nomFichier ;
}

public class Fiched3b
{ public static void main (String args[])
  { FenMenu fen = new FenMenu() ;
    fen.setVisible(true) ;
  }
}



