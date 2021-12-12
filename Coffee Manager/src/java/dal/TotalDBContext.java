/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Drinks;
import model.Memory;
import model.Product;
import model.Total;

/**
 *
 * @author Admin
 */
public class TotalDBContext extends DBContext<Total> {

    @Override
    public ArrayList<Total> list() {

        ArrayList<Total> total = new ArrayList<>();
        try {
            String sql = "select * from Total t join Drinks d on t.dID = d.dID";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                Drinks d = new Drinks();
                d.setdID(rs.getInt("dID"));
                d.setdName(rs.getString("dName"));

                Total t = new Total();
                t.settID(rs.getInt("tID"));
                t.setdID(d);
                t.settQuantity(rs.getFloat("tQuantity"));
                t.setTdob(rs.getDate("tdob"));

                total.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TotalDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Total get(Total model) {

        try {
            String sql = "SELECT * FROM Total t  INNER JOIN Drinks d \n"
                    + "                    ON t.tID = d.dID  WHERE t.tID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, model.gettID());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {

                Drinks d = new Drinks();
                d.setdID(rs.getInt("dID"));
//                d.setdName(rs.getString("dName"));

                Total t = new Total();
                t.settID(rs.getInt("tID"));
                t.setdID(d);
                t.settQuantity(rs.getFloat("tQuantity"));
                t.setTdob(rs.getDate("tdob"));

                return t;

            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Total get2(int i) {

        try {
            String sql = "SELECT * FROM Total t  INNER JOIN Drinks d \n"
                    + "                    ON t.tID = d.dID  WHERE t.tID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, i);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {

                Drinks d = new Drinks();
                d.setdID(rs.getInt("dID"));
//                d.setdName(rs.getString("dName"));

                Total t = new Total();
                t.settID(rs.getInt("tID"));
                t.setdID(d);
                t.settQuantity(rs.getFloat("tQuantity"));
                t.setTdob(rs.getDate("tdob"));

                return t;

            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(Total model) {

        try {

            String sql = "INSERT INTO [Total]\n"
                    + "           ([dID]\n"
                    + "           ,[tQuantity]\n"
                    + "           ,[tdob])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?)";

            PreparedStatement stm = connection.prepareStatement(sql);

            stm.setInt(1, model.getdID().getdID());
            stm.setFloat(2, model.gettQuantity());
            stm.setDate(3, model.getTdob());

            stm.executeUpdate();

        } catch (Exception e) {

            Logger.getLogger(ProductDBContext.class.getName());
        }

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Total model) {

        try {
            String sql = "UPDATE [Total]\n"
                    + "   SET [dID] = ?\n"
                    + "      ,[tQuantity] = ?\n"
                    + "      ,[tdob] = ?\n"
                    + " WHERE [tID]= ?";

            PreparedStatement stm = connection.prepareStatement(sql);

            stm.setDate(3, model.getTdob());
            stm.setInt(4, model.gettID());
            stm.setInt(1, model.getdID().getdID());
            stm.setFloat(2, model.gettQuantity());

            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void action() {
        try {
            float tQuan;
            float ddQuan;
            float pQuan;
            String pID;
            float total;

            ArrayList<Memory> ml = new ArrayList<>();
            ArrayList<Product> pl = new ArrayList<>();

            String sql = "SELECT * FROM Total t \n"
                    + "INNER JOIN Drinks d ON t.dID = d.dID \n"
                    + "INNER JOIN DrinksDetail dd on dd.dID = d.dID\n"
                    + "INNER JOIN Product p on p.pID=dd.pID ";

            

            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                tQuan = rs.getFloat("tQuantity");
                ddQuan = rs.getFloat("ddQuantity");
                total = tQuan * ddQuan;
                pID = rs.getString("pID");

                Memory m = new Memory(pID, total);
                ml.add(m);
            }

            String sql4 = "select p.pID,p.pQuantity from Product p";
            PreparedStatement stm4 = connection.prepareStatement(sql4);
            ResultSet rs4 = stm4.executeQuery();

            String proID;
            float proQuan;
            while (rs4.next()) {

                proID = rs4.getString("pID");
                proQuan = rs4.getFloat("pQuantity");

                Product p = new Product(proID, proQuan);
                pl.add(p);

            }

            String sql2 = "UPDATE [Product]\n"
                    + "   SET \n"
                    + "      \n"
                    + "      [pQuantity] = ?\n"
                    + "      \n"
                    + " WHERE [pID] = ?";
            PreparedStatement stm2 = connection.prepareStatement(sql2);

            for (Product p : pl) {
                for (Memory m : ml) {
                    if (p.getpID().equals(m.getId())) {
                        p.setpQuantity(p.getpQuantity() - m.getTo());
                    }
                }
            }

            for (Product p : pl) {

                stm2.setString(2,p.getpID());
                stm2.setFloat(1,p.getpQuantity());
                stm2.executeUpdate();

            }

            
            String sql3 = "delete from [Total];";
            PreparedStatement stm3 = connection.prepareStatement(sql3);
            stm3.executeUpdate();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Total model) {

        try {
            String sql = "DELETE FROM [Total]\n"
                    + "      WHERE [tID]= ?";

            PreparedStatement stm = connection.prepareStatement(sql);

            stm.setInt(1, model.gettID());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void main(String[] args) {
        TotalDBContext tdb = new TotalDBContext();
        tdb.action();

    }
}
