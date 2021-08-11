package com.bookproject.dao;

import com.bookproject.bean.Admin;
import com.bookproject.bean.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author jh
 * @create 2021-05-31-10:51
 */
public interface TeacherDao {

    int insertTeacher(Teacher teacher);

    List<Teacher> queryTeachers();

    int updateTeacher(Teacher teacher);

     Teacher queryByName(Teacher teacher);

    Teacher queryByUsername(Teacher teacher);

    int deleteTeacher(String name);

    List<Teacher> getList(@Param("start") int start, @Param("count") int count);

    Integer getTotal();

    Teacher queryByNameAndPwd(Teacher teacher);
}
