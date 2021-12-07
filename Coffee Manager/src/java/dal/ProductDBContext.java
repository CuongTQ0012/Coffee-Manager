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
import model.Category;
import model.Product;

/**
 *
 * @author Admin
 */
public class ProductDBContext extends DBContext<Product>{

    @Override
    public ArrayList<Product> list() {
        
        ArrayList<Product> product = new ArrayList<>();
        try {
            String sql = "SELECT p.pID,p.pName,p.pQuantity,p.cID,cName FROM Product p INNER JOIN Category c\n" +
"                    ON p.cID = c.cid";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                Category c = new Category();
                c.setcID(rs.getInt("cID"));
                c.setcName(rs.getString("cName"));
                
                
                
                Product p = new Product();
                p.setpID(rs.getInt("pID"));
                p.setpName(rs.getString("pName"));
                p.setpQuantity(rs.getFloat("pQuantity"));
                p.setcID(c);
                
                
                product.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return product;
        
        
        
        
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product get(Product model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(Product model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Product model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Product model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
