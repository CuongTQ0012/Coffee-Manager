/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Category;
import model.Drinks;
import model.DrinksDetail;
import model.Product;

/**
 *
 * @author Admin
 */
public class DrinksDBContext extends DBContext<Drinks> {

    @Override
    public ArrayList<Drinks> list() {

        ArrayList<Drinks> drinks = new ArrayList<>();
        try {
            String sql = "SELECT d.dID,d.dName FROM Drinks d";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                Drinks d = new Drinks();
                d.setdID(rs.getInt("dID"));
                d.setdName(rs.getString("dName"));
                // bo sung anh sau 

                drinks.add(d);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return drinks;

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    public ArrayList<DrinksDetail> getdetail(int id){
        
        ArrayList<DrinksDetail> ddrinks = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM Drinks d JOIN DrinksDetail dd ON d.dID = dd.dID "
                    + "Join Product p on p.pID = dd.pID "
                    + "wHERE d.dID = ?"
                    ;
            
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {

                
                Drinks d = new Drinks();
//                d.setdID(rs.getInt("dID"));
                d.setdName(rs.getString("dName"));
                
                Product p = new Product();
                p.setpName(rs.getString("pName"));
                
                
                DrinksDetail dd = new DrinksDetail();
                
                dd.setdID(d);
                dd.setPid(p);
                dd.setDdQuantity(rs.getFloat("ddQuantity"));
                
                ddrinks.add(dd);
                


            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ddrinks;
        
        
    }
    
    
    
    
    
    @Override
    public Drinks get(Drinks model) {
        
        try {
            String sql = "SELECT * FROM Drinks d  WHERE d.dID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, model.getdID());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {

                
                Drinks d = new Drinks();
                d.setdID(rs.getInt("dID"));
                d.setdName(rs.getString("dName"));
                
                
                

                return d;

            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(Drinks model) {

        try {

            String sql = "INSERT INTO [Drinks]\n"
                    + "           ([dID]\n"
                    + "           ,[dName])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?)";
            PreparedStatement stm = connection.prepareStatement(sql);

            stm.setInt(1, model.getdID());
            stm.setString(2, model.getdName());

            stm.executeUpdate();

        } catch (Exception e) {

            Logger.getLogger(ProductDBContext.class.getName());
        }

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Drinks model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Drinks model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
