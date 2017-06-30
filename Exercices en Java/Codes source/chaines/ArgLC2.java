public class ArgLC2
{ public static void main (String args[])
  {
    int nbArgs = args.length ;
    if (nbArgs != 2) { System.out.println ("nombre arguments incorrect") ;
                       System.exit(-1) ;
                     }

    // on verifie que les caracteres de args[0] et args[1]
    //    sont bien des chiffres
    for (int i=0 ; i<2 ; i++)
comp :  for (int j=0 ; j<args[i].length() ; j++)
        { for (int k=0 ; k<=9 ; k++)
            if (args[i].substring(j,j+1).equals(String.valueOf(k))) break comp ;
          System.out.println ("arguments pas tous numeriques") ;
          System.exit(-1) ;
        }

    int n1 = Integer.parseInt (args[0]) ;
    int n2 = Integer.parseInt (args[1]) ;
    System.out.println (n1 + " + " + n2 + " = " + (n1+n2)) ;
  }
}


