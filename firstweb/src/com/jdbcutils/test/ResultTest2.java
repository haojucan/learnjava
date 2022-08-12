package com.jdbcutils.test;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;

public class ResultTest2 {
    public static  void testBeanListHandler() throws SQLException {
        String sql = "select * from user";
//        Object object = BaseDao.query(sql, new BeanHandler<>(User.class), 1);

        ArrayList<User> users= (ArrayList<User>) BaseDao.query(sql,new BeanListHandler(User.class));
        for (int i = 0; i < users.size() ; i++) {
            System.out.println("第" +(i + 1) + "条数据的username值是：" + users.get(i).getName());
        }

    }

    public static void main(String[] args) throws SQLException {
        testBeanListHandler();
    }
}
