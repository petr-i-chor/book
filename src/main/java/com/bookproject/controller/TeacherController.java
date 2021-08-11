package com.bookproject.controller;
import com.bookproject.bean.*;
import com.bookproject.service.BookService;
import com.bookproject.service.TeacherService;
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
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private BookService bookService;

    @RequestMapping(value = ("/addTeacher.do"))
    @ResponseBody
    public Map addTeacher(Teacher teacher){
        Map<Object, Object> map = new HashMap<>();
        boolean isUsername = teacherService.queryByUsername(teacher);
        boolean isName = teacherService.queryByName(teacher);
        if (isUsername){
            if (isName){
                teacherService.addTeacher(teacher);
                map.put("msg","昵称为【"+teacher.getName()+"】注册成功");
            }else {
                map.put("msg","昵称已存在");
            }

        }else{
            map.put("msg","用户名已存在");
        }

        return map;
    }

    @RequestMapping(value = "/findTeachers.do")
    public ModelAndView findTeachers(){
        ModelAndView mv = new ModelAndView();
        List<Teacher> teachers = teacherService.findTeachers();
        mv.addObject("teachers",teachers);
        mv.setViewName("teacher/teacherList");
        return mv;
    }

    @RequestMapping(value = ("/removeTeacher.do"))
    public ModelAndView removeTeacher(HttpServletRequest request){
        String name = request.getParameter("name");
        String parameter = request.getParameter("page.start");
        int start = Integer.parseInt(parameter);
        teacherService.deleteTeacher(name);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:getTeacherList.do?page.start="+start);
        return mv;
    }


    @RequestMapping("/getTeacherList.do")
    public ModelAndView getList(HttpServletRequest request, HttpServletResponse response){
        ModelAndView modelView = new ModelAndView();
        int start = 0;
        int count = 6;
        try{
            start = Integer.parseInt(request.getParameter("page.start"));  //从前台获取 开始数据的索引
            count = Integer.parseInt(request.getParameter("page.count"));  //从前台获取 每页显示的条目数
        }catch (Exception e){
        }
        Page page = new Page(start,count);
        List<Teacher> teachers = teacherService.getList(page.getStart(),page.getCount());  //获取用户list
        int total = teacherService.getTotal();
        page.setTotal(total);

        modelView.addObject("page", page);
        modelView.addObject("teachers", teachers);
        modelView.setViewName("admin/teacherList");

        return modelView;
    }

    @RequestMapping(value = "/teacherLogin.do")
    @ResponseBody
    public Map teacherLogin(HttpServletRequest req, Teacher teacher){
        Map map = new HashMap();
        boolean b = teacherService.isExistTeacher(teacher);
        if (b){
            HttpSession session = req.getSession();
            session.setAttribute("username",teacher.getUsername());
            session.setAttribute("identity","teacher");
            Cart cart = new Cart();
            session.setAttribute("cart",cart);
            map.put("Login","teacherLogin");
        }else {
            map.put("Login","no");
        }
        return map;
    }


    @RequestMapping(value = "/teacherLogout.do")
    public String teacherLogout(HttpServletRequest req){
        req.getSession().invalidate();
        return "redirect:index.jsp";
    }

    @RequestMapping(value = ("/teacherModifyPwd.do"))
    @ResponseBody
    public Map teacherModifyPwd(Teacher teacher,HttpServletRequest request) {
        Map<Object, Object> map = new HashMap<>();
        String newPwd = request.getParameter("newPwd");
        boolean b = teacherService.isExistTeacher(teacher);
        if (b){
            teacher.setPassword(newPwd);
            teacherService.modifyPwd(teacher);
            map.put("msg", "success");
        }else{
            map.put("msg","fault");
        }

        return map;
    }
}
