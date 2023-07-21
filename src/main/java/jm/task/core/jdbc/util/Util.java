package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private final static String url = "jdbc:mysql://localhost:3306/db";
    private final static String user = "user";
    private final static String pw = "root";
    private static SessionFactory sessionFactory;

    public static Connection getConnection () {
        try {
            return DriverManager.getConnection(url, user, pw);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static SessionFactory getSessionFactory () {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/db");
                configuration.setProperty("hibernate.connection.username", "user");
                configuration.setProperty("hibernate.connection.password", "root");

                configuration.addAnnotatedClass(jm.task.core.jdbc.model.User.class);
                sessionFactory = configuration.buildSessionFactory();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
