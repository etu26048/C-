public class Prio
{ public static void main (String args[])
  { double a=1, b=2, c=3, x=4, y=5, z=6 ;
    int n=2, p=3 ;
    System.out.println ( (a + b) - (2 * c) + " " + (a+b-2*c) ) ;    // expression 1
    System.out.println ( ((2 * x) / (y * z)) + " " + (2*x/(y*z))) ;    // expression 2
    System.out.println ((x + 3) * (n%p) + " " +(x + 3) * (n%p)) ;      // expression 3
    System.out.println ( ((-a) / (-(b + c))) + " " + (-a / -(b + c))) ;
    System.out.println ((x/y)%(-z) + " " +(x/y%-z)  ) ;           // expression 5
    System.out.println ( (x/(y%(-z))) + " " +(x/(y%-z))  ) ;         // expression 6
  }
}

/*
-3.0 -3.0
0.26666666666666666 0.26666666666666666
14.0 14.0
0.2 0.2
0.8 0.8
0.8 0.8
*/
