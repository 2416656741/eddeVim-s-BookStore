package com.eddievim.web;

import com.eddievim.pojo.Book;
import com.eddievim.pojo.Page;
import com.eddievim.service.BookService;
import com.eddievim.service.impl.BookServiceImpl;
import com.eddievim.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BookServlet extends BaseServlet {

    private BookService bookService = new BookServiceImpl();

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 获取请求参数 封装对象
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        //2 调用service储存
        bookService.addBook(book);
        //3 跳到图书列表页面
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNO="+(req.getParameter("pageNO") == null ? 1 : req.getParameter("pageNO") + 1));
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 获取请求参数
        String id = req.getParameter("id");
        //2 sevice删除
        bookService.DeleteById(Integer.valueOf(id));

        //3 重定向回图书管理页面
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page&pageNO="+req.getParameter("pageNO"));
    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 通过service层查询到全部图书
        List<Book> books = bookService.queryBooks();
        //2 保持到request域中
        req.setAttribute("books", books);
        //3 请求转发到/pages/manager/book_manager.jsp
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }

    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 获取参数
        String id = req.getParameter("id");
        //2 sevice查询数据库
        Book book = bookService.queryBookById(Integer.valueOf(id));
        //3 存到request域中
        req.setAttribute("book",book);
        //4 转发页面
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req, resp);
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 获取参数 封装对象
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        //2 更新book
        bookService.updateBook(book);
        //3 重定向
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNO="+req.getParameter("pageNO"));
    }

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 获取请求的参数（网站请求pageNo 与 pageSize）
        int pageNO = req.getParameter("pageNO") == null ? 1 : Integer.parseInt(req.getParameter("pageNO"));
        int pageSize = req.getParameter("pageSize") == null ? Page.PAGE_SIZE : Integer.parseInt(req.getParameter("pageSize"));

        //2 Service分页查询 return（page<Book>）
        Page<Book> page = bookService.pageBook(pageNO, pageSize);

        page.setUrl("manager/bookServlet?action=page");
        //3 保存Page对象到request域中（返回给页面）
        req.setAttribute("page", page);
        //4 请求转发回页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }
}
