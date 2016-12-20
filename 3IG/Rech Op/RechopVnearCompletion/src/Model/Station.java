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
public class Station implements Serializable{
    
    private int ds;
    private char priorité;

    public Station(int ds, char priorité) {
        this.ds = ds;
        this.priorité = priorité;
    }

    public int getDs() {
        return ds;
    }

    public void setDs(int ds) {
        this.ds = ds;
    }

    @Override
    public String toString() {
        return "Station{" + "ds=" + ds + ", priorit\u00e9=" + priorité + '}';
    }

    public char getPriorité() {
        return priorité;
    }

    public void setPriorité(char priorité) {
        this.priorité = priorité;
    }

    
    
}
