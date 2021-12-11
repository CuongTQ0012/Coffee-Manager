/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.logging.Logger;
import model.DrinksDetail;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
