package com.eddievim.service;

import com.eddievim.pojo.User;

public interface UserService {

    /**
     * 注册用户
     * @param user
     */
    public void registUser(User user);

    /**
     * 登陆
     * @param user
     * @return 没有用户返回null
     */
    public User login(User user);

    /**
     *
     * @param username
     * @return true存在
     */
    public boolean existsUsername(String username);
}
