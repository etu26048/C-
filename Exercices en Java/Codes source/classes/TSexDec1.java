class SexDec
{ public SexDec (double dec)
  { this.dec = dec ;
  }
  public SexDec (int h, int mn, int s)
  { dec = h + mn/60. + s/3600. ;
  }
  public double getDec()
  { return dec ;
  }
  public int getH()
  { int h = (int)dec ; return h ;
  }
  public int getM()
  { int h = (int)dec ;
    int mn = (int)(60*(dec-h)) ;
    return mn ;
  }
  public int getS()
  { int h = (int)dec ;
    double minDec = 60*(dec-h) ;
    int mn = (int)minDec ;
    int sec = (int)(60*(minDec-mn)) ;
    return sec ;
  }
  private double dec ;
}
public class TSexDec1
{ public static void main (String args[])
  { SexDec h1 = new SexDec(4.51) ;
    System.out.println ("h1 - decimal = " + h1.getDec()
       +"  Sexa = " + h1.getH() + " " + h1.getM() + " " + h1.getS()) ;
   SexDec h2 = new SexDec (2, 32, 15) ;
   System.out.println ("h2 - decimal = " + h2.getDec()
       +"  Sexa = " + h2.getH() + " " + h2.getM() + " " + h2.getS()) ;
}


/*
h1 - decimal = 4.51  Sexa = 4 30 35
h2 - decimal = 2.5375  Sexa = 2 32 15
*/


