import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
public class Compteur extends JApplet  // ne pas oublier public
{ public void init ()
  { valeurCompteur = new JLabel (texte + compteur) ;
    getContentPane().add(valeurCompteur) ;
  }
  public void stop ()
  { compteur++ ;
    valeurCompteur.setText (texte + compteur) ;
  }
  private JLabel valeurCompteur ;
  private int compteur = 0 ;
  private String texte = "Nombre d'arrets = " ;
}
