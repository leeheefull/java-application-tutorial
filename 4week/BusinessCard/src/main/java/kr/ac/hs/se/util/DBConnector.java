package kr.ac.hs.se.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/tutoring?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PW = "2277";

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PW);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
