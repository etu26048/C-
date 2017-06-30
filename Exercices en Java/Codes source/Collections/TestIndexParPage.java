import java.util.* ;
public class TestIndexParPage
{ public static void main (String args[])
  { Index monIndex = new Index () ;   monIndex.ajouter ("Java", 25) ;
    monIndex.ajouter ("C++", 45) ;    monIndex.ajouter ("Java", 12) ;
    monIndex.ajouter ("objet", 15) ;  monIndex.ajouter ("polymorphisme", 45) ;
    monIndex.ajouter ("objet", 45) ;  monIndex.ajouter ("langage", 25) ;
    monIndex.creationIndexPage () ;
    monIndex.listeIndexPage () ;
  }
}
class Index
{ public Index ()                                 { // comme precedemment }
  public void ajouter (String entree, int numero) { // comme precedemment }
  public void liste ()                            { // comme precedemment }
  public void creationIndexPage ()
  { indexPage = new TreeMap <Integer, TreeSet <String> > () ;  
    Set <Map.Entry <String, TreeSet <Integer> > > 
                 elementsIndex = index.entrySet () ;
    for (Map.Entry <String, TreeSet <Integer> > elementCourant : elementsIndex)
    { String entreeCourante = elementCourant.getKey () ;
      TreeSet <Integer> pagesCourantes = elementCourant.getValue () ;
      for (Integer numero : pagesCourantes) 
      { TreeSet <String> entreesExistantes = indexPage.get(numero) ;
        if (entreesExistantes == null)
        { TreeSet <String> entreeNouveauNumero = new TreeSet <String> () ;
          entreeNouveauNumero.add(entreeCourante) ;
          indexPage.put(numero, entreeNouveauNumero) ;
        }
        else
        { entreesExistantes.add(entreeCourante) ;
          indexPage.put (numero, entreesExistantes) ;
        }
      }
    } 
  }  
  public void listeIndexPage ()    
  { if (indexPage == null) return ;
    Set <Map.Entry <Integer, TreeSet <String> > >
                  elementsIndexPage = indexPage.entrySet () ;
    for (Map.Entry <Integer, TreeSet <String> > numero : elementsIndexPage)
    { Integer numeroCourant = numero.getKey () ;
      TreeSet <String> entrees = numero.getValue () ;
      System.out.print (numeroCourant + " : ") ;
      for (String entree : entrees) System.out.print (entree + " ") ; 
      System.out.println () ;
    }
  }      
  private TreeMap <String, TreeSet <Integer> > index ;
  private TreeMap <Integer, TreeSet <String> > indexPage ;
}
