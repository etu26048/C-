public class CarrImp
{ public static void main (String args[])
  { int car[] ;
    System.out.print ("combien de valeurs : ") ;
    n = Clavier.lireInt() ;
    car = new int[n] ;
    for (int i=0 ; i<n ; i++)
      car[i] = (2*i+1)*(2*i+1) ;
    for (int i=0 ; i<n ; i++)
      System.out.println ((2*i+1) + "a pour carre " + car[i] ;
  }
}
