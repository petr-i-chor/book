package com.bookproject.service;

import com.bookproject.bean.Purchaser;
import com.bookproject.bean.Store;
import com.bookproject.bean.Teacher;

import java.util.List;

/**
 * @author jh
 * @create 2021-05-31-11:01
 */
public interface PurchaserService {
    int addPurchaser(Purchaser purchaser);
    List<Purchaser> findPurchasers();
    int modifyPwd(Purchaser purchaser);
    boolean queryByName(Purchaser purchaser);
    boolean queryByUsername(Purchaser purchaser);

    int deletePurchaser(String name);

    List<Purchaser> getList(int start, int count);

    Integer getTotal();


    boolean isExistPurchaser(Purchaser purchaser);

}
