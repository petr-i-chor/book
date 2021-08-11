package com.bookproject.service;

import com.bookproject.bean.Admin;

import java.util.List;

/**
 * @author jh
 * @create 2021-05-31-11:01
 */
public interface AdminService {

    int addAdmin(Admin admin);
    int modifyAdmin(Admin admin);
    List<Admin> findAdmins();
    int modifyPwd(Admin admin);
    boolean queryByName(Admin admin);
    boolean queryByUsername(Admin admin);
    boolean deleteAdmin(String name);
    List<Admin> getList(int start,int count);
    Integer getTotal();
    boolean isExistAdmin(Admin admin);
}
