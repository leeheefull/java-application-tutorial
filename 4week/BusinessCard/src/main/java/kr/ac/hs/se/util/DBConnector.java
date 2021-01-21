package kr.ac.hs.se.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {

        String driver = "com.mysql.cj.jdbc.Driver";
        Class.forName(driver);

        String url = "jdbc:mysql://localhost:3306/tutoring?serverTimezone=UTC";
        String user = "root";
        String password = "2277";

        return DriverManager.getConnection(url, user, password);
    }
}
