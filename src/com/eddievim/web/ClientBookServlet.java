package com.eddievim.web;

import com.eddievim.pojo.Book;
import com.eddievim.pojo.Page;
import com.eddievim.service.BookService;
import com.eddievim.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientBookServlet extends BaseServlet{
    BookService bookService = new BookServiceImpl();


    protected void page (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println("through clientServlet");
        //1 获取请求的参数（网站请求pageNo 与 pageSize）
        int pageNO = req.getParameter("pageNO") == null ? 1 : Integer.parseInt(req.getParameter("pageNO"));
        int pageSize = req.getParameter("pageSize") == null ? Page.PAGE_SIZE : Integer.parseInt(req.getParameter("pageSize"));
        //2 Service分页查询 return（page<Book>）
        Page<Book> page = bookService.pageBook(pageNO, pageSize);

        page.setUrl("client/bookServlet?action=page");
        //3 保存Page对象到request域中（返回给页面）
        req.setAttribute("page", page);
        //4 请求转发回页面
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }

    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1 获取请求的参数（网站请求pageNo 与 pageSize）
        int pageNO = req.getParameter("pageNO") == null ? 1 : Integer.parseInt(req.getParameter("pageNO"));
        int pageSize = req.getParameter("pageSize") == null ? Page.PAGE_SIZE : Integer.parseInt(req.getParameter("pageSize"));
        int min = req.getParameter("min") == null ? 0 : Integer.parseInt(req.getParameter("min"));
        int max = req.getParameter("max") == null ? Integer.MAX_VALUE : Integer.parseInt(req.getParameter("max"));

        //2 Service分页查询 return（page<Book>）
        Page<Book> page = bookService.pageByPrice(pageNO, pageSize, min, max);

        StringBuilder sb = new StringBuilder("client/bookServlet?action=pageByPrice");

        if(req.getParameter("min") != null) {
            sb.append("&min=").append(req.getParameter("min"));
        }

        if(req.getParameter("max") != null) {
            sb.append("&max=").append(req.getParameter("max"));
        }

        page.setUrl(sb.toString());
        //3 保存Page对象到request域中（返回给页面）
        req.setAttribute("page", page);
        //4 请求转发回页面
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }
}
