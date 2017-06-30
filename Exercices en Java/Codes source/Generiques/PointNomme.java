class PointNomme extends Couple <Integer>
{ private String nom ;
  public PointNomme (Integer premier, Integer second, String nom)
  { super (premier, second) ;
    this.nom = nom ;
  }
  public void affiche ()
  { System.out.print ("nom = " + nom + " - " ) ;
    super.affiche() ; 
  }
}
