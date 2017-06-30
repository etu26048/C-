class Aleat
{ public Aleat (int n, int l)
  { nVal = n ; limite = l ;
    val = new int[n] ;
    for (int i=0 ; i<nVal ; i++)
      val[i] = (int)((l+1)*Math.random()) ;
  }
  public int getValeur (int num)
  { return val[num] ;
  }
  public int[] getValeurs ()
  { int[] res = new int[nVal] ;
    for (int i=0 ; i<nVal ; i++)
      res[i] = val[i] ;
    return res ;
  }
  public int[] histo ()
  { int[] res = new int[limite+1] ;  // pour aller de 0 à limite
    for (int i=0 ; i<nVal ; i++) res[val[i]]++ ;
    return res ;
  }
  private int[] val ;
  private int nVal, limite ;
}
public class TstAleat
{ public static void main (String args[])
  { final int NS1=8, MAX1=5, NS2=10000, MAX2=9 ;
    Aleat suite1 = new Aleat (NS1, 10) ;
    System.out.print ("suite1, valeur par valeur = ") ;
    for (int i=0 ; i<NS1 ; i++)
      System.out.print (suite1.getValeur(i) + " ") ;
    System.out.println () ;
    System.out.print ("suite1, globale           = ") ;
    int[] valeurs = suite1.getValeurs() ;
    for (int i=0 ; i<NS1 ; i++)
      System.out.print (valeurs[i] + " ") ;
    System.out.println() ;
    int [] hist = suite1.histo() ;
    System.out.print ("histogramme de suite1 = " ) ;
    for (int i=0 ; i<=MAX1 ; i++) System.out.print (hist[i] + " ") ;
    System.out.println() ;

    Aleat suite2 = new Aleat (NS2, MAX2) ;
    hist = suite2.histo() ;
    System.out.print ("histogramme de suite2 = " ) ;
    for (int i=0 ; i<=MAX2 ; i++) System.out.print (hist[i] + " ") ;
  }
}

