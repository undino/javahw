package org.itstep;

import org.itstep.models.ToDo;
import org.itstep.models.ToDoForAdd;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        ToDoForAdd toDo = new ToDoForAdd("test title", "test description", "top", false);
        System.out.println(toDo);
        System.out.println(LocalDateTime.now());
    }
}
