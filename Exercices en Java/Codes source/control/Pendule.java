import java.awt.* ;
import java.awt.event.* ;
import javax.swing.* ;
class MaFenetre extends JFrame implements ActionListener
{ public MaFenetre ()
  { setTitle ("PENDULE") ;
    setSize (400, 250) ;
    Container contenu = getContentPane() ;

    panControles = new JPanel() ;
    contenu.add (panControles, "North") ;
    saisieHeures = new JTextField (4) ;
    panControles.add (saisieHeures) ;
    etiqHeures = new JLabel (" Heures") ;
    panControles.add (etiqHeures) ;
    saisieMinutes = new JTextField (4) ;
    panControles.add (saisieMinutes) ;
    etiqMinutes = new JLabel (" Minutes") ;
    panControles.add (etiqMinutes) ;
    ok = new JButton ("Mise a l'heure") ;
    panControles.add (ok) ;
    ok.addActionListener (this) ;

    panPendule = new PanPendule(this) ;
    contenu.add (panPendule) ;
    panPendule.setBackground (Color.yellow) ;
  }
  public int getMinutes ()
  { return minutes ;
  }
  public int getHeures ()
  { return heures ;
  }
  public void actionPerformed (ActionEvent e)
  { int h, m ;   // pour les valeurs saisies
    if (e.getSource() == ok)
    { try
      { String chHeures = saisieHeures.getText() ;
        h = Integer.parseInt (chHeures) ;
      }
      catch (NumberFormatException ex)
      { h = -1 ;  // on force une valeur invalide
        saisieHeures.setText ("") ;
      }
      try
      { String chMinutes = saisieMinutes.getText() ;
        m = Integer.parseInt (chMinutes) ;
      }
      catch (NumberFormatException ex)
      { m = -1 ;  // on force une valeur invalide
        saisieMinutes.setText ("") ;
      }
        // si les valeurs obtenues sont valides, on les place dans
        // les champs heures et minutes et on force le dessin
        // sinon, on replace les anciennes valeurs dans les champs texte
      if ((h>=0) && (h<24) && (m>=0) && (m<60))
        { heures = h ; minutes = m ;
          repaint() ;
        }
       else
        { saisieMinutes.setText (""+minutes) ;
          saisieHeures.setText (""+heures) ;
        }
    }
  }
  private JPanel panControles ;
  private PanPendule panPendule ;
  private JTextField saisieHeures, saisieMinutes ;
  private JLabel etiqHeures , etiqMinutes ;
  private JButton ok ;
  private int minutes=0, heures=0 ;
}
class PanPendule extends JPanel
{ public PanPendule (MaFenetre fen)
  { this.fen = fen ;
  }
  public void paintComponent (Graphics g)
  { super.paintComponent(g) ;
     // dessin du cercle
    Dimension dim = getSize() ;
    int largeur = dim.width, hauteur = dim.height ;
    boolean panTropLarge = (largeur>hauteur) ;
    int xCentre = largeur/2, yCentre = hauteur/2 ;
    int rayon ;
    if (panTropLarge) rayon = hauteur/2 - 2 ; else rayon = largeur/2 - 2 ;
    g.drawOval (xCentre-rayon, yCentre-rayon, 2*rayon, 2*rayon) ;
     // dessin grande aiguille
    int minutes = fen.getMinutes() ;
    double angle = Math.PI/2 * (1. - minutes/15.) ;
    g.drawLine (xCentre, yCentre,
                (int)(xCentre+rayon*Math.cos(angle)),
                (int)(yCentre-rayon*Math.sin(angle))) ;
     // dessin petite aiguille
    int heures = fen.getHeures() ;
    angle = Math.PI/2 * (1. - heures/3. - minutes/180.) ;
    g.drawLine (xCentre, yCentre,
                (int)(xCentre+rayon/2.*Math.cos(angle)),
                (int)(yCentre-rayon/2.*Math.sin(angle))) ;
  }
  private MaFenetre fen ;
}
public class Pendule
{ public static void main (String args[])
  { MaFenetre fen = new MaFenetre() ;
    fen.setVisible(true) ;
  }
}


