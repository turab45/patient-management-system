package patient_management.database;
import java.sql.Connection;
import java.sql.DriverManager;


public class Database {
    private static Connection conn = null;
    
    public static Connection getConnection(){
    
        if(conn == null){
        
            try {
                
                Class.forName("com.mysql.jdbc.Driver");
                conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/patient_management", "root", "root");
            } catch (Exception e) {
                System.out.println("ERROR: "+e.getMessage());
                e.printStackTrace();
            }
            
        }
        return conn;
    }
}
