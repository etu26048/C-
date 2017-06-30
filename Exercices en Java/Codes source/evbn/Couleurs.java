import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
class MaFenetre extends JFrame implements MouseListener
{ public MaFenetre ()
  { setTitle ("Evenements souris") ;
    setSize (300, 150) ;
    contenu = getContentPane() ;
    contenu.setLayout (new FlowLayout()) ;
    contenu.addMouseListener (this) ;
    bouton = new JButton ("A") ;
    contenu.add (bouton) ;
    bouton.addMouseListener (this) ;
    setCouleurs() ;
  }
  public void mousePressed (MouseEvent e) {}
  public void mouseReleased (MouseEvent e) {}
  public void mouseClicked (MouseEvent e) {}
  public void mouseEntered (MouseEvent e)
  { if (e.getSource() == contenu)
      dansFenetre = true ;
    if (e.getSource() == bouton)
      dansBouton = true ;
    setCouleurs () ;
  }
  public void mouseExited (MouseEvent e)
  { if (e.getSource() == contenu)
      dansFenetre = false ;
    if (e.getSource() == bouton)
      dansBouton = false ;
    setCouleurs () ;
  }
  private void setCouleurs()
  { if (dansBouton)
     { bouton.setBackground (Color.red) ;
       contenu.setBackground (Color.blue) ;
       return ;
     }
    if (dansFenetre)
     { contenu.setBackground (Color.yellow) ;
       return ;
     }
    bouton.setBackground (Color.gray) ;
    contenu.setBackground (Color.gray) ;
   }
  private JButton bouton ;
  private Container contenu ;
  private boolean dansFenetre=false, dansBouton=false ;
}
public class Couleurs
{ public static void main (String args[])
  { MaFenetre fen = new MaFenetre() ;
    fen.setVisible (true) ;
  }
}



/*
Créer une fentre dotée d'un bouton.
Quand la souris est dans la fenetre, elle est colorée en jaune
Quand la souris est sur le bouton, il est coloré en rouge et
  la fenetre en bleu
Quand souris n'est pas sur bouton, il est gris, idem pour la fenetre
*/

/*
Analyse
 La souris ne peut pas etre à la fois dans bouton et dans fenetre


 Ici, il est préférable de conserver des variables d'état pour les deux
 composants concernés :
 boolean dansFenetre, dans Bouton ;
 En effet, il faut pouvoir distinguer le cas ou on quitte le bouton
 en quittant la fenetre du cas ou on quitte le bouton sans quitter la fenetre
 (possible si bouton au bord)

 Pour éviter la redondance, on écrit une méthode setCouleurs

 Etat indéterminé au début (on choisit false)
 ca s'arrangera au premier déplacement

 Ici écouteur unique, quid si un écouteur par composant ???
*/


/* remarques :
 setBackground fenetre : contenu (pas trivial)
 si fenetre--> clignote et on retrouve la couleur de fond standard !!!!
  (comment expliquer cela - répercussion bouquin cours)


  d'ailleurs quid de setBackground pour une simple fenetre !!!
  (faux pb dès que panneau)
  si on garde l'exo donner peut-etre la clé !!
*/

/* pb : comment obtenir la couleur par défaut : surement remarque
*/
