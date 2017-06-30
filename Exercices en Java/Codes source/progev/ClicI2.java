import javax.swing.* ;
import java.awt.event.* ;
class MaFenetre extends JFrame
{ public MaFenetre ()
  { nbFen++ ;
    num = nbFen ;
    setTitle ("Fenetre numero " + num) ;
    setBounds (10, 20, 300, 200) ;
    addMouseListener (new Ecout(num)) ;  // chaque fenetre a son propre ecouteur
  }
  private static int nbFen = 0 ;
  private int num ;
}
class Ecout extends MouseAdapter
{ public Ecout (int num)
  { this.num = num ;
  }
  public void mousePressed (MouseEvent ev)
  { System.out.println ("appui dans fen num " + num
                         + " en " + ev.getX() + " " + ev.getY()) ;
  }
  public void mouseReleased (MouseEvent ev)
  { System.out.println ("relachement dans fen num " + num
                         + " en " + ev.getX() + " " + ev.getY()) ;
  }
  private int num ;   // numero de la fenetre ecoutee  public void mousePressed (MouseEvent ev)
}
public class ClicI2
{ public static void main (String args[])
  { final int nFen = 3 ;
    for (int i=0 ; i<nFen ; i++)
    { MaFenetre fen = new MaFenetre() ;
      fen.setVisible(true) ;
    }
  }
}

