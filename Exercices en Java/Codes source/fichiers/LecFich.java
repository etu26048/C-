import java.io.* ;
public class LecFich
{ public static void main (String args[]) throws IOException
  { final int longMaxNom = 20 ;
    final int longMaxPrenom = 20 ;
    String chNom, chPrenom ;
    char[] nom = new char [longMaxNom] ;
    char[] prenom = new char [longMaxPrenom] ;
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
        for (i=0 ; i<longMaxNom ;    i++) nom[i] =    entree.readChar () ;
        for (i=0 ; i<longMaxPrenom ; i++) prenom[i] = entree.readChar () ;
        annee = entree.readInt () ;
          /* affichage infos */
        for (i=0 ; i<longMaxNom ;    i++) System.out.print (nom[i]) ;
        System.out.print (" ") ;
        for (i=0 ; i<longMaxPrenom ; i++) System.out.print (prenom[i]) ;
        System.out.print (" ") ;
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




