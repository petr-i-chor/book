package com.bookproject.service.impl;

import com.bookproject.bean.Admin;
import com.bookproject.bean.Teacher;
import com.bookproject.dao.TeacherDao;
import com.bookproject.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jh
 * @create 2021-06-01-19:27
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDao teacherDao;

    @Override
    public int addTeacher(Teacher teacher) {
        int i = teacherDao.insertTeacher(teacher);
        return i;
    }

    @Override
    public List<Teacher> findTeachers() {
        List<Teacher> teachers = teacherDao.queryTeachers();
        return teachers;
    }

    @Override
    public int modifyPwd(Teacher teacher) {
        int i = teacherDao.updateTeacher(teacher);
        return i;
    }

    @Override
    public boolean queryByName(Teacher teacher) {
        Teacher name = teacherDao.queryByName(teacher);
        if (name==null){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean queryByUsername(Teacher teacher) {
        Teacher name = teacherDao.queryByUsername(teacher);
        if (name==null){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public int deleteTeacher(String name) {
        int i = teacherDao.deleteTeacher(name);
        return i;
    }

    @Override
    public List<Teacher> getList(int start, int count) {
        List<Teacher> list = teacherDao.getList(start, count);
        return list;
    }

    @Override
    public Integer getTotal() {
        return teacherDao.getTotal();
    }

    @Override
    public boolean isExistTeacher(Teacher teacher) {
        Teacher teacher1= teacherDao.queryByNameAndPwd(teacher);
        if (teacher1!=null){
            return  true;
        }
        return false;
    }
}
