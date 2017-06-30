import javax.swing.* ;      // pour JFrame
import java.awt.event.* ;   // pour MouseEvent et MouseListener
class MaFenetre extends JFrame 
{ public MaFenetre ()    // constructeur
  { setTitle ("Gestion de clics") ;
    setBounds (10, 20, 300, 200) ;
    addMouseListener (new Ecout()) ;  // on ecoute avec un objet de type Ecout
  }
}
class Ecout implements MouseListener
{ public void mousePressed (MouseEvent ev)
  { System.out.println ("appui en " + ev.getX() + " " + ev.getY()) ;
  }
  public void mouseReleased(MouseEvent ev)
  { System.out.println ("relachement en " + ev.getX() + " " + ev.getY()) ;
  }
  public void mouseClicked(MouseEvent ev)  {}
  public void mouseEntered (MouseEvent ev) {}
  public void mouseExited  (MouseEvent ev) {}
}
public class Clic2
{ public static void main (String args[])
  { MaFenetre fen = new MaFenetre() ;
    fen.setVisible(true) ;
  }
}


