package com.DBUtils.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

public class C3P0ConfigXmlTest {
    public static DataSource ds = null;

    //init C3P0
    static {
        ComboPooledDataSource cpds = new ComboPooledDataSource("axu");
        ds = cpds;

    }

    public static void main(String[] args) {
        try {
            System.out.println(ds.getConnection());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
