package com.eddievim.service;

import com.eddievim.pojo.Book;
import com.eddievim.pojo.Page;

import java.util.List;

public interface BookService {

    public int addBook(Book book);

    public int DeleteById(Integer id);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    public int updateBook(Book book);

    Page<Book> pageBook(int pageNO, int pageSize);

    Page<Book> pageByPrice(int pageNO, int pageSize, int min, int max);
}
