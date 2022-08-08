package com.jdbc.test;

import com.jdbc.test.dao.UsersDao;


public class FindUserByIdTest {
    
    public static void main(String[] args) {
        UsersDao usersDao = new UsersDao();
        User user = usersDao.find(4);
        System.out.printf("id=%d,name=%s,email=%s%n",user.getId(),user.getUsername(),user.getEmail());
    }
}
