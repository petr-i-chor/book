package com.bookproject.service;

import com.bookproject.bean.Student;

import java.util.List;

/**
 * @author jh
 * @create 2021-05-31-11:01
 */
public interface StudentService {
    int addStudent(Student student);
    List<Student> findStudents();
    int modifyPwd(Student student);
    boolean queryByName(Student student);
    boolean queryByUsername(Student student);

    int deleteStudent(String name);

    List<Student> getList(int start, int count);

    Integer getTotal();

    boolean isExistStudent(Student student);

}
