package com.bookproject.controller;

import com.bookproject.bean.Admin;
import com.bookproject.bean.Cart;
import com.bookproject.bean.Page;
import com.bookproject.service.AdminService;
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
 * @create 2021-05-31-11:09
 */
@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;


    @RequestMapping(value = ("/addAdmin.do"))
    @ResponseBody
    public Map addAdmin(HttpServletRequest request, Admin admin) {
        Map<Object, Object> map = new HashMap<>();
        boolean isUsername = adminService.queryByUsername(admin);
        boolean isName = adminService.queryByName(admin);
        if (isUsername) {
            if (isName) {
                adminService.addAdmin(admin);
                map.put("msg", "昵称为【" + admin.getName() + "】注册成功");
            } else {
                map.put("msg", "昵称已存在");
            }

        } else {
            map.put("msg", "用户名已存在");
        }

        return map;
    }


    @RequestMapping(value = ("/modifyAdmin.do"))
    @ResponseBody
    public Map modifyAdmin(Admin admin) {
        System.out.println(admin);
        Map<Object, Object> map = new HashMap<>();
        int i = adminService.modifyAdmin(admin);
        if (i>0){
            map.put("msg", "用户【" + admin.getUsername() + "】修改成功");
        }else{
            map.put("msg","修改失败");
        }


        return map;
    }


    @RequestMapping(value = ("/removeAdmin.do"))
    public ModelAndView removeAdmin(HttpServletRequest request) {
        String name = request.getParameter("name");
        String parameter = request.getParameter("page.start");
        int start = Integer.parseInt(parameter);
        adminService.deleteAdmin(name);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:getAdminsList.do?page.start=" + start);
        return mv;
    }

    @RequestMapping("/getAdminsList.do")
    public ModelAndView getList(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelView = new ModelAndView();
        int start = 0;
        int count = 6;
        try {
            start = Integer.parseInt(request.getParameter("page.start"));  //从前台获取 开始数据的索引
            count = Integer.parseInt(request.getParameter("page.count"));  //从前台获取 每页显示的条目数
        } catch (Exception e) {
        }
        Page page = new Page(start, count);
        List<Admin> admins = adminService.getList(page.getStart(), page.getCount());  //获取用户list
        int total = adminService.getTotal();
        page.setTotal(total);

        modelView.addObject("page", page);
        modelView.addObject("admins", admins);
        modelView.setViewName("admin/adminList");

        return modelView;
    }


    @RequestMapping(value = "/adminLogin.do")
    @ResponseBody
    public Map adminLogin(HttpServletRequest req,Admin admin){
        Map map = new HashMap();
        if (adminService.isExistAdmin(admin)){
            Cart cart = new Cart();
            HttpSession session = req.getSession();
            session.setAttribute("username",admin.getUsername());
            session.setAttribute("identity","admin");
            session.setAttribute("cart", cart);
            map.put("Login","adminLogin");
        }else {
            map.put("Login","no");
        }
        return map;
    }


    @RequestMapping(value = ("/modifyPwd.do"))
    @ResponseBody
    public Map modifyPwd(Admin admin,HttpServletRequest request) {
        Map<Object, Object> map = new HashMap<>();
        String newPwd = request.getParameter("newPwd");
        boolean b = adminService.isExistAdmin(admin);
        if (b){
            admin.setPassword(newPwd);
            adminService.modifyPwd(admin);
            map.put("msg", "success");
        }else{
            map.put("msg","fault");
        }



        return map;
    }

    @RequestMapping(value = "/logout.do")
    public String adminLogout(HttpServletRequest req){
        req.getSession().invalidate();
        return "redirect:index.jsp";
    }

}
