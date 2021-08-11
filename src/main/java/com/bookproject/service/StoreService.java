package com.bookproject.service;


import com.bookproject.bean.Store;
import com.bookproject.bean.StoreItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author jh
 * @create 2021-06-21-16:23
 */
public interface StoreService {
    boolean saveStoreOrder(Store store);

    List<Store> queryAllStoreOrder();

    boolean changeStoreOrderStatus(String orderId,Integer status);

    List<Store> queryStoreOrderByUsername(String username);

    List<Store> queryStoreOrderByStatus0();

    List<Store> queryStoreOrderByStatus1();

    boolean modifyStoreOrderStatus(@Param("orderId") String orderId, @Param("status") Integer status);


}
