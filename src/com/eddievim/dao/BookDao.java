package com.eddievim.dao;

import com.eddievim.pojo.Book;

import java.util.List;

public interface BookDao {


    public int addBook(Book book);

    public int DeleteById(Integer id);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    public int updateBook(Book book);

    public int countsBook();

    public List<Book> pageBook(int begin, int pageSize);

    public int countsBookByPrice(int min, int max);

    public List<Book> pageBookByPrice(int begin, Integer pageSize, int min, int max);
}
