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

    private String pID;
    private String pName;
    private float pQuantity;
    private Category cate;//down vi 

    public String getpID() {
        return pID;
    }

    public void setpID(String pID) {
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

    public Category getCate() {
        return cate;
    }

    public void setCate(Category cate) {
        this.cate = cate;
    }

    
    
    
    
    
    
    
    
    
}
