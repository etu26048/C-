class A
{ void f (int n, float x) {  }
  void g (byte b) {  }
}
public class TestA
{ public static void main (String args[])
{
A a = new A() ;
int n ; byte b ;
float x ;
double y ;
        n=2 ; b=3 ; x=4 ; y=5 ;
p.f (n, x) ;          // OK : appel normal
p.f (b+3, x) ;        // OK : b+3 est déjà de type int
p.f (b, x) ;          // OK : b de type byte sera converti en int
p.f (n, y) ;          // erreur : y de type double ne peut être converti en float
p.f (n, (float)y) ;   // OK
p.f (n, 2*x) ;        // OK : 2*x est de type float
p.f (n+5, x+0.5) ;    // erreur : 0.5 est de type double, donc X+0.5 est
                      //  de type double (qui ne peut pas être converti en float)

p.g (b) ;   // OK : appel normal
p.g (b1+1) ; // erreur : b1+1 de type int ne peut être converti en byte
p.g (b1++) ; // OK : b1++ est de type int
            //  (mais peu conseillé : on a modifié la valeur de b1)
p.g (3) ;   // OK : constante de type int peut etre affectée à byte
}
}
