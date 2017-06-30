import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
class MaFenetre extends JFrame implements ActionListener, ItemListener
{ public MaFenetre ()
  { setTitle ("Cases a cocher") ;
    setSize (300, 140) ;
    Container contenu = getContentPane () ;
       // les deux boutons
    boutRaz = new JButton ("RAZ") ;
    boutRaz.addActionListener (this) ;
    contenu.add (boutRaz, "North") ;
    boutEtat = new JButton ("Etat") ;
    boutEtat.addActionListener (this) ;
    contenu.add (boutEtat, "South") ;
       // les cases a cocher dans un panneau
    pan = new JPanel () ;
    contenu.add (pan) ;
    cercle = new JCheckBox ("Cercle") ;
    pan.add (cercle) ;
    cercle.addActionListener (this) ;
    cercle.addItemListener (this) ;
    rectangle = new JCheckBox ("Rectangle") ;
    pan.add (rectangle) ;
    rectangle.addActionListener (this) ;
    rectangle.addItemListener (this) ;
    triangle = new JCheckBox ("Triangle") ;
    pan.add (triangle) ;
    triangle.addActionListener (this) ;
    triangle.addItemListener (this) ;
  }
  public void actionPerformed (ActionEvent e)
  { Object source = e.getSource() ;
    if (source == boutRaz)
    { cercle.setSelected (false) ;
      rectangle.setSelected (false) ;
      triangle.setSelected (false) ;
    }
    if (source == boutEtat)
    { System.out.print ("Cases selectionnees : ") ;
      if (cercle.isSelected())    System.out.print (" cercle ") ;
      if (rectangle.isSelected()) System.out.print (" rectangle ") ;
      if (triangle.isSelected())  System.out.print (" triangle ") ;
      System.out.println() ;
    }
    if (source == cercle)    System.out.println ("Action case cercle") ;
    if (source == rectangle) System.out.println ("Action case rectangle") ;
    if (source == triangle)  System.out.println ("Action case triangle") ;
  }
  public void itemStateChanged (ItemEvent e)
  { Object source = e.getSource() ;
    if (source == cercle)    System.out.println ("Item case cercle") ;
    if (source == rectangle) System.out.println ("Item case rectangle") ;
    if (source == triangle)  System.out.println ("Item case triangle") ;
  }
  private JButton boutRaz, boutEtat ;
  private JPanel pan ;
  private JCheckBox cercle, rectangle, triangle ;
}

public class Coches
{ public static void main (String args[])
  { MaFenetre fen = new MaFenetre() ;
    fen.setVisible(true) ;
  }
}



