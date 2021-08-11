package com.bookproject.dao;

import com.bookproject.bean.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author jh
 * @create 2021-05-31-10:51
 */
public interface AdminDao {

    int insertAdmin(Admin admin);

    List<Admin> queryAdmins();

    int updateAdmin(Admin admin);

    Admin queryByName(Admin admin);

    Admin queryByUsername(Admin admin);

    int deleteAdmin(String name);

    List<Admin> getList(@Param("start") int start, @Param("count") int count);

    Integer getTotal();

    int modifyAdmin(Admin admin);

    Admin isExistAdmin(Admin admin);


    int updatePwd(Admin admin);
}
