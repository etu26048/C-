import java.awt.* ;
import javax.swing.* ;
public class AppEtoil extends JApplet  // ne pas oublier public
{ public void init ()
  { Container contenu = getContentPane() ;
    pan = new Panneau () ;
    contenu.add (pan) ;
  }
  private Panneau pan ;
}
class Panneau extends JPanel
{ private static int xc = 50, yc = 50, rayon = 40 ;

  public void paintComponent (Graphics g)
  { super.paintComponent (g) ;
      /* trace du cercle */
    g.drawOval (xc-rayon, yc-rayon, xc+rayon, yc+rayon) ;
      /* trace des 6 segments de l'etoile */
    double angle, xd, xf, yd, yf ;
    int i ;
    { for (i=0, angle=Math.PI/6. ; i<6 ; i++, angle+= Math.PI/3)
      { xd = xc + rayon*Math.cos(angle) ;
        yd = yc - rayon*Math.sin(angle) ;
        xf = xc + rayon*Math.cos(angle+2*Math.PI/3) ;
        yf = yc - rayon*Math.sin(angle+2*Math.PI/3) ;
        g.drawLine ((int)xd, (int)yd, (int)xf, (int)yf) ;
      }
    }
  }
}



