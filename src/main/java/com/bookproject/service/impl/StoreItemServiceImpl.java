package com.bookproject.service.impl;

import com.bookproject.bean.StoreItem;
import com.bookproject.dao.StoreItemDao;
import com.bookproject.service.StoreItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jh
 * @create 2021-06-21-16:39
 */
@Service
public class StoreItemServiceImpl implements StoreItemService {

    @Autowired
    private StoreItemDao storeItemDao;

    @Override
    public boolean saveStoreOrderItem(StoreItem StoreItem) {
        int i = storeItemDao.saveStoreOrderItem(StoreItem);
        if (i>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<StoreItem> queryStoreOrderItemByOrderId(String orderId) {
        return storeItemDao.queryStoreOrderItemByOrderId(orderId);
    }
}
