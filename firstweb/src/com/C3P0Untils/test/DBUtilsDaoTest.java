package com.C3P0Untils.test;


import com.jdbcutils.test.User;

import java.sql.SQLException;

public class DBUtilsDaoTest {
    private static final DBUtilsDao dao = new DBUtilsDao();

    public static void main(String[] args) {
        User user = new User();
        user.setName("wxc");
        user.setPassword("12345");
        try {
            boolean b = dao.insert(user);
            System.out.println(b);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
