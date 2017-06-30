import java.awt.* ;
import javax.swing.* ;
public class AppCourb extends JApplet  // ne pas oublier public
{ public void init ()
  {  /* les deux composants de l'applet : champ texte et panneau */
    Container contenu = getContentPane () ;
    JLabel champTitre = new JLabel (getParameter ("TITRE")) ;
    contenu.add (champTitre, "North") ;   // titre en heut
    pan = new Panneau (this) ;
    contenu.add (pan) ;                   // panneau pour la courbe au centre
     /* recuperation des parametres HTML : nombre de valeurs et valeurs */
    nValeurs = Integer.parseInt (getParameter ("NB_VALEURS")) ;
    if (nValeurs <= 1) System.exit (-1) ;  // au moins 2 valeurs pour faire une courbe
    valeurs = new int [nValeurs] ;
    for (int i=0 ; i<nValeurs ; i++)
      valeurs[i] = Integer.parseInt(getParameter ("VALEUR"+(i+1))) ;
  }
  public int[] getValeurs ()
  { return valeurs ;
  }
  private Panneau pan ;
  private int nValeurs ;
  private int valeurs[] ;
  }
class Panneau extends JPanel
{ public Panneau (AppCourb ap)
  { this.ap = ap ;
  }
  public void paintComponent (Graphics g)
  { super.paintComponent (g) ;
     /* determination de la dimension du panneau */
    Dimension dimPanneau = getSize () ;
    int hauteur = dimPanneau.height ;
    int largeur = dimPanneau.width ;
     /* recuperation des valeurs */
    int[] valeurs = ap.getValeurs() ;
    int nValeurs = valeurs.length ;
     /* recherche de la valeur maximale */
    int valMax = valeurs [0] ;
    for (int i=1 ; i<nValeurs ; i++)
      if (valeurs[i] > valMax) valMax = valeurs [i] ;
     /* trace de la courbe point par point */
    double ecart = (double)largeur/(nValeurs-1) ;  // on a nValeurs >1
    double echelle = (double)hauteur/valMax ;
    double xDeb = 0, yDeb = hauteur - valeurs[0] * echelle ;
    double xFin, yFin ;
    for (int i=1 ; i<nValeurs ; i++)
    { xFin = xDeb + ecart ;
      yFin = hauteur -  valeurs[i] * echelle ;
      g.drawLine ((int)xDeb, (int)yDeb, (int)xFin, (int)yFin) ;
      xDeb = xFin ;
      yDeb = yFin ;
    }
  }
  AppCourb ap ;
}


/*
les abscisses so nt calculees en double pour plus de précision
on calcule dan panneau --> adaptation avec visualisat
si erreur exception
*/
