package com.bookproject.service;

import com.bookproject.bean.Admin;

import java.util.List;

/**
 * @author jh
 * @create 2021-06-02-17:48
 */
public interface PageService {
    List<Admin> getList(int start,int count);
    Integer getTotal();
}
