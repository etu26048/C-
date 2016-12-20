/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rechop;

import Model.*;

/**
 *
 * @author dark-
 */
public class Rechop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       
        TraitementPrincipal pc = new TraitementPrincipal(90,90, 960.00, 0);
        pc.simulation();
        
    }
    
}
