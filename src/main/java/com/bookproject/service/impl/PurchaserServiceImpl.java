package com.bookproject.service.impl;

import com.bookproject.bean.Admin;
import com.bookproject.bean.Purchaser;
import com.bookproject.bean.Store;
import com.bookproject.bean.Teacher;
import com.bookproject.dao.PurchaserDao;
import com.bookproject.service.PurchaserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jh
 * @create 2021-06-01-19:27
 */
@Service
public class PurchaserServiceImpl implements PurchaserService {

    @Autowired
    private PurchaserDao purchaserDao;

    @Override
    public int addPurchaser(Purchaser purchaser) {
        int i = purchaserDao.insertPurchaser(purchaser);
        return i;
    }

    @Override
    public List<Purchaser> findPurchasers() {
        List<Purchaser> purchasers = purchaserDao.queryPurchasers();
        return purchasers;
    }

    @Override
    public int modifyPwd(Purchaser purchaser) {
        int i = purchaserDao.updatePurchaser(purchaser);
        return i;
    }

    @Override
    public boolean queryByName(Purchaser purchaser) {
        Purchaser name = purchaserDao.queryByName(purchaser);
        if (name==null){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean queryByUsername(Purchaser purchaser) {
        Purchaser name = purchaserDao.queryByUsername(purchaser);
        if (name==null){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public int deletePurchaser(String name) {
        int i = purchaserDao.deletePurchaser(name);
        return i;
    }

    @Override
    public List<Purchaser> getList(int start, int count) {
        List<Purchaser> list = purchaserDao.getList(start, count);
        return list;
    }

    @Override
    public Integer getTotal() {
        return purchaserDao.getTotal();
    }


    @Override
    public boolean isExistPurchaser(Purchaser purchaser) {
        Purchaser purchaser1 = purchaserDao.queryPurchaserByNameAndPwd(purchaser);
        if (purchaser1!=null){
            return true;
        }else {
            return false;
        }
    }

}
