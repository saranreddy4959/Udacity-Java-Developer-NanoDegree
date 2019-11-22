package com.udacity.course3.lesson1.exercise1.exercise1;


import org.flywaydb.core.Flyway;

import java.sql.*;

public class Application {

    public static void main(String[] args) {
        // STEP 1: Create the JDBC URL for JDND-C3 database

        // STEP 2: Setup and Run Flyway migration that creates the member table using its Java API
        // https://flywaydb.org/getstarted/firststeps/api#integrating-flyway
        // Note the above link talks about connecting to H2 database, for this exercise, MySQL is used. Adapt the code accordingly.
        Flyway flyway = Flyway.configure().dataSource("jdbc:mysql://localhost/JDND?serverTimezone=UTC&useSSL=false", "root", "pass").load();
        flyway.migrate();
        flyway.baseline();

        // STEP 3: Obtain a connection to the JDND-C3 database

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/JDND?user=root&password=pass")) {
            System.out.println("Connected to: "+con.getMetaData().getDatabaseProductName());

            try(PreparedStatement stmt = con.prepareStatement("INSERT into Employee (ID,NAME) VALUES (?,?)")){
                stmt.setInt(1,1);
                stmt.setString(2,"Saran");

                stmt.executeUpdate();

                ResultSet rs = stmt.executeQuery("select * from Employee");

                System.out.println("Executed sql query");

                while(rs.next()){
                    int id = rs.getInt("id");
                    String name = rs.getString("name");

                    System.out.println("ID: "+id);
                    System.out.println("name: "+name);
                }
            }

        }catch(SQLException ex){
            System.out.println("SQLExceptionn: "+ex.getMessage());
            System.out.println("SQLState: "+ex.getSQLState());
            System.out.println("VendorError: "+ex.getErrorCode());

        }
    }

        // STEP 4: Use Statement to INSERT 2 records into the member table
        // NOTE: The member table is created using Flyway by placing the migration file in src/main/resources/db/migration



        // STEP 5: Read ALL the rows from the member table and print them here


        // STEP 6: verify that all inserted rows have been printed
    }

