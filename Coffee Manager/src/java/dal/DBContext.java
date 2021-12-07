package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.BaseModel;

/**
 *
 * @author Sap-lap
 * @param <T>
 */
public abstract class DBContext<T extends BaseModel> {
    protected Connection connection;
    public DBContext()
    {
        try {
            String username = "sa";
            String password = "sa";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Coffee_manager";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    
    public abstract ArrayList<T> list();
    public abstract T get(T model);
    public abstract void insert(T model);
    public abstract void update(T model);
    public abstract void delete(T model);
    
}
