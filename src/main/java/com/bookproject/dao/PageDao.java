package com.bookproject.dao;

import com.bookproject.bean.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author jh
 * @create 2021-06-02-17:41
 */
public interface PageDao {
    List<Admin> getList(@Param("start") int start,@Param("count") int count);
    Integer getTotal();
}
