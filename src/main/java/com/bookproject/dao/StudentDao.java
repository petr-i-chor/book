package com.bookproject.dao;

import com.bookproject.bean.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author jh
 * @create 2021-05-31-10:51
 */
public interface StudentDao {

    int insertStudent(Student student);

    List<Student> queryStudents();

    int updateStudent(Student student);

    Student queryByName(Student student);

    Student queryByUsername(Student student);

    int deleteStudent(String name);

    List<Student> getList(@Param("start") int start, @Param("count") int count);

    Integer getTotal();

    Student isExistStudent(Student student);
}
