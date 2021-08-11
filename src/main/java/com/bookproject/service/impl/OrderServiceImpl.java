package com.bookproject.service.impl;

import com.bookproject.bean.Order;
import com.bookproject.dao.OrderDao;
import com.bookproject.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jh
 * @create 2021-06-18-19:44
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public boolean saveOrder(Order order) {
        int i = orderDao.saveOrder(order);
        if (i>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<Order> queryAllOrder() {

        return orderDao.queryAllOrder();
    }

    @Override
    public boolean changeOrderStatus(String orderId, Integer status) {
        int i = orderDao.changeOrderStatus(orderId,status);
        if (i>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<Order> queryOrderByUsername(String username) {
        return orderDao.queryOrderByUsername(username);
    }

    @Override
    public List<Order> queryOrderByStatus0() {
        return orderDao.queryOrderByStatus0();
    }

    @Override
    public List<Order> queryOrderByStatus1() {
        return orderDao.queryOrderByStatus1();
    }

    @Override
    public boolean modifyOrderStatus(String orderId,Integer status) {
        int count = orderDao.modifyOrderStatus(orderId,status);
        if (count>0){
            return true;
        }else{
            return false;
        }
    }
}
