import java.io.* ;
public class CrFich2
{ public static void main (String args[]) throws IOException
  { String chNom, chPrenom ;
    int annee ;

    String nomFichier ;
    System.out.println ("Nom du fichier a creer : ") ;
    nomFichier = Clavier.lireString() ;
    DataOutputStream sortie = new DataOutputStream
                              (new FileOutputStream (nomFichier)) ;
    int i ;
    int num = 0 ;    // pour compter les differents enregistrements

    while (true)     // on s'arretera sur nom vide
    {   /* lecture infos */
      num++ ;
      System.out.print ("nom " + num + " : ") ;
      chNom = Clavier.lireString() ;
      if (chNom.length() == 0) break ;
      System.out.print ("Prenom : ") ;
      chPrenom = Clavier.lireString() ;
      System.out.print ("annee naissance : ") ;
      annee = Clavier.lireInt() ;
        /* ecriture fichier */
      sortie.writeUTF (chNom) ;
      sortie.writeUTF (chPrenom) ;
      sortie.writeInt(annee) ;
    }

    sortie.close() ;
    System.out.println ("**** fin creation fichier ****") ;
  }
}



