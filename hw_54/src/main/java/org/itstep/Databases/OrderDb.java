package org.itstep.Databases;

import org.itstep.Entity.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderDb extends StoreDbConnection {
    Connection connection = getConnection(); // когда соединение закрывается?
    private final String MADE_ORDER = "insert orders(customer_id, seller_id, product_id) values (?, ?, ?)";

    public void madeOrder(Order order) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(MADE_ORDER)) {
            preparedStatement.setInt(1, order.getCustomerId());
            preparedStatement.setInt(2, order.getSellerId());
            preparedStatement.setInt(3, order.getProductId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
