package com.jdbc.test.dao;

import com.jdbc.test.User;
import com.jdbc.test.utils.JDBCUtils;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class UsersDao {
    //添加用户的操作
    public boolean insert(User user) {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement preStmt = null;
        try {
            //获取数据库连接
            conn = JDBCUtils.getConnection();
            String SQL = "INSERT INTO users(name,password,email,birthday) VALUES(?,?,?,?)";
            preStmt = conn.prepareStatement(SQL);
            SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
            String birthday = sdf.format(user.getBirthday());
            preStmt.setString(1, user.getUsername());
            preStmt.setString(2, user.getPassword());
            preStmt.setString(3, user.getEmail());
            preStmt.setString(4, birthday);
            int num = preStmt.executeUpdate();
            return num > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.release(preStmt, conn);
        }

    }

    // 查询所有的User对象
    public ArrayList<User> findAll() {
        Connection conn = null;
        PreparedStatement preStmt = null;
        ResultSet rs = null;
        ArrayList<User> list = new ArrayList<User>();

        try {
            // 获得数据库连接
            conn = JDBCUtils.getConnection();
            //获取Statement 对象

            // 发送SQL语句
            String sql = "SELECT * FROM users";
            preStmt = conn.prepareStatement(sql);
            rs = preStmt.executeQuery();
            //处理结果集
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setBirthday(rs.getDate("birthday"));
                list.add(user);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.release(rs, preStmt, conn);
        }

    }

    //根据id 查找指定user
    public User find(int id) {
        Connection conn = null;
        PreparedStatement preStmt = null;
        ResultSet rs = null;
        //获得数据库连接
        try {
            conn = JDBCUtils.getConnection();
            //获得Statement 对象
            String SQL = "SELECT * FROM users WHERE id =?";
            preStmt = conn.prepareStatement(SQL);
            preStmt.setInt(1, id);
            //处理结果集
            rs = preStmt.executeQuery();
            User user = new User();
            while (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setBirthday(rs.getDate("birthday"));
                return user;
            }
            return null;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.release(rs, preStmt, conn);
        }

    }

    public boolean delete(int id) {
        Connection conn = null;
        PreparedStatement preStmt = null;
        //获取数据连接
        try {
            conn = JDBCUtils.getConnection();
            String SQL = "DELETE FROM users WHERE id=?";
            preStmt = conn.prepareStatement(SQL);
            preStmt.setInt(1, id);
            int num = preStmt.executeUpdate();
            return num > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.release(preStmt, conn);
        }
    }

    //修改用户信息
    public boolean update(User user) {
        Connection conn = null;
        PreparedStatement preStmt = null;
        try {
            conn = JDBCUtils.getConnection();
            SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
            String birthday = dft.format(user.getBirthday());
            String SQL = "UPDATE users set name=?,password=?,email=?,birthday=? WHERE id=?";
            preStmt = conn.prepareStatement(SQL);
            preStmt.setString(1, user.getUsername());
            preStmt.setString(2, user.getPassword());
            preStmt.setString(3, user.getEmail());
            preStmt.setString(4, birthday);
            preStmt.setInt(5, user.getId());
            int num = preStmt.executeUpdate();
            return num > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.release(preStmt, conn);
        }
    }
}
