package com.eddievim.web;

import com.eddievim.pojo.Book;
import com.eddievim.pojo.Cart;
import com.eddievim.pojo.CartItem;
import com.eddievim.service.BookService;
import com.eddievim.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;

import static javax.swing.text.html.CSS.getAttribute;

public class CartServlet extends BaseServlet {
    BookService bookService = new BookServiceImpl();
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 获取参数
        int id = req.getParameter("id") == null ?  0 : Integer.parseInt(req.getParameter("id"));

        //2 创建项
        Book book = bookService.queryBookById(id);
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1,book.getPrice(), book.getPrice());

        //3 添加到session中的购物车
        //获取session
        HttpSession session = req.getSession();

        //没有购物车就创建
        if(session.getAttribute("cart") == null) {
            session.setAttribute("cart", new Cart());
        }

        session.setAttribute("lastItem", cartItem.getName());

        //添加进购物车
        Cart cart = (Cart) session.getAttribute("cart");
        cart.addItem(cartItem);

        //session.setAttribute("cart", cart);

        //4 重定向防止刷新导致重复添加购物车
        //resp.sendRedirect(req.getContextPath()+"/index.jsp");

        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void removeItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 获取参数id
        int id = req.getParameter("id") == null ?  0 : Integer.parseInt(req.getParameter("id"));

        //2 获取session中的购物车去删除
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        cart.removeItem(id);

        //session.setAttribute("cart", cart);

        //3 重定向
        resp.sendRedirect(req.getHeader("Referer"));
        //req.getRequestDispatcher("pages/cart/cart.jsp").forward(req, resp);
    }

    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 获取session中的购物车
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        //2 调用方法清空购物车
        cart.clear();
        //3 重定向
        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("updateCount");
        //1 获取参数
        int id = req.getParameter("id") == null ?  0 : Integer.parseInt(req.getParameter("id"));
        int count = req.getParameter("count") == null ?  1 : Integer.parseInt(req.getParameter("count"));

        //2 获取session购物车对象
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        //3 调用api
        cart.updateCount(id, count);

        //4 重定向
        resp.sendRedirect(req.getHeader("Referer"));
    }
}
