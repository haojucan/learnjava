package com.DBUtils.test;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.Properties;

public class BasicDataSourceFactoryTest {
    public static DataSource ds = null;

    static {
        //新建一个配置文件
        Properties prop = new Properties();
        //把文件输入流的形式找到路径，读取配置文件
        try {
            InputStream in = BasicDataSourceFactoryTest.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
            //把文件以输入流的形式加载到配置对象中
            prop.load(in);
            //创建数据源对象
            try {
                ds = BasicDataSourceFactory.createDataSource(prop);

            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {

        try {
            //获取数据库连接对象
            Connection conn = ds.getConnection();
            //获取数据库连接信息
            DatabaseMetaData metaData = conn.getMetaData();
            //数印数库连接信息
            System.out.println(metaData.getURL()+",UserName="+metaData.getUserName()+","+metaData.getDriverName());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
