package org.itstep.dao;

import org.itstep.domain.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends GenericDao<User> {

    private static final String INSERT = "INSERT INTO users(login, password) VALUES(?, ?)";
    private static final String SELECT = "SELECT id, login, password from users";
    private static final String DELETE = "DELETE FROM users WHERE login = ? and password = ?";
    private static final String UPDATE = "UPDATE users SET login = ? and password = ? WHERE "; // where что?

    public UserDao(String connectionString, String user, String password) throws SQLException {
        super(connectionString, user, password);
    }

    @Override
    public void save(User data) {
        try {
            startTransaction();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, data.getLogin());
            preparedStatement.setString(2, data.getPassword());
            preparedStatement.execute();
            commit();
        } catch (SQLException e) {
            try {
                rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<User> findAll() {
        List<User> listUser = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                listUser.add(new User(id, login, password));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listUser;
    }

    @Override
    public void update(User data) {
        // транзакции???
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setString(1, data.getLogin());
            preparedStatement.setString(2, data.getPassword());
            preparedStatement.setString(3, "newLogin");
            preparedStatement.setString(4, "newPassword");
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(User data) {
        // транзакции???
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {
            preparedStatement.setString(1, data.getLogin());
            preparedStatement.setString(2, data.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
