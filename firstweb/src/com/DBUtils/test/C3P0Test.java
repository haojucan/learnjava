package com.DBUtils.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.SQLException;

/**
 * C3P0数据源
 * C3P0 是目前最流行的开源数据库连接池之一。
 * C3P0中的DataSource接口的实现类是ComboPooledDataSource() 这是C3P0的核心类，
 * 提供了数据对象的相关方法
 */
public class C3P0Test {
    public static DataSource ds = null;

    //init C3P0
    static {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        try {
            cpds.setDriverClass("com.mysql.cj.jdbc.Driver");
            cpds.setJdbcUrl("jdbc:mysql://localhost:3306/jdbc");
            cpds.setUser("root");
            cpds.setPassword("Axu19870318..");
            //set 连接池的参数
            cpds.setInitialPoolSize(5);
            cpds.setMaxPoolSize(15);
            ds = cpds;
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println(ds.getConnection());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
