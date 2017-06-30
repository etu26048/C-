public class TstMois2
{ public static void main (String args[])
  { for (Mois2 m : Mois2.values() )
       System.out.println ( m.abreviation() + " = " + m + " = " 
    		                +m.nomAnglais() + " - " + m.nbJours() + " jours")  ;
  }
}
