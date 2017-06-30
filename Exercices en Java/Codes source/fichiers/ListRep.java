import java.io.* ;     // pour la classe File
public class ListRep
{ public static void main (String args[])
  { String nomRepert ;
    File objRep ;
    boolean ok ;
      /* lecture nom de repertoire */
    ok = false ;
    do
    { System.out.print ("nom du repertoire : ") ;
      nomRepert = Clavier.lireString () ;
      objRep = new File (nomRepert) ;
      if (objRep.isDirectory())
        ok = true ;
      else
        System.out.println ("Nom incorrect (inexistant ou non repertoire)") ;
    }
    while (!ok) ;

      /* affichage des informations correspondantes */
    File [] membres = objRep.listFiles() ;
    for (int i=0 ; i<membres.length ; i++)
    { String type ;
      System.out.print (membres[i].getName()+ " ") ;
      if (membres[i].isFile())
        System.out.println ("FICHIER    " + membres[i].length() + " octets") ;
      else
        System.out.println ("REPERTOIRE ") ;
    }
  }
}


