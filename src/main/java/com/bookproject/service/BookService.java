package com.bookproject.service;

import com.bookproject.bean.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author jh
 * @create 2021-06-15-12:26
 */
public interface BookService {
    List<Book> queryBooks();

    Book queryBook(String bid);

    boolean addBook(Book book);

    boolean deleteBook(String bid);

    boolean updateBook(Book book);

    boolean isExist(String bid);

    List<Book> getList(@Param("start") int start, @Param("count") int count);

    Integer getTotal();

    boolean updateBookStock(String bid, Integer stock);
}
