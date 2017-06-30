import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
class MaFenetre extends JFrame implements ActionListener
{ public static Color[] couleurs = {Color.yellow, Color.red,   Color.blue,
                                    Color.green,  Color.black, Color.cyan } ;
  public MaFenetre ()
  { setTitle ("Ardoise magique") ;
    setSize (400, 180) ;
    Container contenu = getContentPane() ;

    pan = new Panneau () ;
    pan.addMouseListener (pan) ;
    contenu.add(pan) ;

    boutNouv = new JButton ("Nouvelle ligne") ;
    contenu.add(boutNouv, "North") ;
    boutNouv.addActionListener (this) ;

    boutEff = new JButton ("Effacer") ;
    contenu.add(boutEff, "South") ;
    boutEff.addActionListener (this) ;

    boutCoul = new JButton ("") ;
    contenu.add(boutCoul, "West") ;
    boutCoul.addActionListener (this) ;
    boutCoul.setBackground (couleurs[numCoul]) ;
    pan.setCoul (couleurs[numCoul]) ;
  }
  public void actionPerformed (ActionEvent e)
  { if (e.getSource() == boutCoul)
    { numCoul++ ;
      if (numCoul >= couleurs.length) numCoul = 0 ;
      boutCoul.setBackground (couleurs[numCoul]) ;
      pan.setCoul (couleurs[numCoul]) ;
    }
    if (e.getSource() == boutNouv)
    { pan.nouvelleLigne() ;
    }
    if (e.getSource() == boutEff)
    { pan.efface() ;
    }
  }
  private Panneau pan ;
  private JButton boutNouv, boutEff, boutCoul ;
  private int numCoul = 0 ;
}
class Panneau extends JPanel implements MouseListener
{ public void paintComponent (Graphics g)
  { super.paintComponent(g) ;
    enCours = false ;
  }
  public void setCoul(Color couleur)
  { this.couleur = couleur ;
  }
  public void nouvelleLigne()
  { enCours = false ;
  }
  public void efface ()
  { repaint() ;
  }
  public void mouseClicked (MouseEvent e)
  { int xFin = e.getX() ; yFin = e.getY() ;
    if (enCours) { Graphics g = getGraphics() ;
                   g.setColor (couleur) ;
                   g.drawLine (xDeb, yDeb, xFin, yFin) ;
                   g.dispose() ;
                 }
    xDeb = xFin ; yDeb = yFin ;
    enCours = true ;
  }
  public void mousePressed  (MouseEvent e) {}
  public void mouseReleased (MouseEvent e) {}
  public void mouseEntered  (MouseEvent e) {}
  public void mouseExited   (MouseEvent e) {}
  private boolean enCours = false ;
  private int xDeb, yDeb, xFin, yFin ;
  private Color couleur ;
}
public class ArdMag
{ public static void main (String args[])
  { MaFenetre fen = new MaFenetre() ;
    fen.setVisible (true) ;
  }
}


