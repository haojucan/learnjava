package com.DBUtils.test;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public class Example01 {
    /*
     * 什么是数据库连接池
     * 在JDBC编程中，每次创建和断开Connection对象会消耗一定的时间和IO资源。这是因为Java 程序与数据库之间建立
     * 时，数据库端要认证相关信息，并且要为这个链接分配资源，Java 程序则要把代表连接的java.sql.Connection 对象等加载到内存中
     * ，所以建立数据库链接开销很大，尤其是在大量并发访问时。
     * 为了避免频繁的创建数据库链接，数据库连接池技术应运而生。数据库连接负责分配、管理和释放数据库链接，它允许应用程序重复的使用现有的数据库
     * 链接，而不是重新建立。
     *
     * 常用的数的数据有C3P0和DBCP。
     *
     * DBCP数据库链接池（DataBase Connection Pool）的简称。
     *  commons-jdbc.jar
     * 包含所有操作数据库连接信息和数据库连接池初始化信息的方法。并实现了DataSource接口的getConnection()方法。
     * commons-pool.jar
     * 包含两个核心的类，分别是BasicDataSourceFactory和BasicDataSource它们包含获取数据的对象的方法。
     * BasicDataSource类常用方法
     * void setDriverClassName(String DriverClassName); 设置数据库驱动名称
     * void setUrl(String url); 设置数据库连接路径
     * void setUsername(String username); 设置数据库连接帐号
     * void setPassword(String password); 设置数据库连接密码
     * void setInitialSize(int initialSize);设置数据库连接池初始化连接数目
     * void setMaxActive(int maxldle) 设置数据库连接池最大活跃连接数目
     * void setMinldle（int minldle） 设置数据库连接池最小闲置连接数目
     * Connection getConnection() 从连接池获取一个数据库连接
     *
     * v
     *
     *
     */
    public static DataSource ds = null;

    static {
        BasicDataSource bds = new BasicDataSource();
        bds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        bds.setUrl("jdbc:mysql://localhost:3306/jdbc");
        bds.setUsername("root");
        bds.setPassword("Axu19870318..");
        //设置连接池参数
        bds.setInitialSize(5);
        bds.setMaxActive(5);
        ds = bds;


    }

    public static void main(String[] args) {
        try {
            Connection conn = ds.getConnection();
            //获取数据库连接信息
            DatabaseMetaData metaData = conn.getMetaData();
            String  str =String.format("%s,%s",metaData.getURL(),metaData.getUserName());
            System.out.println(str);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
