import java.util.* ;
public class TestIndex
{ public static void main (String args[])
  { Index monIndex = new Index () ;
    monIndex.ajouter ("Java", 25) ;
    monIndex.ajouter ("C++", 45) ;
    monIndex.ajouter ("Java", 12) ;
    monIndex.ajouter ("objet", 15) ;
    monIndex.ajouter ("polymorphisme", 45) ;
    monIndex.liste() ;
  }
}
class Index
{ public Index () 
  { index = new TreeMap <String, TreeSet <Integer> > () ; }
  public void ajouter (String entree, int numero)
  {   // si entree n'existe pas dans l'index, on l'ajoute, associe au numero
      // sinon, on ajoute le numero de page a l'ensemble des numeros 
      //  deja associes a entree
    TreeSet <Integer> numerosExistants = index.get(entree) ;
    if (numerosExistants == null)
    { TreeSet <Integer> numeroNouveauNom = new TreeSet <Integer> () ;
      numeroNouveauNom.add (numero) ;
      index.put (entree, numeroNouveauNom) ;
    }
    else
    { numerosExistants.add (numero) ;
      index.put(entree, numerosExistants) ;  // remplace l'entree precedente
    }
  } 
  public void liste ()
  { Set <Map.Entry <String, TreeSet <Integer> > > 
                 elementsIndex = index.entrySet () ;
    for (Map.Entry <String, TreeSet <Integer> > elementCourant : elementsIndex)
    { String entreeCourante = elementCourant.getKey () ;
      TreeSet <Integer> numeros = elementCourant.getValue () ;
      System.out.print (entreeCourante + " : ") ;
      for (int num : numeros) System.out.print (num + " ") ; 
      System.out.println () ;
    }
  }
  private TreeMap <String, TreeSet <Integer> > index ;
}
