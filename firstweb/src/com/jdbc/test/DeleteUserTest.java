package com.jdbc.test;

import com.jdbc.test.dao.UsersDao;

public class DeleteUserTest {
    public static void main(String[] args) {
        UsersDao usersDao = new UsersDao();
        boolean b = usersDao.delete(6);
        System.out.println(b);
    }

}
