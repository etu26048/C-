class A
{ public void f (byte b)   { System.out.println ("f(byte)") ; }
  public void f (int n)    { System.out.println ("f(int)") ; }
  public void f (float x)  { System.out.println ("f(float)") ; }
  public void f (double y) { System.out.println ("f(double)") ; }
}
public class TstSur2
{ public static void main (String args [])
  { A a ; byte b ; short p ; int n ; long q ; float x ; double y ;

    a=new A() ; b=2; p=12 ; n=125 ; q=1000 ; x=2.5f ; y=12.5 ;

    a.f(b) ;      // appel de f(byte)
    a.f(p) ;      // appel de f(int)
    a.f(q) ;      // appel de f(float) après conversion de q en float
    a.f(x) ;      // appel de f(float)
    a.f(y) ;      // appel de f(double)
    a.f(2.*x) ;   // appel de f(double) car 2. est de type double ;
                  //   l'expression 2.*x est de type double
    a.f(b+1) ;    // appel de f(int) car l'expression b+1 est de type int
    a.f(b++) ;    // appel de f(byte) car l'expression b++ est de type byte
  }
}



