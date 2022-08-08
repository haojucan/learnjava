package com.jdbc.test;

import com.jdbc.test.dao.UsersDao;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JDBCInsertTest {
    public static void main(String[] args) {
        UsersDao uid = new UsersDao();
        User user = new User();
        user.setId(6);
        user.setUsername("h21");
        user.setPassword("1240");
        user.setEmail("led@sina.com");
        user.setBirthday(new Date());
        System.out.println(user.getUsername());
        Boolean b = uid.insert(user);
        System.out.println(b);
    }
}
