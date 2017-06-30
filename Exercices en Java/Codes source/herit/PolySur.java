class A
{ public void f(double x) { System.out.print ("A.f(double=" + x +") ") ; }
}
class B extends A {}
class C extends A
{ public void f(long q)   { System.out.print ("C.f(long="   + q + ") ") ; }
}
class D extends C
{ public void f(int n)    { System.out.print ("D.f(int="    + n + ") ") ; }
}
class F extends C
{ public void f(float x)  { System.out.print ("F.f(float="  + x + ") ") ; }
  public void f(int n)    { System.out.print ("F.f(int="    + n + ") ") ; }
}

public class PolySur
{ public static void main (String arg[])
  { byte bb=1 ; short p=2 ; int n=3 ; long q=4 ;
    float x=5.f ; double y=6. ;

    System.out.println ("** A ** ") ;
    A a = new A() ; a.f(bb) ; a.f(x) ;                   System.out.println() ;

    System.out.println ("** B ** ") ;
    B b = new B() ; b.f(bb) ; b.f(x) ;                   System.out.println() ;
    a = b ;         a.f(bb) ; a.f(x) ;                   System.out.println() ;

    System.out.println ("** C ** ") ;
    C c = new C() ; c.f(bb) ; c.f(q) ; c.f(x) ;          System.out.println() ;
    a = c ;         a.f(bb) ; a.f(q) ; a.f(x) ;          System.out.println() ;

    System.out.println ("** D ** ") ;
    D d = new D() ; d.f(bb) ; c.f(q) ; c.f(y) ;          System.out.println() ;
    a = c ;         a.f(bb) ; a.f(q) ; a.f(y) ;          System.out.println() ;

    System.out.println ("** F ** ") ;
    F f = new F() ; f.f(bb) ; f.f(n) ; f.f(x) ; f.f(y) ; System.out.println() ;
    a = f ;         a.f(bb) ; a.f(n) ; a.f(x) ; a.f(y) ; System.out.println() ;
    c = f ;         c.f(bb) ; c.f(n) ; c.f(x) ; c.f(y) ;
  }
}

/*
** A **
A.f(double=1.0) A.f(double=5.0)
** B **
A.f(double=1.0) A.f(double=5.0)
A.f(double=1.0) A.f(double=5.0)
** C **
C.f(long=1) C.f(long=4) A.f(double=5.0)
A.f(double=1.0) A.f(double=4.0) A.f(double=5.0)
** D **
D.f(int=1) C.f(long=4) A.f(double=6.0)
A.f(double=1.0) A.f(double=4.0) A.f(double=6.0)
** F **
F.f(int=1) F.f(int=3) F.f(float=5.0) A.f(double=6.0)
A.f(double=1.0) A.f(double=3.0) A.f(double=5.0) A.f(double=6.0)
C.f(long=1) C.f(long=3) A.f(double=5.0) A.f(double=6.0)
*/


