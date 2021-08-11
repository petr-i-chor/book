package com.bookproject.dao;

import com.bookproject.bean.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author jh
 * @create 2021-06-18-15:25
 */
public interface OrderDao {
    //保存订单
    int saveOrder(Order order);

    //查看所有订单
    List<Order> queryAllOrder();

    //修改订单状态
    int changeOrderStatus(String orderId,Integer status);

    //根据用户编号查看我的订单
    List<Order> queryOrderByUsername(String username);

    List<Order> queryOrderByStatus0();

    List<Order> queryOrderByStatus1();

    int modifyOrderStatus(@Param("orderId") String orderId, @Param("status") Integer status);
}
