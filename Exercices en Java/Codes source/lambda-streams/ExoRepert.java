import java.util.stream.* ;
import java.util.* ;
public class ExoRepert
{ public static void main (String [] args)
  { Personne[] tab = { new Personne ("thibault", "Rougier", 2001),
                       new Personne ("thomas", "Niesseron", 1987),
                       new Personne ("thifaine", "Mitenne", 1959),
                       new Personne ("maxime", "Forest", 1995),
                       new Personne ("jules", "Forest", 1995) } ;
  System.out.println ("--- Nes apres 1985 : ") ; 
  Stream.of(tab).filter(pp -> pp.getAnnee() > 1985)
                .forEach(pp -> System.out.print (pp.getPrenom() + ", ")) ;
  System.out.println ("\n--- Nes avant 2000 :") ;
  long nombre = Stream.of(tab).filter(pp -> pp.getAnnee() < 2000)
                         .sorted(Comparator.comparing(Personne::getNom))
                         .peek(pp -> System.out.print (pp.getNom() + " "))
                         .count() ;
   System.out.println ("\n       Ils sont "+nombre) ;
   System.out.println ("--- Tous tries sur nom + prenom : ") ;
   Stream.of(tab).sorted(Comparator.comparing
                                   (pp -> pp.getNom() + pp.getPrenom()))
                 .forEach(pp -> System.out.print ("(" + pp.getNom() + ", "
                                                  + pp.getPrenom() +") ")) ;
  }
}