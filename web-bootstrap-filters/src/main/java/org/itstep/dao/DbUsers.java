package org.itstep.dao;

import org.itstep.entity.User;

import java.util.ArrayList;
import java.util.List;

public class DbUsers {
    private static List<User> userList = new ArrayList<>();

    public void addUser(User user) {
        if (!findUser(user)) userList.add(user);
        System.out.println("ALL USERS");
        userList.forEach(System.out::println);
    }

    public boolean findUser(User user) {
        return userList.contains(user);
    }

    public User getUser(User user) {
        if (findUser(user)) {
            return userList.get(userList.indexOf(user));
        }
        return null;
    }

}
