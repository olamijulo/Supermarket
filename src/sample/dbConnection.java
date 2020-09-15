package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {
    public static Connection getConnection() throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:sqlite:C:/Users/Olamijulo/Supermarket.db");
        return con;
    }
}
