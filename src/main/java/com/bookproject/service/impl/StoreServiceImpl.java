package com.bookproject.service.impl;

import com.bookproject.bean.Store;
import com.bookproject.bean.StoreItem;
import com.bookproject.dao.StoreDao;
import com.bookproject.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jh
 * @create 2021-06-21-16:26
 */
@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreDao storeDao;

    @Override
    public boolean saveStoreOrder(Store store) {
        int i = storeDao.saveStoreOrder(store);
        if(i>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<Store> queryAllStoreOrder() {
        return storeDao.queryAllStoreOrder();
    }

    @Override
    public boolean changeStoreOrderStatus(String orderId, Integer status) {
        int i = storeDao.changeStoreOrderStatus(orderId,status);
        if(i>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<Store> queryStoreOrderByUsername(String username) {
        return null;
    }

    @Override
    public List<Store> queryStoreOrderByStatus0() {
        return storeDao.queryStoreOrderByStatus0();
    }

    @Override
    public List<Store> queryStoreOrderByStatus1() {
        return storeDao.queryStoreOrderByStatus1();
    }

    @Override
    public boolean modifyStoreOrderStatus(String orderId, Integer status) {
        int i = storeDao.modifyStoreOrderStatus(orderId,status);
        if(i>0){
            return true;
        }else{
            return false;
        }
    }

}
