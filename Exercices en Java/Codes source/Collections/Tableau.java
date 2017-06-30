import java.util.* ;
public class Tableau
{ public static void main (String args[])
  { int t[] = { 3, -5, 9, 2, 0, -8, 12, 7, 3, 12 } ;
    ArrayList <Integer> tab = new ArrayList<Integer> () ;
    for (int elem : t) tab.add (elem) ;

      // affichage ordre naturel 
    System.out.println ("ordre naturel - methode 1") ;
    for (int elem : tab) System.out.print (elem + " ") ;
    System.out.println ("\nordre naturel - methode 2") ;
    System.out.println (tab) ;
    System.out.println ("ordre naturel - methode 3") ;
    for (int i=0 ; i<tab.size() ; i++) System.out.print (tab.get(i)+ " ") ; 
    System.out.println ("\nordre naturel - methode 4") ;
    ListIterator <Integer> it = tab.listIterator() ;
    while (it.hasNext()) System.out.print(it.next() + " ") ;

      // affichage ordre inverse
    System.out.println ("\nordre inverse - methode 1") ;
    for (int i=tab.size()-1 ; i>=0 ; i--) System.out.print (tab.get(i)+ " ") ;
    System.out.println ("\nordre inverse - methode 2") ;
    ListIterator <Integer> itr = tab.listIterator(tab.size()) ; // fin de liste
    while (itr.hasPrevious()) System.out.print(itr.previous() + " ") ;
   
     // affichage éléments de rang pair
    System.out.println ("\nelements de rang pair - methode 1") ;
    for (int i=0 ; i<tab.size() ; i+=2) System.out.print (tab.get(i)+ " ") ;  
    System.out.println ("\nelements de rang pair - methode 2") ;
    ListIterator <Integer> itp = tab.listIterator() ;
    while (itp.hasNext())
    { System.out.print(itp.next() + " ") ;
      itp.next();
    }  
  
     // mise a zero d'une copie de tab
    ArrayList <Integer> tab1 = new ArrayList<Integer> (tab) ;
    System.out.println ("\nmise a zero - methode 1") ;
    for (int i=0 ; i<tab1.size() ; i++) if (tab1.get(i) < 0) tab1.set (i, 0) ;
    System.out.println (tab1) ;

    tab1 = new ArrayList<Integer> (tab) ;
    System.out.println ("mise a zero - methode 2") ;
    ListIterator <Integer> itz = tab1.listIterator() ;
    while (itz.hasNext())if (itz.next() < 0) itz.set(0) ;
    System.out.println (tab1) ;
  }  
}
