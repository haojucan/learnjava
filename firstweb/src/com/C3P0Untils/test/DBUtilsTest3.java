package com.C3P0Untils.test;

import java.sql.SQLException;

public class DBUtilsTest3 {
    private static final DBUtilsDao dao = new DBUtilsDao();

    public static void  testdelete() throws SQLException {
        boolean b = dao.delete(4);
        System.out.println(b);

    }

    public static void main(String[] args) {
        try {
            testdelete();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
