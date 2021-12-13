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

        try {
            String sql = "SELECT * FROM Drinks d INNER JOIN DrinksDetail dd \n" +
"                    ON d.dID = dd.dID INNER Join Product p \n" +
"                    on p.pID = dd.pID wHERE dd.ddID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, model.getDdID());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {

                Product p = new Product();
                p.setpID(rs.getString("pID"));
                p.setpName(rs.getString("pName"));

                Drinks d = new Drinks();
                d.setdID(rs.getInt("dID"));
                d.setdName(rs.getString("dName"));

                DrinksDetail t = new DrinksDetail();
                t.setDdID(rs.getInt("ddID"));
                t.setdID(d);
                t.setDdQuantity(rs.getFloat("ddQuantity"));
                t.setPid(p);

                return t;

            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<DrinksDetail> getdetail(int id) {

        ArrayList<DrinksDetail> ddrinks = new ArrayList<>();

        try {
            String sql = "SELECT * FROM Drinks d JOIN DrinksDetail dd ON d.dID = dd.dID "
                    + "Join Product p on p.pID = dd.pID "
                    + "wHERE d.dID = ?";

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

    public void addMore(DrinksDetail dd){
        try {
            connection.setAutoCommit(false);
            String sql = "INSERT INTO [DrinksDetail]\n"
                    + "           ([dID]\n"
                    + "           ,[pID]\n"
                    + "           ,[ddQuantity])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?)";
            
            
            
            for (DrinksDetail s : dd.getDrinksDetail()) {
                PreparedStatement rs = connection.prepareStatement(sql);
                
                rs.setInt(1, s.getdID().getdID());
                rs.setString(2, s.getPid().getpID());
                rs.setFloat(3, s.getDdQuantity());
                
                rs.executeUpdate();
            }
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(DrinksDetailDBContext.class.getName()).log(Level.SEVERE, null, ex);
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(DrinksDetailDBContext.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        finally
        {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(DrinksDetailDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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

        try {
            String sql = "UPDATE [DrinksDetail]\n"
                    + "   SET [dID] = ?\n"
                    + "      ,[pID] = ?\n"
                    + "      ,[ddQuantity] = ?\n"
                    + " WHERE [ddID]= ?";


            PreparedStatement stm = connection.prepareStatement(sql);

            
            
            
            
            stm.setInt(1, model.getdID().getdID());
            stm.setString(2, model.getPid().getpID());
            stm.setFloat(3, model.getDdQuantity());
            stm.setInt(4, model.getDdID());

            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
