public class LectureEnum
{ public static void main (String args[])
  { String chSuite ;
    System.out.print("Donnez un libelle de l'enumeration Suite : ");
    chSuite = Clavier.lireString () ;
    boolean trouve = false ;
    for (Suite j : Suite.values())
      { if (chSuite.equals(j.toString() ) )
        { trouve = true ;
          int numSuite = j.ordinal() ;
          System.out.println(chSuite  + " correspond a la valeur de rang  "
                                      + (numSuite+1) + " du type Suite" );
        }
      }
    if (!trouve) System.out.println (chSuite 
                         + " n'appartient pas au type Suite") ;   
  }
}
enum Suite {ut, re, mi, fa, sol, la, si }
