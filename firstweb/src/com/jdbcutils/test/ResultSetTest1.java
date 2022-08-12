package com.jdbcutils.test;

import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ResultSetTest1 {

    public static void testBeanHandler() throws SQLException {
//        BaseDao baseDao = BaseDao;
        String sql = "SELECT * from user WHERE id =?";
        //get result list
        Object object = BaseDao.query(sql, new BeanHandler<>(User.class), 1);
        if (object instanceof User ) {
            User user = (User) object;
            System.out.println("1为1的User对象name值为：" + user.getName());
        } else {
            System.out.println("查询结果为空：" + object);
        }
    }

    public static void main(String[] args) {
        try {
            testBeanHandler();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
