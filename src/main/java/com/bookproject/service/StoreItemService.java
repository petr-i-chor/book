package com.bookproject.service;

import com.bookproject.bean.StoreItem;

import java.util.List;

/**
 * @author jh
 * @create 2021-06-21-16:38
 */
public interface StoreItemService {

    boolean saveStoreOrderItem(StoreItem StoreItem);

    List<StoreItem> queryStoreOrderItemByOrderId(String orderId);

}
