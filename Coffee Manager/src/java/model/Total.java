/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class Total extends BaseModel{
    private int tID;
    private Drinks dID;
    private float tQuantity;
    private Date tdob;

    public int gettID() {
        return tID;
    }

    public void settID(int tID) {
        this.tID = tID;
    }

    public Drinks getdID() {
        return dID;
    }

    public void setdID(Drinks dID) {
        this.dID = dID;
    }


    public float gettQuantity() {
        return tQuantity;
    }

    public void settQuantity(float tQuantity) {
        this.tQuantity = tQuantity;
    }

    public Date getTdob() {
        return tdob;
    }

    public void setTdob(Date tdob) {
        this.tdob = tdob;
    }
    
    
    
    
    
    
}
