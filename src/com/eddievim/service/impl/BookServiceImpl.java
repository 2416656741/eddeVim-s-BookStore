package com.eddievim.service.impl;

import com.eddievim.dao.BookDao;
import com.eddievim.dao.impl.BookDaoImpl;
import com.eddievim.pojo.Book;
import com.eddievim.pojo.Page;
import com.eddievim.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

    BookDao bookDao = new BookDaoImpl();
    @Override
    public int addBook(Book book) {
        return bookDao.addBook(book);
    }

    @Override
    public int DeleteById(Integer id) {
        return bookDao.DeleteById(id);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public int updateBook(Book book) {
        return bookDao.updateBook(book);
    }

    @Override
    public Page<Book> pageBook(int pageNO, int pageSize) {
        Page<Book> page = new Page<>();
        //设置基本情况 ： 页码数， 每页的数量

        page.setPageSize(pageSize);

        //总记录数
        int countsBook = bookDao.countsBook();
        page.setPageTotalCount(countsBook);

        //总页码
        int pageTotal = countsBook / pageSize + (countsBook % pageSize == 0 ? 0 : 1);
        page.setPageTotal(pageTotal);

        page.setPageNO(pageNO);

        //当前页面的开始索引
        int begin = (page.getPageNO() - 1) * pageSize;
        //当前页面的所有书本信息
        List<Book> books = bookDao.pageBook(begin, pageSize);
        page.setItems(books);

        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNO, int pageSize, int min, int max) {
        Page<Book> page = new Page<>();

        // 查询到价格区间的总记录数
        int pageTotalCount = bookDao.countsBookByPrice(min, max);
        page.setPageTotalCount(pageTotalCount);//set

        // 求总页码
        int pageTotal = pageTotalCount / pageSize + (pageTotalCount % pageSize == 0 ? 0 : 1);
        page.setPageTotal(pageTotal);

        //设置当前页码 通过总页码判断其合法性
        page.setPageNO(pageNO);

        //求开始的索引
        int begin = (page.getPageNO() - 1) * page.getPageSize();
        //当前页码的书本信息
        List<Book> books = bookDao.pageBookByPrice(begin, page.getPageSize(), min, max);
        page.setItems(books);

        return page;
    }
}
