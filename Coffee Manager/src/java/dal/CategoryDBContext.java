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

/**
 *
 * @author Admin
 */
public class CategoryDBContext extends DBContext<Category> {

    @Override
    public ArrayList<Category> list() {

        ArrayList<Category> category = new ArrayList<>();
        try {
            String sql = "Select cID,cName from Category";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                Category c = new Category();
                c.setcID(rs.getInt("cID"));
                c.setcName(rs.getString("cName"));
                category.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return category;

        
            
        
        
        
        
    }

    @Override
    public Category get(Category model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(Category model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Category model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Category model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
