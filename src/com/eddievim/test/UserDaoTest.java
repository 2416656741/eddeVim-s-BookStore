package com.eddievim.test;

import com.eddievim.dao.UserDao;
import com.eddievim.dao.impl.UserDaoImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {

    @Test
    public void queryUserByUsername() {
        UserDao userDao = new UserDaoImpl();
        System.out.println(userDao.queryUserByUsername("a"));
    }

    @Test
    public void queryUserByUsernameAndPwd() {
        UserDao userDao = new UserDaoImpl();
        System.out.println(userDao.queryUserByUsernameAndPwd("admin", "admin"));
    }

    @Test
    public void saveUser() {
    }
}