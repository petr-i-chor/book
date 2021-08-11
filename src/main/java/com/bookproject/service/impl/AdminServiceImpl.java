package com.bookproject.service.impl;

import com.bookproject.bean.Admin;
import com.bookproject.dao.AdminDao;
import com.bookproject.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jh
 * @create 2021-05-31-11:04
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public int addAdmin(Admin admin) {
        int i = adminDao.insertAdmin(admin);
        return i;
    }

    @Override
    public int modifyAdmin(Admin admin) {
        int i = adminDao.modifyAdmin(admin);
        return i;
    }

    @Override
    public List<Admin> findAdmins() {
        List<Admin> admins = adminDao.queryAdmins();
        return admins;
    }

    @Override
    public int modifyPwd(Admin admin) {
        int i = adminDao.updatePwd(admin);
        return i;
    }

    /**
     *
     * @param admin
     * @return true 说明该用户名可用
     */
    @Override
    public boolean queryByName(Admin admin) {
        Admin name = adminDao.queryByName(admin);
        if (name==null){
            return true;
        }else {
            return false;
        }
    }
    @Override
    public boolean queryByUsername(Admin admin) {
        Admin name = adminDao.queryByUsername(admin);
        if (name==null){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean deleteAdmin(String name) {
        int i = adminDao.deleteAdmin(name);
        if (i>0){
            return true;
        }
        return false;
    }


    @Override
    public List<Admin> getList(int start, int count) {
        List<Admin> list = adminDao.getList(start, count);
        return list;
    }

    @Override
    public Integer getTotal() {
        return adminDao.getTotal();
    }

    @Override
    public boolean isExistAdmin(Admin admin) {
        Admin ad = adminDao.isExistAdmin(admin);
        if (ad!=null){
            return true;
        }
        return false;
    }
}
