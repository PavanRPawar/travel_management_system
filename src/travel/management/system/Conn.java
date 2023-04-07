package travel.management.system;

import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;
    
    Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///travelmanagementsystem", "root", "pavan");
            s = c.createStatement();
        } catch(Exception e) {
            e.printStackTrace();
        }
    } 
}

// 5 Steps of Java Database Connectivity (JDBC)
// 1 - Register the Driver class
// 2 - Creating connection string
// 3 - Creating the statement
// 4 - Executing MYSQL Queries
// 5 - Closing the connections (optional)