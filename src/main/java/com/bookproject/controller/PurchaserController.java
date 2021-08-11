package com.bookproject.controller;

import com.bookproject.bean.*;
import com.bookproject.service.BookService;
import com.bookproject.service.PurchaserService;
import com.bookproject.service.StoreItemService;
import com.bookproject.service.StoreService;
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
public class PurchaserController {

    @Autowired
    private PurchaserService purchaserService;

    @Autowired
    private StoreService storeService;

    @Autowired
    private StoreItemService storeItemService;

    @Autowired
    private BookService bookService;

    @RequestMapping(value = ("/addPurchaser.do"))
    @ResponseBody
    public Map addPurchaser(Purchaser purchaser){
        Map<Object, Object> map = new HashMap<>();
        boolean isUsername = purchaserService.queryByUsername(purchaser);
        boolean isName = purchaserService.queryByName(purchaser);
        if (isUsername){
            if (isName){
                purchaserService.addPurchaser(purchaser);
                map.put("msg","昵称为【"+purchaser.getName()+"】注册成功");
            }else {
                map.put("msg","昵称已存在");
            }

        }else{
            map.put("msg","用户名已存在");
        }

        return map;
    }

    @RequestMapping(value = "/findPurchasers.do")
    public ModelAndView findPurchasers(){
        ModelAndView mv = new ModelAndView();
        List<Purchaser> purchasers = purchaserService.findPurchasers();
        mv.addObject("purchasers",purchasers);
        mv.setViewName("admin/purchaserList");
        return mv;
    }
    @RequestMapping(value = ("/removePurchaser.do"))
    public ModelAndView removeAdmin(HttpServletRequest request){
        String name = request.getParameter("name");
        String parameter = request.getParameter("page.start");
        int start = Integer.parseInt(parameter);
        purchaserService.deletePurchaser(name);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:getPurchaserList.do?page.start="+start);
        return mv;
    }


    @RequestMapping("/getPurchaserList.do")
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
        List<Purchaser> purchasers = purchaserService.getList(page.getStart(),page.getCount());
        int total = purchaserService.getTotal();
        page.setTotal(total);

        modelView.addObject("page", page);
        modelView.addObject("purchasers", purchasers);
        modelView.setViewName("admin/purchaserList");

        return modelView;
    }


    @RequestMapping(value = "/purchaserLogin.do")
    @ResponseBody
    public Map purchaserLogin(HttpServletRequest req, Purchaser purchaser){
        Map map = new HashMap();
        boolean b = purchaserService.isExistPurchaser(purchaser);
        if (b){
            HttpSession session = req.getSession();
            session.setAttribute("username",purchaser.getUsername());
            session.setAttribute("identity","purchaser");
            Cart cart = new Cart();
            session.setAttribute("cart",cart);
            map.put("Login","purchaserLogin");
        }else {
            map.put("Login","no");
        }
        return map;
    }

    @RequestMapping(value = "/queryAllStoreOrder.do.do")
    public ModelAndView queryAllStoreOrder(){
        ModelAndView mv = new ModelAndView();
        List<Store> stores = storeService.queryAllStoreOrder();
        mv.addObject("stores",stores);
        mv.setViewName("purchaser/purchaser");
        return mv;
    }
    @RequestMapping(value = "/modifyStoreOrderStatus.do")
    public ModelAndView modifyStoreOrderStatus(String orderId){
        ModelAndView mv = new ModelAndView();
        List<StoreItem> storeItems = storeItemService.queryStoreOrderItemByOrderId(orderId);
        for ( StoreItem storeItem:storeItems ) {
            Integer count = storeItem.getCount();
            String bid = storeItem.getBid();
            Book book = bookService.queryBook(bid);
            Integer stock = book.getStock()+count;
            bookService.updateBookStock(bid,stock);
        }
        storeService.modifyStoreOrderStatus(orderId, 1);
        mv.setViewName("purchaser/storeDealt");
        return mv;
    }

    @RequestMapping(value = "/purchaserLogout.do")
    public String purchaserLogout(HttpServletRequest req){
        req.getSession().invalidate();
        return "redirect:index.jsp";
    }


    @RequestMapping(value = ("/purchaserModifyPwd.do"))
    @ResponseBody
    public Map teacherModifyPwd(Purchaser purchaser,HttpServletRequest request) {
        Map<Object, Object> map = new HashMap<>();
        String newPwd = request.getParameter("newPwd");
        boolean b = purchaserService.isExistPurchaser(purchaser);
        if (b){
            purchaser.setPassword(newPwd);
            purchaserService.modifyPwd(purchaser);
            map.put("msg", "success");
        }else{
            map.put("msg","fault");
        }
        return map;
    }
}
