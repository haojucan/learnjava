package com.JavaBean.test;

import java.util.HashMap;

public class DBUtil {
    private static final DBUtil instance = new DBUtil();
    //定义users集合，用于模拟数据库
    private final HashMap<String, UserBean> users = new HashMap<String, UserBean>();

    private DBUtil() {
        UserBean user1 = new UserBean();
        user1.setName("Jack");
        user1.setPassword("Jack123");
        user1.setEmail("jack@gm.com");
        users.put("Jack", user1);
        UserBean user2 = new UserBean();
        user2.setName("Tom");
        user2.setPassword("Tom134");
        user2.setEmail("tom@g123.com");
        users.put("Tom", user2);
    }

    public static DBUtil getInstance() {
        return instance;
    }

    public UserBean getUser(String userName) {
        return (UserBean) users.get(userName);
    }

    public boolean insertUser(UserBean user) {
        if (user == null) {
            return false;
        }
        String userName = user.getName();
        if (users.get(userName) != null) {
            return false;
        }
        users.put(userName, user);
        return true;
    }

}
