/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Admin
 */
public class DrinksDetail extends BaseModel{
    private Drinks dID;
    private Product pid;
    private float ddQuantity;

    public Drinks getdID() {
        return dID;
    }

    public void setdID(Drinks dID) {
        this.dID = dID;
    }

    public Product getPid() {
        return pid;
    }

    public void setPid(Product pid) {
        this.pid = pid;
    }

    public float getDdQuantity() {
        return ddQuantity;
    }

    public void setDdQuantity(float ddQuantity) {
        this.ddQuantity = ddQuantity;
    }
    
    
    
    
    
}
