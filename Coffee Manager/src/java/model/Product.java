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

    private int pID;
    private String pName;
    private float pQuantity;
    private Category cate;//down vi 

    public Product() {
    }

    public Product(int pID, String pName, float pQuantity, Category cate) {
        this.pID = pID;
        this.pName = pName;
        this.pQuantity = pQuantity;
        this.cate = cate;
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

    public Category getCate() {
        return cate;
    }

    public void setCate(Category cate) {
        this.cate = cate;
    }

    
    
    
    
    
    
    
    
    
}
