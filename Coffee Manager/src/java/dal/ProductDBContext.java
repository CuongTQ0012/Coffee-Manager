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
public class ProductDBContext extends DBContext<Product> {

    @Override
    public ArrayList<Product> list() {

        ArrayList<Product> product = new ArrayList<>();
        try {
            String sql = "SELECT p.pID,p.pName,p.pQuantity,p.cID,cName FROM Product p INNER JOIN Category c\n"
                    + "                    ON p.cID = c.cid";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Category c = new Category();
                c.setcID(rs.getInt("cID"));
                c.setcName(rs.getString("cName"));

                Product p = new Product();
                p.setpID(rs.getString("pID"));
                p.setpName(rs.getString("pName"));
                p.setpQuantity(rs.getFloat("pQuantity"));
                p.setCate(c);

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

        try {
            String sql = "SELECT p.pID,p.pName,p.pQuantity,p.cID,cName FROM Product p INNER JOIN Category c \n"
                    + "ON p.cID = c.cid WHERE p.pID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, model.getpID());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {

                Category d = new Category();
                d.setcID(rs.getInt("cID"));
                d.setcName(rs.getString("cName"));

                Product s = new Product();

                s.setpID(rs.getString("pID"));
                s.setpName(rs.getString("pName"));
                s.setpQuantity(rs.getFloat("pQuantity"));
                s.setCate(d);

                return s;

            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(Product model) {

        try {
            String sql2 = "INSERT INTO [Product]\n"
                    + "           ([pID]\n"
                    + "           ,[pName]\n"
                    + "           ,[pQuantity]\n"
                    + "           ,[cID])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)\n";
            PreparedStatement stm = connection.prepareStatement(sql2);

            stm.setString(1, model.getpID());
            stm.setString(2, model.getpName());
            stm.setFloat(3, model.getpQuantity());
            stm.setInt(4, model.getCate().getcID());

            stm.executeUpdate();

        } catch (Exception e) {

            Logger.getLogger(ProductDBContext.class.getName());
        }

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Product model) {

        try {
            String sql = "UPDATE [Product]\n"
                    + "   SET [pName] = ?\n"
                    + "      ,[pQuantity] = ?\n"
                    + "      ,[cID] = ?\n"
                    + " WHERE [pID]= ?";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(4, model.getpID());
            stm.setString(1, model.getpName());
            stm.setFloat(2, model.getpQuantity());
            stm.setInt(3, model.getCate().getcID());

            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Product model) {

        try {
            String sql = "DELETE FROM [Product]\n"
                    + "      WHERE [pID]= ?";
            
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, model.getpID());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
