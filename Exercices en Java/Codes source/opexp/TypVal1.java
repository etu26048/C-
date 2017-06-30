public class TypVal1
{ public static void main (String args[])
  { byte b1 = 10, b2 = 20 ;
    short p = 200 ;
    int n = 500 ;
    long q = 100 ;
    float x = 2.5f ;
    double y = 5.25 ;

    System.out.println ("b1+b2 = " + (b1+b2)) ;
    System.out.println ("p+b1 = " + (p+b1)) ;
    System.out.println ("b1*b2 = " + (b1*b2)) ;
    System.out.println ("q+p*(b1+b2) = " +(q+p*(b1+b2)) ) ;
    System.out.println ("x+q*n =" + (x+q*n)) ;
    System.out.println ("b1*q/x=" + (b1*q/x)) ;
    System.out.println ("b1*q*2./x=" + (b1*q*2./x) ) ;
    System.out.println ("b1*q*2.f/x=" + (b1*q*2.f/x) ) ;
  }
}

/*
b1+b2 = 30
p+b1 = 210
b1*b2 = 200
q+p*(b1+b2) = 6100
x+q*n =50002.5
b1*q/x=400.0
b1*q*2./x=800.0
b1*q*2.f/x=800.0
*/
