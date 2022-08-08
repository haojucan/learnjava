package com.jdbc.test.utils;

import java.sql.*;

//数据库相关操作的工具类

public class JDBCUtils {
    //加载驱动，并建立数据库连接
    public static Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String username = "root";
        String password = "Axu19870318..";
        return DriverManager.getConnection(url, username, password);
    }

    //关闭数据库连接，释放资源
    public static void release(PreparedStatement  preStmt, Connection conn) {
        if (preStmt != null) {
            try {
                preStmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            preStmt = null;
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            conn = null;
        }
    }

    public static void release(ResultSet rs, PreparedStatement preStmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            rs = null;
        }
        release(preStmt, conn);
    }
}
