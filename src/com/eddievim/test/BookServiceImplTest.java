package com.eddievim.test;

import com.eddievim.service.BookService;
import com.eddievim.service.impl.BookServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookServiceImplTest {
    BookService bookService = new BookServiceImpl();
    @Test
    public void pageBook() {
        System.out.println(bookService.pageBook(1, 5));
    }
}