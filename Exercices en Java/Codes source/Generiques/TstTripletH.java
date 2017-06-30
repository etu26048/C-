class TripletH <T, U, V>
{ private T x ; private U y ; private V z ;   // les trois elements du triplet
  public TripletH (T premier, U second, V troisieme)
  { x = premier ; y = second ; z = troisieme ;
  }
  public T getPremier ()
  { return x ; 
  }
  public U getSecond ()
  { return y ;
  }
  public V getTroisieme ()
  { return z ;
  }
  public void affiche ()
  { System.out.println ("premiere valeur : " + x + " - deuxieme valeur : " + y 
		              + " - troisieme valeur : " + z) ;
  }
}

public class TstTripletH
{ public static void main (String args[])
  { Integer oi = 3 ;    
    Double  od = 5.25 ;    
    String os ="hello" ;
    TripletH <Integer, Double, String> tids
       = new TripletH <Integer, Double, String> (oi, od, os) ;
    tids.affiche () ;
    
    Integer n = tids.getPremier() ;
    System.out.println("premier element du triplet ti = " + n ) ;
    Double d = tids.getSecond () ;
    System.out.println ("second element du triplet td = " + d ) ;
  }
}