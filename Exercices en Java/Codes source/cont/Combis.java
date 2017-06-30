public class Combis
{ public static void main (String[] args)
  { int nbf ;        /* compteur du nombre de façons de faire 1 F */
    int n10 ;        /* nombre de pièces de 10 centimes */
    int n5 ;         /* nombre de pièces de 5 centimes */
    int n2 ;         /* nombre de pièces de 2 centimes */

    nbf = 0 ;
    for (n10=0 ; n10<=10 ; n10++)
      for (n5=0 ; n5<=20 ; n5++)
      for (n2=0 ; n2<=50 ; n2++)
      if ( 2*n2 + 5*n5 + 10*n10 == 100)
         { nbf ++ ;
           System.out.print ("1 F = ") ;
           if (n2 != 0)    System.out.print (n2 + " X 2c") ;
           if (n5 != 0)  { if (n2 != 0) System.out.print (" + ") ;
                           System.out.print (n5 + " X 5c")  ;
                         }
           if (n10 != 0) { if ((n2 != 0) || (n5 != 0)) System.out.print (" + ") ;
                           System.out.print (n10 + " X 10c") ;
                         }
           System.out.println () ;
         }
    System.out.println ("En tout, il y a " + nbf + " facons de faire 1 F") ;
}

