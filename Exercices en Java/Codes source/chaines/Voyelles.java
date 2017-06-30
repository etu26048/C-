public class Voyelles
{ public static void main (String args[])
  { char voy[] = {'a', 'e', 'i', 'o', 'u', 'y'} ;
    int nVoy [] = new int [voy.length] ;
    for (int i=0 ; i<nVoy.length ; i++) nVoy[i] = 0 ;
    System.out.print ("donnez un mot : ") ;
    String mot = Clavier.lireString() ;
    mot = mot.toLowerCase() ;
    for (int i=0 ; i<mot.length() ; i++)
      for (int j=0 ; j<voy.length ; j++)
        if (mot.charAt(i) == voy[j]) nVoy[j]++ ;
    System.out.println ("il comporte : ") ;
    for (int i=0 ; i<voy.length ; i++)
    	System.out.println(nVoy[i] + " fois la lettre " + voy[i]) ;
  }
}
