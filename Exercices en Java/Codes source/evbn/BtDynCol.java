import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
class MaFenetre extends JFrame implements MouseListener, ActionListener
{ static final Color couleurs[] = {Color.red, Color.yellow, Color.green, Color.blue} ;
  public MaFenetre ()
  { setTitle ("Evenements souris") ;
    setSize (300, 150) ;
    contenu = getContentPane() ;
    contenu.setLayout (new FlowLayout()) ;
    boutonCreation = new JButton ("CREATION_BOUTONS") ;
    contenu.add (boutonCreation) ;
    boutonCreation.addActionListener (this) ;
  }
  public void actionPerformed (ActionEvent e)
  { if (e.getSource() == boutonCreation)
     { numBouton++ ;
       JButton b = new JButton ("B"+numBouton) ;
       contenu.add (b) ;
       b.addMouseListener (this) ;
     }
  }
  public void mousePressed (MouseEvent e)  {}
  public void mouseReleased (MouseEvent e) {}
  public void mouseClicked (MouseEvent e)  {}
  public void mouseEntered (MouseEvent e)
  { Object source = e.getSource () ;
    JButton bSource ;
    if (source instanceof JButton)
    { bSource = (JButton)source ;
      String ch = bSource.getActionCommand() ;
      if (ch.charAt(0) == 'B')
        { int n = Integer.parseInt (ch.substring(1)) ;
          int numCoul = n % couleurs.length ;
          bSource.setBackground (couleurs[numCoul]) ;
        }
    }
  }
  public void mouseExited (MouseEvent e)
  { Object source = e.getSource () ;
    JButton bSource ;
    if (source instanceof JButton)
    { bSource = (JButton)source ;
      String ch = bSource.getActionCommand() ;
      if (ch.charAt(0) == 'B')
        bSource.setBackground (Color.white) ;
    }
  }
  private Container contenu ;
  private JButton boutonCreation ;
  private int numBouton = 0 ;
}
public class BtDynCol
{ public static void main (String args[])
  { MaFenetre fen = new MaFenetre() ;
    fen.setVisible (true) ;
  }
}


