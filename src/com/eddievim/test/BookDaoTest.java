package com.eddievim.test;

import com.eddievim.dao.BookDao;
import com.eddievim.dao.impl.BookDaoImpl;
import com.eddievim.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BookDaoTest {

    private BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        bookDao.addBook(new Book(null, "算法5","eddie",new BigDecimal(66),999,0,""));
    }

    @Test
    public void deleteById() {
        bookDao.DeleteById(22);
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(21));
    }

    @Test
    public void queryBooks() {
        System.out.println(bookDao.queryBooks());
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(21, "算法5", "EddieVim", new BigDecimal(66),999,0,""));
    }

    @Test
    public void countsBook() {
        System.out.println(bookDao.countsBookByPrice(0, 100));
    }

    @Test
    public void pageBook() {
        System.out.println(bookDao.pageBookByPrice(0,5, 100, 200));
    }
}