package com.bookproject.dao;

import com.bookproject.bean.Store;
import com.bookproject.bean.StoreItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author jh
 * @create 2021-06-21-16:04
 */
public interface StoreDao {
    //保存订单
    int saveStoreOrder(Store store);

    //查看所有订单
    List<Store> queryAllStoreOrder();

    //修改订单状态
    int changeStoreOrderStatus(String orderId,Integer status);

    //根据用户编号查看我的订单
    List<Store> queryStoreOrderByUsername(String username);

    List<Store> queryStoreOrderByStatus0();

    List<Store> queryStoreOrderByStatus1();

    int modifyStoreOrderStatus(@Param("orderId") String orderId, @Param("status") Integer status);

    StoreItem queryStoreItemOrderByOrderId(String orderId);
}
