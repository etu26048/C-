enum Mois
{ janvier (31),   fevrier (28), mars (31),     avril (30),
  mai (31),       juin (30),    juillet (31),  aout (31), 
  septembre (30), octobre (31), novembre (30), decembre (31) ;
  private Mois (int n) // constructeur (en argument, nombre de jours du mois)
  { nj = n ; ;
  }
  public int nbJours () { return nj ; }
  private int nj ;   
}
