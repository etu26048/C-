import java.awt.* ;
import javax.swing.* ;
public class AppEtoib extends JApplet  // ne pas oublier public
{ public void init ()
  { Container contenu = getContentPane() ;
    pan = new Panneau () ;
    contenu.add (pan) ;
  }
  private Panneau pan ;
}
class Panneau extends JPanel
{ private static int xc = 80, yc = 80, rayon =60 ;
  public Panneau ()
  { xd = new int[6] ;
    yd = new int[6] ;
    xf = new int[6] ;
    yf = new int[6] ;
      /* calculs des coordonnes des origines et extremites des 6 segments */
    double angle ;
    int i ;
    for (i=0, angle=Math.PI/6. ; i<6 ; i++, angle+= Math.PI/3)
    { xd[i] = (int) (xc + rayon*Math.cos(angle)) ;
      yd[i] = (int) (yc - rayon*Math.sin(angle)) ;
      xf[i] = (int) (xc + rayon*Math.cos(angle+2*Math.PI/3)) ;
      yf[i] = (int) (yc - rayon*Math.sin(angle+2*Math.PI/3)) ;
    }
  }
  public void paintComponent (Graphics g)
  { super.paintComponent (g) ;
      /* trace du cercle */
    g.drawOval (xc-rayon, yc-rayon, 2*rayon, 2*rayon) ;
      /* trace des 6 segments de l'etoile */
    for (int i=0 ; i<6 ; i++)
      g.drawLine (xd[i], yd[i], xf[i], yf[i]) ;
  }
  private int[] xd, yd, xf, yf ;
}



