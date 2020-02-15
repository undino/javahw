package org.itstep.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Queue;

public abstract class DbDao<T> {
    protected Connection connection;

//    static {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }

    public DbDao(String connectionString, String user, String passwprd) throws SQLException {
        connection = DriverManager.getConnection(connectionString, user, passwprd);
    }

    protected void close() throws SQLException {
        connection.close();
    }

    abstract void add(T t);

    abstract T find(T t);

    abstract void remove(T t);

    abstract Queue<T> getAll();

    abstract boolean delete(int id);

    abstract void createDb();
}
