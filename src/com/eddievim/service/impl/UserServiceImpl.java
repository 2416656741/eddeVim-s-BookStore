package com.eddievim.service.impl;

import com.eddievim.dao.UserDao;
import com.eddievim.dao.impl.UserDaoImpl;
import com.eddievim.pojo.User;
import com.eddievim.service.UserService;

public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoImpl();

    @Override
    public void registUser(User user) {
        userDao.SaveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPwd(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        return userDao.queryUserByUsername(username) != null;
    }
}
