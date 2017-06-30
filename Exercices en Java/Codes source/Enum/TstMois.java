public class TstMois
{ public static void main (String args[])
  { for (Mois m : Mois.values() )
       System.out.println ( m + " comporte " + m.nbJours() + " jours") ;
  }
}
