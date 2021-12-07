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
public class Product extends BaseModel{

    public static void add(Product p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private int pID;
    private String pName;
    private float pQuantity;
    private Category cID;//down vi 

    public Product() {
    }


    public int getpID() {
        return pID;
    }

    public void setpID(int pID) {
        this.pID = pID;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public float getpQuantity() {
        return pQuantity;
    }

    public void setpQuantity(float pQuantity) {
        this.pQuantity = pQuantity;
    }

    public Category getcID() {
        return cID;
    }

    public void setcID(Category cID) {
        this.cID = cID;
    }

    
    
    
    
    
    
    
    
}
