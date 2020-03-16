package com.eddievim.web;

import com.eddievim.pojo.Cart;
import com.eddievim.pojo.User;
import com.eddievim.service.OrderService;
import com.eddievim.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class OrderServlet extends BaseServlet {
    private OrderService orderService = new OrderServiceImpl();

    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取购物车 用户id 去结算
        HttpSession session =  req.getSession();
        Cart cart = (Cart)session.getAttribute("cart");
        User user = (User)session.getAttribute("user");
        if(user == null) {
            req.getRequestDispatcher("pages/user/login.jsp").forward(req, resp);
            return;
        }
        Integer id = user.getId();

        // 调用Service结算
        String orderId = orderService.createOrder(cart, id);

        session.setAttribute("orderId", orderId);
        //重定向
        resp.sendRedirect(req.getContextPath()+"/pages/cart/checkout.jsp");
    }
}
