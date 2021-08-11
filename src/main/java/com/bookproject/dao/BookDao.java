package com.bookproject.dao;

import com.bookproject.bean.Admin;
import com.bookproject.bean.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author jh
 * @create 2021-06-15-11:54
 */
public interface BookDao {

    List<Book> queryBooks();

    Book queryBook(String bid);

    Book queryBookByName(String name);

    int addBook(Book book);

    int deleteBook(String bid);

    int updateBook(Book book);

    Book isExist(String bid);

    List<Book> getList(@Param("start") int start, @Param("count") int count);

    Integer getTotal();

    int updateBookStock( @Param("bid") String bid,  @Param("stock") Integer stock);
}
