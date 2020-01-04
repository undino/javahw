package org.itstep.Databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.lang.Class.forName;

public class StoreDbConnection {
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/Store?serverTimezone=Europe/Kiev&characterEncoding=utf8";
    private static final String DB_LOGIN = "root";
    private static final String DB_PASSWORD = "";

   public Connection getConnection() {

        Connection connection = null;

        try {
            forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_LOGIN, DB_PASSWORD);

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }

        return connection;
    }


}
