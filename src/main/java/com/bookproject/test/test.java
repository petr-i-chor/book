package com.bookproject.test;

import com.bookproject.bean.Book;
import com.bookproject.bean.Order;
import com.bookproject.dao.BookDao;
import com.bookproject.service.AdminService;
import com.bookproject.service.BookService;
import com.bookproject.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

/**
 * @author jh
 * @create 2021-06-16-0:17
 */
public class test {

    public static void main(String[] args) {
   /*     ApplicationContext ac = new ClassPathXmlApplicationContext("conf/applicationContext.xml");
        BookService service = (BookService) ac.getBean("bookServiceImpl");
       *//* Book book = new Book();
        book.setName("123");
        book.setAuthor("123");
        boolean exist = service.isExist(book);
        System.out.println(exist);*//*
        List<Book> list = service.getList(0, 6);
        for (Book book : list) {
            System.out.println(book);
        }
        Integer total = service.getTotal();
        System.out.println(total);*/

        ApplicationContext ac = new ClassPathXmlApplicationContext("conf/applicationContext.xml");
        OrderService service = (OrderService) ac.getBean("orderServiceImpl");
        service.saveOrder(new Order("1",new Date(), 1.00f,1,"a"));

    }


}
