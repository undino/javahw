package org.itstep;

import org.itstep.db.ToDoDao;
import org.itstep.entity.ToDo;

import java.sql.SQLException;
import java.util.Queue;


public class Into {
    public static void main(String[] args) throws SQLException {
        ToDoDao td = new ToDoDao("jdbc:mysql://localhost:3306/todo?characterEncoding=utf8", "root", "");
        Queue<ToDo> q = td.getAll();
        while (q.size() != 0)
            System.out.println(q.poll());
    }
}
