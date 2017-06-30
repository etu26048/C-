public class Affec2
{ public static void main (String args[])
  { char t1[] = {'b', 'o', 'n', 'j', 'o', 'u', 'r'} ;
    char t2[] = {'h', 'e', 'l', 'l', 'o'} ;
    char t3[] = {'x', 'x', 'x', 'x'} ;
    t3 = t1 ; t1 = t2 ; t2 = t3 ;

    System.out.print ("t1 = ") ;
    for (int i=0 ; i<t1.length ; i++) System.out.print (t1[i]) ;
    System.out.println () ;
    System.out.print ("t2 = ") ;
    for (int i=0 ; i<t2.length ; i++) System.out.print (t2[i]) ;
    System.out.println () ;
    System.out.print ("t3 = ") ;
    for (int i=0 ; i<t3.length ; i++) System.out.print (t3[i]) ;
    System.out.println () ;

  }
}



