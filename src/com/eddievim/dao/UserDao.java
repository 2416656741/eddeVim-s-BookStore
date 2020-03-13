package com.eddievim.dao;

import com.eddievim.pojo.User;

public interface UserDao {

    /**
     * 查询用户是否存在
     * @param username
     * @return null为不存在
     */
    public User queryUserByUsername(String username);

    /**
     * 查询账号密码是否正确
     * @param username
     * @param password
     * @return
     */
    public User queryUserByUsernameAndPwd(String username,String password);

    /**
     *
     * @param user
     * @return 返回值为-1表示操作失败
     */
    public int SaveUser(User user);


}
