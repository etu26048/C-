import javax.swing.* ;      // pour JFrame
import java.awt.event.* ;   // pour MouseEvent et MouseListener
class MaFenetre extends JFrame implements MouseListener
{ public MaFenetre ()
  { nbFen++ ;
    num = nbFen ;
    setTitle ("Fenetre numero " + num) ;
    setBounds (10, 20, 300, 200) ;
    addMouseListener (this) ;
  }
  public void mousePressed (MouseEvent ev)
  { System.out.println ("appui dans fen num " + num
                         + " en " + ev.getX() + " " + ev.getY()) ;
  }
  public void mouseReleased(MouseEvent ev)
  { System.out.println ("relachement dans fen num " + num
                         + " en " + ev.getX() + " " + ev.getY()) ;
  }
  public void mouseClicked(MouseEvent ev)  {}
  public void mouseEntered (MouseEvent ev) {}
  public void mouseExited  (MouseEvent ev) {}
  private static int nbFen=0 ;
  private int num ;
}
public class ClicI1
{ public static void main (String args[])
  { final int nFen = 3 ;
    for (int i=0 ; i<nFen ; i++)
    { MaFenetre fen = new MaFenetre() ;
      fen.setVisible(true) ;
    }
  }
}

/*
appui dans fen num 1 en 121 82
relachement dans fen num 1 en 121 82
appui dans fen num 1 en 168 91
relachement dans fen num 1 en 456 155
appui dans fen num 2 en 228 137
relachement dans fen num 2 en 228 137
appui dans fen num 3 en 152 169
relachement dans fen num 3 en 152 169
appui dans fen num 3 en 112 121
relachement dans fen num 3 en -23 41
appui dans fen num 2 en 89 119
relachement dans fen num 2 en 89 119
appui dans fen num 1 en 125 107
relachement dans fen num 1 en 125 107
appui dans fen num 2 en 194 148
relachement dans fen num 2 en 194 148
*/
