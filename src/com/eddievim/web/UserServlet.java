package com.eddievim.web;

import com.eddievim.pojo.User;
import com.eddievim.service.UserService;
import com.eddievim.service.impl.UserServiceImpl;
import com.eddievim.utils.WebUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends BaseServlet {

    UserService service = new UserServiceImpl();

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = service.login(new User(null, username, password, null));

        if (user == null) {//失败
            //把错误信息，和回显的表单项信息，保持到Request域中
            req.setAttribute("msg", "用户名或密码错误！");
            req.setAttribute("username", username);
            //跳回登陆界面
            System.out.println("登陆失败");
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        } else {//成功
            System.out.println("登陆成功");
            req.getSession().setAttribute("user", user);
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }
    }

    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();

        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1获取请求参数
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());

        //2检查验证码是否ok
        if (!"abcde".equalsIgnoreCase(code)) {
            //回显错误信息
            req.setAttribute("msg", "验证码错误");
            req.setAttribute("username", username);
            req.setAttribute("email", email);
            //验证码错误
            System.out.println("验证码" + code + "错误");
            //转发
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        } else {
            //3检查用户名是否可用
            if (service.existsUsername(username)) {
                //回显错误信息
                req.setAttribute("msg", "用户名已经存在");
                req.setAttribute("username", username);
                req.setAttribute("email", email);
                //转发
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else {
                //可用
                System.out.println("用户名可用！");

                //保存
                service.registUser(user);
                //跳转成功页面 regist_success.jsp
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }
        }
    }
}
