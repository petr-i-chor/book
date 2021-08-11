package com.bookproject.controller;

import com.bookproject.bean.Cart;
import com.bookproject.bean.Page;
import com.bookproject.bean.Student;
import com.bookproject.bean.Teacher;
import com.bookproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jh
 * @create 2021-06-01-19:15
 */
@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = ("/addStudent.do"))
    @ResponseBody
    public Map addStudent(Student student){
        Map<Object, Object> map = new HashMap<>();
        boolean isUsername = studentService.queryByUsername(student);
        boolean isName = studentService.queryByName(student);
        if (isUsername){
            if (isName){
                studentService.addStudent(student);
                map.put("msg","昵称为【"+student.getName()+"】注册成功");
            }else {
                map.put("msg","昵称已存在");
            }

        }else{
            map.put("msg","用户名已存在");
        }

        return map;
    }

    @RequestMapping(value = "/findStudents.do")
    public ModelAndView findStudents(){
        ModelAndView mv = new ModelAndView();
        List<Student> students = studentService.findStudents();
        mv.addObject("students",students);
        mv.setViewName("admin/studentList");
        return mv;
    }

    @RequestMapping(value = ("/removeStudent.do"))
    public ModelAndView removeAdmin(HttpServletRequest request){
        String name = request.getParameter("name");
        String parameter = request.getParameter("page.start");
        int start = Integer.parseInt(parameter);
        studentService.deleteStudent(name);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:getStudentList.do?page.start="+start);
        return mv;
    }


    @RequestMapping("/getStudentList.do")
    public ModelAndView getList(HttpServletRequest request, HttpServletResponse response){
        ModelAndView modelView = new ModelAndView();
        int start = 0;
        int count = 6;
        try{
            start = Integer.parseInt(request.getParameter("page.start"));
            count = Integer.parseInt(request.getParameter("page.count"));
        }catch (Exception e){
        }
        Page page = new Page(start,count);
        List<Student> students = studentService.getList(page.getStart(),page.getCount());
        int total = studentService.getTotal();
        page.setTotal(total);

        modelView.addObject("page", page);
        modelView.addObject("students", students);
        modelView.setViewName("admin/studentList");

        return modelView;
    }

    @RequestMapping(value = "/studentLogin.do")
    @ResponseBody
    public Map teacherLogin(HttpServletRequest req, Student student){
        Map map = new HashMap();
        boolean b = studentService.isExistStudent(student);
        if (b){
            HttpSession session = req.getSession();
            session.setAttribute("username",student.getUsername());
            session.setAttribute("identity","student");
            Cart cart = new Cart();
            session.setAttribute("cart",cart);
            map.put("Login","studentLogin");
        }else {
            map.put("Login","no");
        }
        return map;
    }
}
