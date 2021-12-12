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
public class Memory {
    int mid;
    String id;
    float t;
    float dd;
     float p;
     float to;

    public Memory() {
    }

    public Memory(String id, float to) {
//        this.mid = mid;
        this.id = id;
        this.to = to;
    }
    
    
    
    public Memory(String id, float t, float dd, float p, float to) {
        this.id = id;
        this.t = t;
        this.dd = dd;
        this.p = p;
        this.to = to;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public float getTo() {
        return to;
    }

    public void setTo(float to) {
        this.to = to;
    }

   

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getT() {
        return t;
    }

    public void setT(float t) {
        this.t = t;
    }

    public float getDd() {
        return dd;
    }

    public void setDd(float dd) {
        this.dd = dd;
    }

    public float getP() {
        return p;
    }

    public void setP(float p) {
        this.p = p;
    }
     
    
    
    
    
}
