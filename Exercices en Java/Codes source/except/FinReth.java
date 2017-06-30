class Except extends Exception
{}
public class FinReth
{ public static void f(int n) throws Except
  { try
    { if (n!=1) throw new Except () ;
    }
    catch (Except e)
    { System.out.println ("catch dans f - n = " + n) ;
      throw e ;
    }
    finally
    { System.out.println ("dans finally de f - n = " + n) ;
    }
  }
  public static void main (String args[])
  { int n=0 ;
    try
    { for (n=1 ; n<5 ; n++) f(n) ;
    }
    catch (Except e)
    { System.out.println ("catch dans main - n = " + n) ;
    }
    finally
    { System.out.println ("dans finally de main - n = " + n) ;
    }
  }
}

/*
dans finally de f - n = 1
catch dans f - n = 2
dans finally de f - n = 2
catch dans main - n = 2
dans finally de main - n = 2

*/


