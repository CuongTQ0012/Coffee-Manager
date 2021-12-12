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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Drinks;
import model.DrinksDetail;
import model.Product;

/**
 *
 * @author Admin
 */
public class DrinksDetailDBContext extends DBContext<DrinksDetail> {

    @Override
    public ArrayList<DrinksDetail> list() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DrinksDetail get(DrinksDetail model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
                dd.setDdID(rs.getInt("ddID"));
                ddrinks.add(dd);
                


            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ddrinks;
        
        
    }
    

    @Override
    public void insert(DrinksDetail model) {

        try {

            String sql = "INSERT INTO [DrinksDetail]\n"
                    + "           ([dID]\n"
                    + "           ,[pID]\n"
                    + "           ,[ddQuantity])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?)";

            PreparedStatement stm = connection.prepareStatement(sql);

            stm.setInt(1, model.getdID().getdID());
            stm.setString(2, model.getPid().getpID());
            stm.setFloat(3, model.getDdQuantity());

            stm.executeUpdate();

        } catch (Exception e) {

            Logger.getLogger(ProductDBContext.class.getName());
        }

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(DrinksDetail model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(DrinksDetail model) {
        
         try {
            String sql = "DELETE FROM [DrinksDetail]\n"
                    + "      WHERE [ddID]= ?";
            
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, model.getDdID());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
