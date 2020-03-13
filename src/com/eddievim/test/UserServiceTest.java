package com.eddievim.test;

import com.eddievim.pojo.User;
import com.eddievim.service.UserService;
import com.eddievim.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {

    UserService userService = new UserServiceImpl();

    @Test
    public void registUser() {
        userService.registUser(new User(null, "prime", "666666","pr@qq.com"));
    }

    @Test
    public void login() {
        if(userService.login(new User(null,"admin", "admi", "~~~")) != null){
            System.out.println("OK");
        } else {
            System.out.println("NOT OK");
        }
    }

    @Test
    public void existsUsername() {
        if(userService.existsUsername("admin")) {
            System.out.println("用户名已经存在");
        } else {
            System.out.println("用户名可用");
        }
    }
}