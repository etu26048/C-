class EntNat
{ public EntNat (int n) throws ErrConst
  { if (n<0) throw new ErrConst(n) ;
    this.n = n ;
  }
  public static EntNat somme (EntNat n1, EntNat n2) throws ErrSom, ErrConst
  { int op1 = n1.n, op2 = n2.n ;
    long s = op1 + op2 ;
    if (s > Integer.MAX_VALUE) throw new ErrSom (op1, op2) ;
    return new EntNat (op1+op2) ;
  }
  public static EntNat diff (EntNat n1, EntNat n2) throws ErrDiff, ErrConst
  { int op1 = n1.n, op2 = n2.n ;
    int d = op1 - op2 ;
    if (d<0) throw new ErrDiff(op1, op2) ;
    EntNat res = new EntNat (d) ;
    return res ;
  }
  public static EntNat prod (EntNat n1, EntNat n2) throws ErrProd, ErrConst
  { int op1 = n1.n, op2 = n2.n ;
    long p = (long)op2 * (long)op1 ;
    if (p > Integer.MAX_VALUE) throw new ErrProd(op1, op2) ;
    return new EntNat ((int)p) ;
  }
  public int getN() { return n ; }
  private int n ;
}
class ErrNat extends Exception
{}
class ErrConst extends ErrNat
{ public ErrConst (int n) { this.n = n ; }
  public int n ;
}
class ErrOp extends ErrNat
{ public ErrOp (int n1, int n2)
  { this.n1 = n1 ; this.n2 = n2 ;
  }
  public int n1, n2 ;
}
class ErrSom extends ErrOp
{ public ErrSom (int n1, int n2)
  { super(n1, n2) ;
  }
}
class ErrDiff extends ErrOp
{ public ErrDiff (int n1, int n2)
  { super(n1, n2) ;
  }
}
class ErrProd extends ErrOp
{ public ErrProd (int n1, int n2)
  { super (n1, n2) ;
  }
}
public class TstEntN2
{ public static void main (String args[])
  { try
    { EntNat n1 = new EntNat(20), n2 = new EntNat(12) ;
      EntNat d ;
      d = EntNat.diff (n1, n2) ;
      d = EntNat.diff (n2, n1) ;
    }
    catch (ErrNat e)
    { System.out.println ("*** erreur Entier naturel ****") ;
    }
    try
    { EntNat n3 = new EntNat (50000), n4 = new EntNat (45000) ;
      EntNat d = EntNat.diff (n3, n4) ;
      EntNat s = EntNat.somme (n3, n4) ;
      EntNat p = EntNat.prod (n3, n4) ;
    }
    catch (ErrConst e)
    { System.out.println ("*** erreur construction EntNat avec argument "
                          + e.n) ;
    }
    catch (ErrDiff e)
    { System.out.println ("*** erreur difference EntNat - valeurs "
                          + e.n1 + " " + e.n2) ;
    }
    catch (ErrSom e)
    { System.out.println ("*** erreur somme EntNat - valeurs "
                          + e.n1 + " " + e.n2) ;
    }
    catch (ErrProd e)
    { System.out.println ("*** erreur produit EntNat - valeurs "
                          + e.n1 + " " + e.n2) ;
    }
  }
}

/*
*** erreur Entier naturel ****
*** erreur produit EntNat - valeurs 50000 45000
*/



