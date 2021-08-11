package com.bookproject.dao;

import com.bookproject.bean.StoreItem;

import java.util.List;

/**
 * @author jh
 * @create 2021-06-21-16:14
 */
public interface StoreItemDao {
    //保存订单明细
    int saveStoreOrderItem(StoreItem StoreItem);

    //根据订单编号查询订单明细
    List<StoreItem> queryStoreOrderItemByOrderId(String orderId);
}
