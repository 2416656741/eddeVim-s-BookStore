package com.eddievim.dao.impl;

import com.eddievim.dao.UserDao;
import com.eddievim.pojo.User;

public class UserDaoImpl extends BaseDao implements UserDao {


    @Override
    public User queryUserByUsername(String username) {
        String sql = "select * from t_user where username = ?";
        return queryForOne(User.class, sql, username);
    }

    @Override
    public User queryUserByUsernameAndPwd(String username, String password) {
        String sql = "select * from t_user where username = ? and password = ?";
        return queryForOne(User.class, sql, username,password);
    }

    @Override
    public int SaveUser(User user) {
        String sql = "insert into t_user(username, password, email) values(?,?,?)";
        return update(sql, user.getUsername(), user.getPassword(), user.getEmail());
    }
}
