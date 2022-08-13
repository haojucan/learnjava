package com.C3P0Untils.test;

import com.jdbcutils.test.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;


public class DBUtilsDao {
    //find all return set
    public List<User> findAll() throws SQLException {
        //build QueryRunner object
        QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
        //SQL

        String sql = "select * from User";
        return runner.query(sql, new BeanListHandler<>(User.class));
    }

    //find single return object
    public User find(int id) throws SQLException {
        QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select  * from user  where id =?";
        return (User) runner.query(sql, new BeanHandler<>(User.class), new Object[]{id});

    }

    //insert user
    public Boolean insert(User user) throws SQLException {
        //build QueryRunner object
        QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "insert into user (name,password) values(?,?)";

        int num = runner.update(sql, user.getName(), user.getPassword());
        return num > 0;
    }

    public Boolean update(User user) throws Exception {
        QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "update  user set name=?,password=? where id=?";
        int num = runner.update(sql, user.getName(), user.getPassword(), user.getId());
        return num > 0;
    }

    //delete User

    public boolean delete(int id) throws SQLException {
        QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "delete from user where id=?";
        int num = runner.update(sql, id);
        return num > 0;
    }
}
