package com.jdbcutils.test;

import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
    public static Object query(String sql, ResultSetHandler<?> rsh, Object... params) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Object obj = null;
        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            for (int i = 0; params != null && i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            //send SQL
            rs = pstmt.executeQuery();
            obj = rsh.handle(rs);
        } catch (Exception e) {
            return new Exception(e.getMessage());
        } finally {
            JDBCUtils.release(rs, pstmt, conn);
        }
        return obj;
    }
}
