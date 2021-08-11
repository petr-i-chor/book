package com.bookproject.controller;

import com.bookproject.bean.*;
import com.bookproject.service.BookService;
import com.bookproject.service.OrderItemService;
import com.bookproject.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author jh
 * @create 2021-06-18-19:39
 */
@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private BookService bookService;

    @RequestMapping("/addOrder.do")
    public ModelAndView addOrder(HttpServletRequest request){
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        Order order = new Order();

        String username = (String) request.getSession().getAttribute("username");
        Date date = new Date();//获取当前时间
        String orderId = System.currentTimeMillis()+""+username;
        order.setOrderId(orderId);
        order.setCreateTime(date);
        order.setStatus(0);
        order.setPrice(cart.getCartTotalPrice());
        order.setUsername(username);

        orderService.saveOrder(order);

        for (Map.Entry<String,CartItem> item : cart.getItems().entrySet()) {

            OrderItem orderItem = new OrderItem();
            orderItem.setOrderId(orderId);
            orderItem.setBid(item.getValue().getId());
            orderItem.setName(item.getValue().getName());
            orderItem.setAuthor(item.getValue().getAuthor());
            orderItem.setPrice(item.getValue().getPrice());
            orderItem.setCount(item.getValue().getCount());
            orderItem.setTotalPrice(item.getValue().getTotalPrice());
            orderItemService.saveOrderItem(orderItem);

            //更新库存和销量
            Book book = bookService.queryBook(item.getValue().getId());
            book.setSales(book.getSales()+item.getValue().getCount());
            book.setStock(book.getStock()-item.getValue().getCount());
            bookService.updateBook(book);

        }

        cart.clear();

        List<Order> orders = orderService.queryOrderByUsername(username);
        ModelAndView mv = new ModelAndView();
        mv.addObject("orders",orders);
        mv.setViewName("order/order");
        return mv;
    }

    @RequestMapping("/showOrder.do")
    public ModelAndView showOrder(HttpServletRequest request){
        String  username = (String) request.getSession().getAttribute("username");
        List<Order> orders = orderService.queryOrderByUsername(username);
        ModelAndView mv = new ModelAndView();
        mv.addObject("orders",orders);
        mv.setViewName("order/order");
        return mv;
    }

    @RequestMapping("/getOrderDetail.do")
    public ModelAndView getOrderDetail(String orderId){
        ModelAndView mv = new ModelAndView();
        List<OrderItem> orderItems = orderItemService.queryOrderItemByOrderId(orderId);
        mv.addObject("orderItems",orderItems);
        mv.setViewName("order/orderItem");
        return mv;
    }

    @RequestMapping("/showDealtOrder.do")
    public ModelAndView showDealtOrder(){
        List<Order> orders = orderService.queryOrderByStatus0();
        ModelAndView mv = new ModelAndView();
        mv.addObject("orders",orders);
        mv.setViewName("admin/orderDealt");
        return mv;
    }

    @RequestMapping("/showFinishOrder.do")
    public ModelAndView showFinishOrder(){
        List<Order> orders = orderService.queryOrderByStatus1();
        System.out.println(orders);
        ModelAndView mv = new ModelAndView();
        mv.addObject("orders",orders);
        mv.setViewName("admin/orderFinish");
        return mv;
    }

    @RequestMapping("/modifyOrderStatus.do")
    public String modifyOrderStatus(HttpServletRequest request){
        String orderId = request.getParameter("orderId");
        String status = request.getParameter("status");
        orderService.modifyOrderStatus(orderId,Integer.valueOf(status));
        List<Order> orders = orderService.queryOrderByStatus1();
        return "redirect:showDealtOrder.do";
    }

}
