package com.bookproject.service.impl;

import com.bookproject.bean.Book;
import com.bookproject.dao.BookDao;
import com.bookproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jh
 * @create 2021-06-15-12:27
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public List<Book> queryBooks() {
        return null;
    }

    @Override
    public Book queryBook(String bid) {

        return bookDao.queryBook(bid);
    }


    @Override
    public boolean addBook(Book book) {
        int i = bookDao.addBook(book);
        if (i>1){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean deleteBook(String bid) {
        int i = bookDao.deleteBook(bid);
        if (i>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean updateBook(Book book) {
        int i = bookDao.updateBook(book);
        if (i>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean isExist(String bid) {
        Book b = bookDao.isExist(bid);
        if (b!=null){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<Book> getList(int start, int count) {
        List<Book> list =  bookDao.getList(start, count);
        return list;
    }

    @Override
    public Integer getTotal() {
        return bookDao.getTotal();
    }

    @Override
    public boolean updateBookStock(String bid, Integer stock) {
        int i = bookDao.updateBookStock(bid,stock);
        if (i>0){
            return true;
        }else{
            return false;
        }
    }
}
