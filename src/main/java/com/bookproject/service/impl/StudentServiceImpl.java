package com.bookproject.service.impl;

import com.bookproject.bean.Admin;
import com.bookproject.bean.Student;
import com.bookproject.dao.StudentDao;
import com.bookproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jh
 * @create 2021-06-01-19:27
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public int addStudent(Student student) {
        int i = studentDao.insertStudent(student);
        return i;
    }

    @Override
    public List<Student> findStudents() {
        List<Student> students = studentDao.queryStudents();
        return students;
    }

    @Override
    public int modifyPwd(Student student) {
        int i = studentDao.updateStudent(student);
        return i;
    }

    @Override
    public boolean queryByName(Student student) {
        Student name = studentDao.queryByName(student);
        if (name==null){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean queryByUsername(Student student) {
        Student name = studentDao.queryByUsername(student);
        if (name==null){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public int deleteStudent(String name) {
        int i = studentDao.deleteStudent(name);
        return i;
    }

    @Override
    public List<Student> getList(int start, int count) {
        List<Student> list = studentDao.getList(start, count);
        return list;
    }

    @Override
    public Integer getTotal() {
        return studentDao.getTotal();
    }

    @Override
    public boolean isExistStudent(Student student) {
        Student student1 = studentDao.isExistStudent(student);
        if (student1!=null){
            return true;
        }else{
            return false;
        }
    }
}
