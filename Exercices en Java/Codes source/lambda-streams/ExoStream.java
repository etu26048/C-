import java.util.stream.* ;
public class ExoStream
{ public static void main (String args[])
  { int []  tab = { 3, 5, -3, 8, 12, 4, 7, 4, 8, 3 } ;
    long nb = IntStream.of(tab).filter(xx -> xx >0).count() ;       // 1
    System.out.println ("nb = " + nb) ;
    IntStream.of(tab).filter(xx -> xx > 3).sorted()                 // 2
                     .forEach(xx -> System.out.print (xx + " ")) ;
    System.out.println();
    IntStream.of(tab).filter(xx -> xx >3).sorted().distinct()       // 3
                     .forEach(xx -> System.out.print (xx + " ")) ;
    int s =IntStream.of(tab).map(xx -> Math.abs(xx))                // 4
                            .map(xx -> xx * xx).sum() ;
    System.out.println ("\nresultat = " + s) ;
  } 
}