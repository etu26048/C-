/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author dark-
 */
public class Relatif implements Serializable{
    
    private Integer ds;
    private char priorité;

    public Relatif(int ds, char priorité) {
        this.ds = ds;
        this.priorité = priorité;
    }

    public Integer getDs() {
        return ds;
    }

    @Override
    public String toString() {
        return "Relatif{" + "ds=" + ds + ", priorit\u00e9=" + priorité + '}';
    }

    public void setDs(int ds) {
        this.ds = ds;
    }

    public char getPriorité() {
        return priorité;
    }

    public void setPriorité(char priorité) {
        this.priorité = priorité;
    }
    
    
    
    
}
