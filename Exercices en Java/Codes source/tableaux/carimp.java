public class CarrImp
{ public static void main (String args[])
  { int car[] ;
    int n ;
    System.out.print ("combien de valeurs : ") ;
    n = Clavier.lireInt() ;
    car = new int[n] ;
    for (int i=0 ; i<n ; i++)        // ici, for... each pas applicable
      car[i] = (2*i+1)*(2*i+1) ;     
    for (int i=0 ; i<n ; i++)        // ici non plus (on a besoin de i) 
      System.out.println ((2*i+1) + " a pour carre " + car[i]) ;
  }
}
