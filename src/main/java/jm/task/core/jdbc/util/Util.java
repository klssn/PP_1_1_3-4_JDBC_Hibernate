package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private final static String url = "jdbc:mysql://localhost:3306/db";
    private final static String user = "user";
    private final static String pw = "root";

    public static Connection getConnection () {
        try {
            return DriverManager.getConnection(url, user, pw);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
