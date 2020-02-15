package org.itstep.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.PriorityQueue;
import java.util.Queue;

import org.itstep.entity.ToDo;

public class ToDoDao extends DbDao<ToDo> {
    private final String GO_INTO_DB = "use test";
    private final String DELETE_DB = "DROP DATABASE if exists todo";
    private final String CREATE_DB = "CREATE DATABASE todo";
    private final String[] CREATE_TABLES = {"use todo",
                                            "CREATE TABLE Categories\n" +
                                                    "(\n" +
                                                    "    id   int auto_increment primary key,\n" +
                                                    "    name varchar(255)\n" +
                                                    ");",
                                            "CREATE TABLE Status\n" +
                                                    "(\n" +
                                                    "    id   int auto_increment primary key,\n" +
                                                    "    name varchar(255)\n" +
                                                    ");",
                                            "CREATE TABLE todolist\n" +
                                                    "(\n" +
                                                    "    id                int auto_increment primary key,\n" +
                                                    "    short_description varchar(255) not null,\n" +
                                                    "    long_description  text         not null,\n" +
                                                    "    created           timestamp,\n" +
                                                    "    start             date         not null,\n" +
                                                    "    end               date         not null,\n" +
                                                    "    category_id       int          not null,\n" +
                                                    "    status_id         int          not null,\n" +
                                                    "    constraint fk_todo_category foreign key (category_id) references Categories (id),\n" +
                                                    "    constraint fk_todo_status foreign key (status_id) references Status (id)\n" +
                                                    ");",
                                                    "INSERT Status(name) values ('Выполнено'), ('Не выполнено');",
                                                    "INSERT Categories(name) values ('Высокий'), ('Средний'), ('Низкий');"};


    private final String INSERT_TODO = "insert todolist (short_description, long_description, start, end, category_id, status_id) values (?, ?, ?, ?, ?, ?)";
    private final String SELECT_TODO = "SELECT * FROM todolist";
    private final String DELETE_TODO = "DELETE FROM todolist where id = ?";

    public ToDoDao(String connectionString, String user, String passwprd) throws SQLException {
        super(connectionString, user, passwprd);
    }

    @Override
    public void add(ToDo toDo) {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_TODO)) {
            statement.setString(1, toDo.getShortDescription());
            statement.setString(2, toDo.getLongDescription());
            statement.setString(3, toDo.getStart());
            statement.setString(4, toDo.getEnd());
            statement.setInt(5, toDo.getCategoryId());
            statement.setInt(6, toDo.getStatusId());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override

    public ToDo find(ToDo todo) {

        return null;
    }

    @Override
    public void remove(ToDo todo) {

    }

    @Override
    public Queue<ToDo> getAll() {
        Queue<ToDo> queueToDo = new PriorityQueue<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_TODO)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String shortDescription = resultSet.getString("short_description");
                String longDescription = resultSet.getString("long_description");
                String created = resultSet.getString("created");
                String start = resultSet.getString("start");
                String end = resultSet.getString("end");
                int category = resultSet.getInt("category_id");
                int status = resultSet.getInt("status_id");
                queueToDo.add(new ToDo(id, shortDescription, longDescription, created, start, end, category, status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return queueToDo;
    }

    @Override
    public boolean delete(int id) {
        System.out.println("ont into delete");
        int result = 0;
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_TODO)) {
            preparedStatement.setInt(1, id);
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result > 0;
    }

    @Override
    public void createDb() {
        System.out.println("START GO_INTO_DB");
        try (PreparedStatement preparedStatement = connection.prepareStatement(GO_INTO_DB)){
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("START DELETE_DB");
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_DB)) {
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("START CREATE_DB");
        try (PreparedStatement preparedStatement = connection.prepareStatement(CREATE_DB)) {
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("START CREATE_TABLES");
        for (String requests : CREATE_TABLES) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(requests)) {
                preparedStatement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }
}
