package org.itstep.Databases;

import org.itstep.Entity.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionDb extends StoreDbConnection {
    Connection connection = getConnection(); // когда соединение закрывается?
    private final String GET_CASH_CUSTOMER = "select cash from customers where id = ?";
    private final String GET_PRICE_PRODUCT = "select price from products where id = ?";
    private final String UPDATE_CASH_CUSTOMER = "update customers set cash = cash - ? where id = ?";
    private final String UPDATE_CASH_SELLER = "update sellers set cash = cash + ? where id = ?";
    private final String UPDATE_QUANTITY_PRODUCT = "update products set quantity = quantity - 1 where id = ?";

    public boolean transactionStore(int customerId, int sellerId, int productId) {
        double cashCustomer;
        double priceProduct;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_CASH_CUSTOMER);
            preparedStatement.setInt(1, customerId);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            cashCustomer = resultSet.getDouble("cash");

            preparedStatement = connection.prepareStatement(GET_PRICE_PRODUCT);
            preparedStatement.setInt(1, productId);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            priceProduct = resultSet.getDouble("price");

            if (cashCustomer >= priceProduct) {
                connection.setAutoCommit(false);
                preparedStatement = connection.prepareStatement(UPDATE_CASH_CUSTOMER);
                preparedStatement.setDouble(1, priceProduct);
                preparedStatement.setInt(2, customerId);
                preparedStatement.executeUpdate();

                preparedStatement = connection.prepareStatement(UPDATE_CASH_SELLER);
                preparedStatement.setDouble(1, priceProduct);
                preparedStatement.setInt(2, sellerId);
                preparedStatement.executeUpdate();

                preparedStatement = connection.prepareStatement(UPDATE_QUANTITY_PRODUCT);
                preparedStatement.setInt(1, productId);
                preparedStatement.executeUpdate();

                connection.commit();
                Order order = new Order(customerId, sellerId, productId);
                OrderDb orderDb = new OrderDb();
                orderDb.madeOrder(order);

            } else {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}
