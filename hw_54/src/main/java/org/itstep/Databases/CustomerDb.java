package org.itstep.Databases;

import org.itstep.Entity.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerDb extends StoreDbConnection {

    Connection connection = getConnection(); // когда соединение закрывается?

    private static final String INSERT_CUSTOMER = "INSERT INTO customers(login, password, role_id) values(?, ?, ?)";
    private static final String INSERT_MONEY = "update customers set cash = cash + ? where login=?";
    private static final String SELECT_CUSTOMER = "SELECT id, login, password, cash FROM customers WHERE login=? and password=?";
    private static final String ORDERS_OF_CUSTOMER = "select products.type, products.title, count(*) count from orders\n"
            + "join customers on orders.customer_id = customers.id\n"
            + "join sellers on orders.seller_id = sellers.id\n" + "join products on orders.product_id = products.id\n"
            + "where customers.login = ?\n" + "group by products.title";

    public void add(Customer customer) {

        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER)) {
            preparedStatement.setString(1, customer.getLogin());
            preparedStatement.setString(2, customer.getPassword());
            preparedStatement.setInt(3, 2);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean find(Customer customer) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER);
            preparedStatement.setString(1, customer.getLogin());
            preparedStatement.setString(2, customer.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Map getDate(Customer customer) {
        Map map = new HashMap();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER);
            preparedStatement.setString(1, customer.getLogin());
            preparedStatement.setString(2, customer.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                map.put("id", resultSet.getInt("id"));
                map.put("login", resultSet.getString("login"));
                map.put("password", resultSet.getString("password"));
                map.put("cash", resultSet.getDouble("cash"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }

    public List<String> getOrders(Customer customer) {
        List<String> listOrders = new ArrayList<>();
        String result = "";
        try (PreparedStatement preparedStatement = connection.prepareStatement(ORDERS_OF_CUSTOMER)) {
            preparedStatement.setString(1, customer.getLogin());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                result += resultSet.getString("type") + " | ";
                result += resultSet.getString("title") + " | ";
                result += resultSet.getString("count");
                listOrders.add(result);
                result = "";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listOrders;
    }

    public boolean addMoney(Customer customer, double money) {
        boolean result = false;
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MONEY)) {
            preparedStatement.setDouble(1, money);
            preparedStatement.setString(2, customer.getLogin());
            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
