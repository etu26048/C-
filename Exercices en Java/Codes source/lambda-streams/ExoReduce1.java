import java.util.stream.* ;
public class ExoReduce1
{ public static void main (String args[])
  { final int NVALEURS = 200 ;
    final double EPS = 1e-2 ;
    double produit1 = DoubleStream.generate (() -> (Math.random()+0.5))
                      .limit(NVALEURS)
                      .peek(xx -> { if (xx > 1-EPS && xx < 1+EPS) 
                                      System.out.print (xx + " ") ; 
                                  })
                      .reduce(1, (xx, yy) -> xx * yy ) ;
    System.out.println ("\nProduit 1 : " + produit1) ;
    double produit2 = DoubleStream.generate ( () -> 2*Math.random())
                          .filter (xx -> xx>0.5 && xx <1.5)
                          .limit(NVALEURS)
                          .peek(xx -> { if (xx > 1-EPS && xx < 1+EPS)
                                        System.out.print (xx + " ") ; 
                                      })
                          .reduce(1, (xx, yy) -> xx * yy ) ;
    System.out.println ("\nProduit 2 : " + produit2) ;
  }
}