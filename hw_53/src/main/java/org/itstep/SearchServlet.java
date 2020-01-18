package org.itstep;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Random;

/*
1. Сгенерировать в таблице person 100_000 записей +
2. Добавить сервлет SearchServlet, который привязать к конеченой точке search +
3. В сервлете переопределить метод doGet. Добавить параметры first_name, last_name в которые
передавать соответсвенно имя и/или фамилию -
4. В методе doGet выполнить заспрос и вывести в ответ количество людей соответсвующих запросу, 
а также время затраченное на этот запрос ?
5. Добавить индекc в first_name и проанализировать как изменилась скорость запроса в бд ?
*/

public class SearchServlet extends HttpServlet {
    String url;
    String user;
    String password;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    static final Random random = new Random();
    String stingRequest = "";
    static String[] firstName = { "Dima", "Sasha", "Olya", "Petya", "Lena", "Marina" };
    static String[] lastName = { "Frolova", "Danilov", "Venchaev", "Govorov" };
    static String[] gender = { "male", "female", "unknown" };

    public static final String INSERT = "insert into person(first_name, last_name, gender) values(?,?,?)";
    public static final String SELECT = "select count(first_name) Lena from person where first_name = 'Lena'";
    public static final String INDEX = "create index index_person_first_name on people.person(first_name)";
    public static final String SELECT_PAST_INDEX = "select count(first_name) Lena from person where first_name = 'Lena'";
    public static final String CREATE_TABLE = "create table person(" + "id int primary key auto_increment,"
            + "first_name varchar(50) not null," + "last_name varchar(50) not null,"
            + "gender set('male', 'female', 'unknown') not null" + ")";

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        url = getServletContext().getInitParameter("db:url");
        user = getServletContext().getInitParameter("db:user");
        password = getServletContext().getInitParameter("db:password");

        createTable();

        int i = 100_000;
        while (i > 0) {
            initDb();
            i--;
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();

        String firstName = req.getParameter("first_name");
        String lastName = req.getParameter("last_name");

        timePeriodRequest(firstName, lastName);
        writer.println(stingRequest);
    }

    String generaFirstName() {
        return firstName[random.nextInt(firstName.length)];
    }

    String generaLastName() {
        return lastName[random.nextInt(lastName.length)];
    }

    String generaGender() {
        return gender[random.nextInt(gender.length)];
    }

    private void createTable() {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_TABLE);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void initDb() {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, generaFirstName());
            preparedStatement.setString(2, generaLastName());
            preparedStatement.setString(3, generaGender());
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void timePeriodRequest(String firstName, String lastName) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            long startTime = System.currentTimeMillis();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT); // запрос должен выполняться с
                                                                                       // указанными firstName &&
                                                                                       // lastName
            ResultSet resultSet = preparedStatement.executeQuery();
            long endTime = System.currentTimeMillis();

            int resultSelect = 0;
            if (resultSet.next()) {
                resultSelect = resultSet.getInt(1);
            }

            stingRequest += "<p>Select before indexing = " + (endTime - startTime)
                    + ".ms. Where result count first_name Lena = " + resultSelect + "</p>";

            preparedStatement = connection.prepareStatement(INDEX); // индексацию нужно делать отдельно - не в сервлете
            preparedStatement.executeUpdate();

            startTime = System.currentTimeMillis();
            preparedStatement = connection.prepareStatement(SELECT_PAST_INDEX);
            resultSet = preparedStatement.executeQuery();
            endTime = System.currentTimeMillis();

            while (resultSet.next()) {
                resultSelect = resultSet.getInt(1);
            }

            stingRequest += "<p>Select after indexing = " + (endTime - startTime)
                    + ".ms. Where result count first_name Lena = " + resultSelect + "</p>";

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
