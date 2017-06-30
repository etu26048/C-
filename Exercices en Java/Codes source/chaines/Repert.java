class Repert
{ public Repert (int nMax)
  { this.nMax = nMax ;
    rep = new Abonne [nMax] ;
    nAbon = 0 ;
  }
  
public boolean addAbonne (Abonne a)
  { if (nAbon >= nMax) return false ;
    rep[nAbon] = a ;
    nAbon++ ;
    return true ;
  }
  public int getNAbonnes () { return nAbon ; }
  public Abonne getAbonne (int num)
  { if (num < nAbon) return rep[num] ;
    return null ;
  }
  public String getNumero (String nom)
  { for (int i=0 ; i<=nAbon ; i++)
     if (nom.equals(rep[i].getNom())) return rep[i].getNumero() ;
    // ou (depuis JDK 5.0) :  
    // for (Abonne a : rep)
    //    if (nom.equals(a.getNom())) return a.getNumero() ; 
      return null ;
  }
  public Abonne[] getAbonnesTries ()
  { Abonne[] repTrie = new Abonne[nAbon] ;
    for (int i=0 ; i<nAbon ; i++)
      repTrie[i] = rep[i] ;
    for (int i=0 ; i<nAbon-1 ; i++)
      for (int j=i+1 ; j<nAbon ; j++)
        if ((repTrie[i].getNom()).compareTo(repTrie[j].getNom()) > 0)
          { Abonne temp = repTrie[i] ;
            repTrie[i] = repTrie[j] ;
            repTrie[j] = temp ;
          }
     return repTrie ;
  }
  private int nMax, nAbon ;
  private Abonne[] rep ;
}
