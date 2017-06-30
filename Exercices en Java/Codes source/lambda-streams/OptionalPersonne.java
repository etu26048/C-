import java.util.* ;
public class OptionalPersonne
{ public static void main (String [] args)
  { Personne[] tab = { new Personne ("thibault", "Rougier", 2001),
                       new Personne ("thomas", "Niesseron", 1987),
                       new Personne ("thifaine", "Mitenne", 1959),
                       new Personne ("maxime", "Forest", 1995),
                       new Personne ("jules", "Forest", 1995) } ;
    List<Personne> liste = Arrays.asList(tab) ;
   
      // utilisation d'un Stream<Personne> transforme par map en IntStream
    OptionalInt anneeJeune = liste.stream()
                .mapToInt(pp -> pp.getAnnee()).max() ;
    if (anneeJeune.isPresent())
         System.out.println ("--- Methode 1 - Le plus jeune est ne en : "
                              + anneeJeune.getAsInt()) ;
    else System.out.println ("--- Liste vide") ;
   
      // recherche de min sur un Stream<Personne>
    Optional<Personne> personneJeune =liste.stream()
                .max(Comparator.comparing(Personne::getAnnee)) ;
    if (personneJeune.isPresent()) 
    { Personne pj = personneJeune.get();
      System.out.println ("--- Methode 2 - Le plus jeune est : "
            + pj.getNom() + " " + pj.getPrenom() + " " + pj.getAnnee()) ;
    }  
    else System.out.println ("--- Liste vide") ;
  }
}
class Personne
{ public Personne (String prenom, String nom, int annee)
  { this.nom = nom ; this.prenom = prenom ; annee_naissance = annee ; }
  public String getNom() { return nom ; }
  public String getPrenom() { return prenom ; }
  public int getAnnee() { return annee_naissance ; }
  private String nom, prenom ;
  private int annee_naissance ;
}