package com.C3P0Untils.test;

import com.jdbc.test.User;
import com.jdbcutils.test.BaseDao;
import org.apache.commons.dbutils.QueryRunner;
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
    public User find() throws SQLException {
        QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select  * from user  where id =?";
        return (User) runner.query(sql, new BeanListHandler<>(User.class));

    }

    //insert user
    public Boolean insert(User user) throws SQLException {
        //build QueryRunner object
        QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "insert into user (name,password) values(?,?)";

        int num = runner.update(sql, new Object[]{user.getUsername(), user.getPassword()});
        return num > 0;
    }

        public Boolean update(User user)throws  Exception {
        
        }
}
