import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCPrimer {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/JDND?user=root&password=pass")) {
                System.out.println("Connected to: "+con.getMetaData().getDatabaseProductName());

    } catch(SQLException ex){
            System.out.println("SQLExceptionn: "+ex.getMessage());
            System.out.println("SQLState: "+ex.getSQLState());
            System.out.println("VendorError: "+ex.getErrorCode());

        }
    }
}