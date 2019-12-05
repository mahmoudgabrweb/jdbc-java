package Config;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author mahmoudgabr
 */
public class DBConnection {
    
    Connection connection = null;
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/java_test";
    String dbUser = "root";
    String dbPass = "root1234";
    
    public Connection getConnection() {
        
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, dbUser, dbPass);
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
        
        return connection;
    }
    
}
