package com.bookproject.service;

import com.bookproject.bean.OrderItem;

import java.util.List;

/**
 * @author jh
 * @create 2021-06-18-20:17
 */
public interface OrderItemService {
    //保存订单明细
    boolean saveOrderItem(OrderItem orderItem);

    //根据订单编号查询订单明细
    List<OrderItem> queryOrderItemByOrderId(String orderId);
}
