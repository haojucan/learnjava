package com.jdbcutils.test;

import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;

public class ResultTest3 {
    public static void testScalarHandler() throws SQLException{
        String sql = "select * from user where id=?";
        Object arr = BaseDao.query(sql, new ScalarHandler<>("name"),1);
        System.out.println(arr);
    }
    public static void main(String[] args) {
        try {
            testScalarHandler();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
