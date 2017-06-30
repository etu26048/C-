import java.io.* ;
public class LecFich2
{ public static void main (String args[]) throws IOException
  { final int longMaxNom = 20 ;
    final int longMaxPrenom = 20 ;
    String chNom, chPrenom ;
    int annee ;
    int i ;

    String nomFichier ;
    System.out.println ("Nom du fichier a lister : ") ;
    nomFichier = Clavier.lireString() ;
    DataInputStream entree = new DataInputStream
                             (new FileInputStream (nomFichier)) ;
    System.out.println ("**** Liste du fichier ****") ;
    boolean eof = false ; // sera mis a true par gestionnaire exception EOFile
    while (!eof)
    { try
      {   /* lecture infos */
        chNom =    entree.readUTF () ;
        chPrenom = entree.readUTF () ;
        annee = entree.readInt () ;
          /* affichage infos */
        System.out.print (chNom + " ") ;
        System.out.print (chPrenom + " ") ;
        System.out.println (annee) ;
      }
      catch (EOFException e)
      { eof = true ;
      }
    }
    entree.close() ;
    System.out.println ("**** fin liste fichier ****") ;
  }
}





