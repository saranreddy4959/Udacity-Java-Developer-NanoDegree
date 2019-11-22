import java.sql.*;

public class JDBC {


    public static void main(String[] args) {

        try {

            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/JDND?user=root&password=pass")) {
                System.out.println("Connected to " + con.getMetaData().getDatabaseProductName());
                Statement st = con.createStatement();
                st.executeUpdate("CREATE TABLE EMPLOYEE (EMP_ID  INTEGER NOT NULL, EMP_NAME VARCHAR(255))");

                PreparedStatement ps = con.prepareStatement("update EMPLOYEE set EMP_NAME = ? where EMP_ID = ?");
                ps.setString(1,"Saran");
                ps.setInt(2,111);
                int rows =ps.executeUpdate();
                System.out.println(rows);
            }

    }catch(SQLException ex){
            System.out.println("SQLExceptionn: "+ex.getMessage());
            System.out.println("SQLState: "+ex.getSQLState());
            System.out.println("VendorError: "+ex.getErrorCode());
        }

    }
}
