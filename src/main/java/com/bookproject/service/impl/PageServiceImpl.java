package com.bookproject.service.impl;

import com.bookproject.bean.Admin;
import com.bookproject.dao.PageDao;
import com.bookproject.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jh
 * @create 2021-06-02-17:50
 */
@Service
public class PageServiceImpl implements PageService {

    @Autowired
    private PageDao pageDao;

    @Override
    public List<Admin> getList(int start, int count) {
        List<Admin> list = pageDao.getList(start, count);
        return list;
    }

    @Override
    public Integer getTotal() {
        return pageDao.getTotal();
    }
}
