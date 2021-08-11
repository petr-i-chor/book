package com.bookproject.service;

import com.bookproject.bean.Order;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jh
 * @create 2021-06-18-19:41
 */
public interface OrderService {

    //保存订单
    boolean saveOrder(Order order);

    //查看所有订单
    List<Order> queryAllOrder();

    //修改订单状态
    boolean changeOrderStatus(String orderId,Integer status);

    //根据用户编号查看我的订单
    List<Order> queryOrderByUsername(String username);

    List<Order> queryOrderByStatus0();

    List<Order> queryOrderByStatus1();

    boolean modifyOrderStatus(String orderId,Integer status);
}
