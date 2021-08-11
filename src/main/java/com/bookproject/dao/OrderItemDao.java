package com.bookproject.dao;

import com.bookproject.bean.OrderItem;

import java.util.List;

/**
 * @author jh
 * @create 2021-06-18-15:40
 */
public interface OrderItemDao {
    //保存订单明细
    int saveOrderItem(OrderItem orderItem);

    //根据订单编号查询订单明细
    List<OrderItem> queryOrderItemByOrderId(String orderId);
}
