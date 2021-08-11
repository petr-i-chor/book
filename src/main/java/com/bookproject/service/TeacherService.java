package com.bookproject.service;

import com.bookproject.bean.Teacher;

import java.util.List;

/**
 * @author jh
 * @create 2021-05-31-11:01
 */
public interface TeacherService {
    int addTeacher(Teacher Teacher);
    List<Teacher> findTeachers();
    int modifyPwd(Teacher Teacher);
    boolean queryByName(Teacher Teacher);
    boolean queryByUsername(Teacher teacher);

    int deleteTeacher(String name);

    List<Teacher> getList(int start, int count);

    Integer getTotal();

    boolean isExistTeacher(Teacher teacher);
}
