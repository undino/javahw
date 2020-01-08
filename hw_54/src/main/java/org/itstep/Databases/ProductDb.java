package org.itstep.Databases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.itstep.Entity.Product;

public class ProductDb extends StoreDbConnection {
    Connection connection = getConnection(); // когда соединение закрывается?
    private final String SQL = "INSERT INTO Products(type, title, quantity, price, seller_id) VALUE (?, ?, ?, ?, ?)";
    private final String GET_ALL_PRODUCTS = "SELECT id, type, title, price, seller_id, quantity FROM products";

    public void add(Product product) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            preparedStatement.setString(1, product.getType());
            preparedStatement.setString(2, product.getTitle());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Product> getAllProduct() {
        List<Product> productList = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_PRODUCTS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                if (resultSet.getInt("quantity") > 0) {
                    int id = resultSet.getInt("id");
                    String type = resultSet.getString("type");
                    String title = resultSet.getString("title");
                    double price = resultSet.getDouble("price");
                    int sellerId = resultSet.getInt("seller_id");
                    productList.add(new Product(id, type, title, price, sellerId));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productList;
    }

}
