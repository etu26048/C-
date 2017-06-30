import javax.swing.* ;
import java.awt.event.* ;   
class MaFenetre extends JFrame
{ public MaFenetre ()    // constructeur
  { nbFen++ ;
    num = nbFen ;
    setTitle ("Fenetre numero " + num) ;
    setBounds (10, 20, 300, 200) ;
    addMouseListener (ec) ;
  }
  private int num ;
  private static Ecout ec ;
  static   // bloc statique execute avant l'instanciation d'un objet du type
  { ec = new Ecout() ;
  }
  private static int nbFen = 0 ;
 }
class Ecout extends MouseAdapter
{ public void mousePressed (MouseEvent ev)
  { System.out.println ("appui en " + ev.getX() + " " + ev.getY()) ;
  }
  public void mouseReleased (MouseEvent ev)
  { System.out.println ("relachement en " + ev.getX() + " " + ev.getY()) ;
  }
  private int num ;   // numero de la fenetre ecoutee 
}
public class ClicI3
{ public static void main (String args[])
  { final int nFen = 3 ;
    for (int i=0 ; i<nFen ; i++)
    { MaFenetre fen = new MaFenetre() ;
      fen.setVisible(true) ;
    }
  }
}


