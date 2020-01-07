package org.itstep;

import java.sql.*;

public class AppDb {

    private static final StringBuilder responseStr = new StringBuilder("");
    private static final String urlDb = "jdbc:mysql://localhost/cinemadb?serverTimezone=Europe/Kiev&useSSL=false&characterEncoding=UTF-8";
    private static final String userName = "root";
    private static final String passwordDb = "";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public static StringBuilder sqlRequest(int valueOfOption, String requests) {

        String[] strQuery = new String[] { "select * from movies order by title;",
                "select * from movies order by Releaseyear desc;", "select * from movies order by rating desc;",
                "select * from movies where releaseyear = 2018;",
                "select title, genrename from moviegenres\n" + "\tjoin movies on movies.movieid = moviegenres.movieid\n"
                        + "\tjoin genres on genres.genreid = moviegenres.genreid\n" + "\twhere genres.genrename = "
                        + "'" + requests + "'" + ";",
                "select title, concat(firstname ,' ', lastname) as Actor from movieactor\n"
                        + "        join movies on movies.movieid = movieactor.movieid\n"
                        + "        join actors on actors.actorid = movieactor.actorid\n" + "\twhere firstname = " + "'"
                        + requests + "'" + ";",
                "select title from movies\n" + "\tjoin directors on directors.directorid = movies.directorid\n"
                        + "\twhere directors.firstname =" + "'" + requests + "'" + ";" };

        try {
            Connection connection = DriverManager.getConnection(urlDb, userName, passwordDb);
            System.out.println("Connect to db");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(strQuery[valueOfOption - 1]);

            if (valueOfOption < 5) { // Что за магическое число 5?
                return getFilmsSort(resultSet);
            } else {
                return getFilmsByValue(resultSet, valueOfOption);
            }
            // Соединение нужно закрывать!!!
        } catch (Exception ex) {
            System.out.printf("Connect failed....");
            System.out.println(ex);
        }

        return responseStr;
    }

    private static StringBuilder getFilmsSort(ResultSet rs) throws SQLException {
        responseStr.delete(0, responseStr.length());
        responseStr.append("<ol>");
        while (rs.next()) {
            responseStr.append("<li>");
            responseStr.append(rs.getString("title") + " | ");
            responseStr.append(rs.getString("releaseyear") + " | ");
            responseStr.append(rs.getString("rating") + " | ");
            responseStr.append(rs.getString("plot") + " | ");
            responseStr.append(rs.getString("movielength") + " | ");
            responseStr.append("</li>");
        }

        if (responseStr.toString().equals("<ol>"))
            return new StringBuilder("Ничего не найдено по вашему запросу");

        responseStr.append("</ol>");
        return responseStr;
    }

    private static StringBuilder getFilmsByValue(ResultSet rs, int numReq) throws SQLException {
        responseStr.delete(0, responseStr.length());
        responseStr.append("<ol>");
        while (rs.next()) {
            responseStr.append("<li>");
            if (numReq == 5) {
                responseStr.append(rs.getString("title") + " | ");
                responseStr.append(rs.getString("genrename") + " | ");
            } else if (numReq == 6) {
                responseStr.append(rs.getString("title") + " | ");
                responseStr.append(rs.getString("actor") + " | ");
            } else if (numReq == 7) {
                responseStr.append(rs.getString("title") + " | ");
            }
            responseStr.append("</li>");
        }

        if (responseStr.toString().equals("<ol>"))
            return new StringBuilder("Ничего не найдено по вашему запросу");

        responseStr.append("</ol>");
        return responseStr;
    }

}
