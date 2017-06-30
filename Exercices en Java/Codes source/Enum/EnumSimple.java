public class EnumSimple
{ public static void main (String args[])
  { Couleurs c1, c2 ;
    c1 = Couleurs.bleu ;  // attention : c1 = bleu serait erroné
    c2 = Couleurs.jaune ;
    System.out.println ("couleurs avant echange = " + c1 + " " + c2) ;
    if (c1 != c2)     // ou if (! c1.equals(c2))
    { Couleurs c ;
      c = c1 ;
      c1 = c2 ;
      c2 = c ;
    }
    System.out.println ("couleurs apres echange = " + c1 + " " + c2) ;
  }
}
enum Couleurs {rouge, bleu, vert, jaune } 
