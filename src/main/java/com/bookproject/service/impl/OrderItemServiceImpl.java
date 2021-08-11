package com.bookproject.service.impl;

import com.bookproject.bean.OrderItem;
import com.bookproject.dao.OrderItemDao;
import com.bookproject.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jh
 * @create 2021-06-18-20:17
 */
@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OrderItemDao orderItemDao;

    @Override
    public boolean saveOrderItem(OrderItem orderItem) {
        int i = orderItemDao.saveOrderItem(orderItem);
        if (i>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<OrderItem> queryOrderItemByOrderId(String orderId) {
        return orderItemDao.queryOrderItemByOrderId(orderId);
    }
}
