package com.C3P0Untils.test;

import com.jdbcutils.test.User;

import java.sql.SQLException;

public class DBUtilsDaoTest2 {
    private  static final DBUtilsDao dao = new DBUtilsDao();

    public static void  testupdate() throws SQLException {
        User user = new User();
        user.setName("xjf");
        user.setPassword("xjf123");
        user.setId(4);
        try {
            boolean b = dao.update(user);
            System.out.println(b);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        try {
            testupdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
