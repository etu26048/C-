public class TrisMots
{ public static void main (String args[])
  { // lecture des donnees
    System.out.print ("Combien de mots ? ") ;
    int nMots = Clavier.lireInt() ;
    String [] mots = new String[nMots] ;
    System.out.println ("donnez vos mots") ;
    for (int i=0 ; i<nMots ; i++)
      mots[i] = Clavier.lireString() ;

    // conversion de chaque mot en minuscules
    String [] motsMin = new String[nMots] ;
    for (int i=0 ; i<nMots ; i++)
      motsMin[i] = mots[i].toLowerCase() ;

    //  tri par reorganisation des references (mots d'origine et en minuscules)
    // (on compare chaque mot (minuscule a tous ses suivants)
    String temp ;
    for (int i=0 ; i<nMots-1 ; i++)
      for (int j=i+1 ; j<nMots ; j++)
        if (motsMin[i].compareTo(motsMin[j]) >= 0)
          { temp = motsMin[i] ; motsMin[i] = motsMin[j] ; motsMin[j] = temp ;
            temp = mots[i] ;    mots[i] = mots[j] ;       mots[j] = temp ;
          }

    // affichage des chaines triees
    System.out.println ("Liste par ordre alphabetique :") ;
    for (int i=0 ; i<nMots ; i++)
      System.out.println (mots[i]) ;
  }
}

/* nb mots lus en données
On utilise méthode simple de tri (bulle)
On a interet a trier les références
On aurait pu garder un index ????
*/

/*
Combien de mots ? 5
donnez vos mots
javaScript
Pascal
BaSiC
Java
ADA
Liste par ordre alphabetique :
ADA
BaSiC
Java
javaScript
Pascal
*/
