package com.bookproject.controller;

import com.bookproject.bean.Book;
import com.bookproject.bean.Page;
import com.bookproject.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jh
 * @create 2021-06-15-11:54
 */
@Controller
public class BookController {

    @Autowired
    private BookServiceImpl bookService;

    @RequestMapping(value = ("/addBook.do"))
    @ResponseBody
    public Map addBook(Book book) {
        Map<Object, Object> map = new HashMap<>();
        System.out.println(book);
        boolean b = bookService.isExist(book.getBid());
        System.out.println(b);
        if (b) {

            map.put("msg", "该书已存在");

        } else {

            bookService.addBook(book);
            map.put("msg", "图书《" + book.getName() + "》添加成功");

        }

        return map;
    }


    @RequestMapping(value = ("/modifyBook.do"))
    @ResponseBody
    public Map modifyBook(Book book) {
        System.out.println(book);
        Map<Object, Object> map = new HashMap<>();
        boolean b = bookService.updateBook(book);
        if (b) {
            map.put("msg", "图书《" + book.getName() + "》修改成功");
        } else {
            map.put("msg", "修改失败");
        }

        return map;
    }


    @RequestMapping(value = ("/removeBook.do"))
    public ModelAndView removeBook(HttpServletRequest request,Book book) {
        String parameter = request.getParameter("page.start");
        int start = Integer.parseInt(parameter);
        bookService.deleteBook(book.getBid());
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:getBookList.do?page.start=" + start);
        return mv;
    }

    @RequestMapping("/getBookList.do")
    public ModelAndView getList(HttpServletRequest request, HttpSession session) {
        ModelAndView modelView = new ModelAndView();
        int start = 0;
        int count = 6;
        try {
            start = Integer.parseInt(request.getParameter("page.start"));  //从前台获取 开始数据的索引
            count = Integer.parseInt(request.getParameter("page.count"));  //从前台获取 每页显示的条目数
        } catch (Exception e) {
        }
        Page page = new Page(start, count);
        List<Book> books = bookService.getList(page.getStart(), page.getCount());  //获取用户list
        int total = bookService.getTotal();
        page.setTotal(total);

        modelView.addObject("page", page);
        modelView.addObject("books", books);


      String identity = (String) request.getSession().getAttribute("identity");
        String method = request.getParameter("method");
        if ("admin".equals(identity)){
            if ("purchase".equals(method)){
                modelView.setViewName("admin/purchaseList");
            }else {
                modelView.setViewName("admin/bookList");
            }
        }else if("teacher".equals(identity) || "student".equals(identity)) {
            modelView.setViewName("teacher/teacher");
        }
        return modelView;
    }

    @RequestMapping("/getBookParameter.do")
    public ModelAndView getBookParameter(String bid){
        Book book = bookService.queryBook(bid);
        ModelAndView mv = new ModelAndView();
        mv.addObject("book",book);
        mv.setViewName("admin/bookModify");
        return mv;
    }

}
