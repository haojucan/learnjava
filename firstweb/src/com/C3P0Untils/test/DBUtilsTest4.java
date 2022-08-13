package com.C3P0Untils.test;

import com.jdbcutils.test.User;

import java.sql.SQLException;

import static java.lang.String.format;

public class DBUtilsTest4 {
    private static final DBUtilsDao dao = new DBUtilsDao();

    public static void findtest() throws SQLException {

        User user = dao.find(2);
        String str = format("ID=%d,name=%s,password=%s", user.getId(), user.getName(), user.getPassword());
        System.out.println(str);

    }

    public static void main(String[] args) {
        try {
            findtest();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
