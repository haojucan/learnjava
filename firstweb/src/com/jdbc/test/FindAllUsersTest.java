package com.jdbc.test;

import com.jdbc.test.dao.UsersDao;

import java.util.ArrayList;

public class FindAllUsersTest {
    public static void main(String[] args) {
        UsersDao usersDao = new UsersDao();
        ArrayList<User> list = usersDao.findAll();
        for (User user : list) {
            System.out.println(user.getUsername());
        }
    }
}
