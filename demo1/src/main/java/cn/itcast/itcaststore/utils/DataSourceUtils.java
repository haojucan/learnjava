package cn.itcast.itcaststore.utils;


import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DataSourceUtils {
    private static final DataSource dataSource = new ComboPooledDataSource();
    private static final ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

    public static DataSource getDataSource() {
        return dataSource;
    }

    /* 当DBUtils 需要手动控制事务时，调用该方法获得一个连接
     *@return
     *@throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        Connection conn = tl.get();
        if (conn == null) {
            conn = dataSource.getConnection();
            tl.set(conn);
        }
        return conn;
    }

    /*
     * 开启事务
     * @throws SQLException
     */
    public static void startTransaction() throws SQLException {
        Connection conn = getConnection();
        if (conn != null) {
            conn.setAutoCommit(false);
        }
    }

    /*
     * 从TheadLocal 中释放并且关闭Connection,并结束事务
     * @throws SQLException;
     */
    public static void releaseAndCloseConnection() throws SQLException {
        Connection conn = getConnection();
        if (conn != null) {
            conn.commit();
            tl.remove();
            conn.close();
        }
    }

    /*
     事务回滚动
     @throws SQLException

     */
    public static void rollback() throws SQLException {
        Connection conn = getConnection();
        if (conn != null) {
            conn.rollback();
        }
    }
}
