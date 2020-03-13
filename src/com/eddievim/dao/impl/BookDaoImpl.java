package com.eddievim.dao.impl;

import com.eddievim.dao.BookDao;
import com.eddievim.pojo.Book;

import java.util.List;

public class BookDaoImpl extends BaseDao implements BookDao {

    @Override
    public int addBook(Book book) {
        String sql = "insert into t_book(`name`,`author`,`price`,`sales`,`stock`,`img_path`) values(?,?,?,?,?,?)";
        return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath());
    }

    @Override
    public int DeleteById(Integer id) {
        String sql = "delete from t_book where id = ?";
        return update(sql, id);
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql = "select * from t_book where id = ?";
        return queryForOne(Book.class, sql, id);
    }

    @Override
    public List<Book> queryBooks() {
        String sql = "select * from t_book";
        return queryForList(Book.class, sql);
    }

    @Override
    public int updateBook(Book book) {
        String sql = "update t_book set `name`=?,`author`=?,`price`=?,`sales`=?,`stock`=?,`img_path`=? where id = ?";
        return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath(), book.getId());
    }

    @Override
    public int countsBook() {
        String sql = "select count(*) from t_book";
        Number count = (Number)queryForSingleValue(sql);
        return count.intValue();
    }

    @Override
    public List<Book> pageBook(int begin, int pageSize) {
        String sql = "select * from t_book limit ?, ?";
        return queryForList(Book.class, sql, begin, pageSize);
    }

    @Override
    public int countsBookByPrice(int min, int max) {
        String sql = "select count(*) from t_book where price between ? and ?";
        Number count = (Number)queryForSingleValue(sql, min, max);
        return count.intValue();
    }

    @Override
    public List<Book> pageBookByPrice(int begin, Integer pageSize, int min, int max) {
        String sql = "select * from t_book where price between ? and ? limit ?, ?";
        return queryForList(Book.class, sql, min, max, begin, pageSize);
    }
}
