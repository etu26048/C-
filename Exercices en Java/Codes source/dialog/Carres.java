import javax.swing.* ;
public class Carres
{ public static void main(String[] args)
  { int n = 1 ;
    int rep ;
    do
    { JOptionPane.showMessageDialog (null, n + " a pour carre " + n*n,
                                    "CARRES", JOptionPane.INFORMATION_MESSAGE) ;
      n+=2 ;
      rep = JOptionPane.showConfirmDialog (null, "impair suivant ?",
                                          "CARRES", JOptionPane.YES_NO_OPTION) ;
    }
    while (rep == JOptionPane.YES_OPTION) ;
  }
}





