package org.itstep.Databases;

import org.itstep.Entity.Customer;
import org.itstep.Entity.Product;
import org.itstep.Entity.Seller;
import org.itstep.Servlets.DynamicPageResponse;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SellerDb extends StoreDbConnection {
    Connection connection = getConnection(); // когда соединение закрывается?
    private static final String INSERT_SELLER = "INSERT INTO sellers(login, password, role_id) values(?, ?, ?)";
    private static final String SELECT_SELLER = "SELECT id, login, password, cash FROM sellers WHERE login=? and password=?";
    private static final String PRODUCTS_OF_SELLER = "select products.type, products.title, products.quantity, products.price\n"
            + "from products \n" + "join sellers  on products.seller_id = sellers.id\n" + "where sellers.login = ?;";
    private static final String ADD_PRODUCTS = "insert products (type, title, quantity, price, seller_id) values (?, ?, ?, ?, ?)";
    private static final String GET_SELLER = "select login, password from sellers where id = ?";

    public void add(Seller seller) {

        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SELLER)) {
            preparedStatement.setString(1, seller.getLogin());
            preparedStatement.setString(2, seller.getPassword());
            preparedStatement.setInt(3, 1);
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

    public boolean find(Seller seller) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SELLER);
            preparedStatement.setString(1, seller.getLogin());
            preparedStatement.setString(2, seller.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Map getDate(Seller seller) {
        Map map = new HashMap();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SELLER);
            preparedStatement.setString(1, seller.getLogin());
            preparedStatement.setString(2, seller.getPassword());
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

    public List<String> getProducts(Seller seller) {
        List<String> listProsucts = new ArrayList<>();
        String result = "";
        try (PreparedStatement preparedStatement = connection.prepareStatement(PRODUCTS_OF_SELLER)) {
            preparedStatement.setString(1, seller.getLogin());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                if (resultSet.getInt("quantity") > 0) {
                    result += resultSet.getString("type") + " | ";
                    result += resultSet.getString("title") + " | ";
                    result += resultSet.getString("quantity") + " | ";
                    result += resultSet.getString("price");
                    listProsucts.add(result);
                    result = "";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listProsucts;
    }

    public String addProducts(Product product) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(ADD_PRODUCTS)) {
            preparedStatement.setString(1, product.getType());
            preparedStatement.setString(2, product.getTitle());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setDouble(4, product.getPrice());
            preparedStatement.setInt(5, product.getSellerId());
            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                DynamicPageResponse dynamicPageResponse = new DynamicPageResponse();
                PreparedStatement preparedStatement1 = connection.prepareStatement(GET_SELLER);
                preparedStatement1.setInt(1, product.getSellerId());
                ResultSet resultSet = preparedStatement1.executeQuery();
                String login = "";
                String password = "";
                while (resultSet.next()) {
                    login = resultSet.getString("login");
                    password = resultSet.getString("password");
                }

                return dynamicPageResponse.sellerPage(new Seller(login, password));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "false";
    }

}
