class A
{ public void f(int n, float x)
  { System.out.println ("f(int n, float x)        n = " + n + " x = " + x) ;
  }
  private void f(long q, double y)
  { System.out.println ("f(long q, double y)      q = " + q + " y = " + y) ;
  }
  public void f(double y1, double y2)
  { System.out.println ("f(double y1, double y2)  y1 = " + y1 + " y2 = " + y2) ;
  }
  public void g()
  { int n=1 ; long q=12 ; float x=1.5f ; double y = 2.5 ;
    System.out.println ("--- dans g ") ;
    f(n, q) ;
    f(q, n) ;
    f(n, x) ;
    f(n, y) ;
  }
}
public class SurdfAcc
{ public static void main (String args[])
  { A a = new A() ;
    a.g() ;
    System.out.println ("--- dans main") ;
    int n=1 ; long q=12 ; float x=1.5f ; double y = 2.5 ;
    a.f(n, q) ;
    a.f(q, n) ;
    a.f(n, x) ;
    a.f(n, y) ;    
  }
}

/*
--- dans g
f(int n, float x)        n = 1 x = 12.0
f(long q, double y)      q = 12 y = 1.0
f(int n, float x)        n = 1 x = 1.5
f(long q, double y)      q = 1 y = 2.5
--- dans main
f(int n, float x)        n = 1 x = 12.0
f(double y1, double y2)  y1 = 12.0 y2 = 1.0
f(int n, float x)        n = 1 x = 1.5
f(double y1, double y2)  y1 = 1.0 y2 = 2.5
*/


