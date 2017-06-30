class Abonne
{ public Abonne (String nom, String numero)
  { this.nom = nom ; this.numero = numero ;
  }
  public String getNom()    { return nom ; }
  public String getNumero() { return numero ; }
  private String nom, numero ;
}
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
 // Abonne res = null ;
 //   if (num < nAbon)
 //     res = new Abonne (rep[num].getNom(), rep[num].getNumero()) ;
 //   return res ;
  }
  public String getNumero (String nom)
  { for (int i=0 ; i<=nAbon ; i++)
      if (nom.equals(rep[i].getNom())) return rep[i].getNumero() ;
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
public class TstRep
{ public static void main (String args[])
  { Repert rep = new Repert(10) ;
    System.out.println ("il y a " + rep.getNAbonnes () + " abonnes") ;
    Abonne a = new Abonne("Dupont", "02-38-25-88-99") ;
    Abonne b = new Abonne("Duval",  "04-55-66-77-99") ;
    rep.addAbonne (a) ;
    rep.addAbonne (b) ;
    rep.addAbonne (new Abonne ("Duchene", "02-11-22-33-44")) ;
    rep.addAbonne (new Abonne ("Dubois", "01-11-22-33-44")) ;
    System.out.println ("il y a " + rep.getNAbonnes () + " abonnes") ;
    System.out.println ("qui sont : ") ;
    for (int i=0 ; i<rep.getNAbonnes() ; i++)
      System.out.println (rep.getAbonne(i).getNom() + " " + rep.getAbonne(i).getNumero()) ;
    System.out.println ("ou encore, par ordre alphabetique") ;
    Abonne[] abonnes = rep.getAbonnesTries () ;
    for (int i=0 ; i<abonnes.length ; i++)
       System.out.println (abonnes[i].getNom() + " " + abonnes[i].getNumero()) ;
  }
}

/*

il y a 0 abonnes
il y a 4 abonnes
qui sont :
Dupont 02-38-25-88-99
Duval 04-55-66-77-99
Duchene 02-11-22-33-44
Dubois 01-11-22-33-44
ou encore, par ordre alphabetique
Dubois 01-11-22-33-44
Duchene 02-11-22-33-44
Dupont 02-38-25-88-99
Duval 04-55-66-77-99

*/


