package com.bookproject.dao;

import com.bookproject.bean.Purchaser;
import com.bookproject.bean.Store;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author jh
 * @create 2021-05-31-10:51
 */
public interface PurchaserDao {

    int insertPurchaser(Purchaser purchaser);

    List<Purchaser> queryPurchasers();

    int updatePurchaser(Purchaser purchaser);

    Purchaser queryByName(Purchaser purchaser);

    Purchaser queryByUsername(Purchaser purchaser);

    int deletePurchaser(String name);

    List<Purchaser> getList(@Param("start") int start, @Param("count") int count);

    Integer getTotal();

    Purchaser queryPurchaserByNameAndPwd(Purchaser purchaser);

}
