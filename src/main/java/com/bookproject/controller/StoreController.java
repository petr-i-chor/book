package com.bookproject.controller;

import com.bookproject.bean.*;
import com.bookproject.service.StoreItemService;
import com.bookproject.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author jh
 * @create 2021-06-21-16:02
 */
@Controller
public class StoreController {

    @Autowired
    private StoreService storeService;

    @Autowired
    private StoreItemService storeItemService;

    @RequestMapping("/addStoreOrder.do")
    public ModelAndView addStoreOrder(HttpServletRequest request){
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        Store store = new Store();

        String username = (String) request.getSession().getAttribute("username");
        Date date = new Date();//获取当前时间
        String orderId = System.currentTimeMillis()+""+username;
        store.setOrderId(orderId);
        store.setCreateTime(date);
        store.setStatus(0);

        storeService.saveStoreOrder(store);

        for (Map.Entry<String, CartItem> item : cart.getItems().entrySet()) {

            StoreItem storeItem = new StoreItem();
            storeItem.setOrderId(orderId);
            storeItem.setBid(item.getValue().getId());
            storeItem.setName(item.getValue().getName());
            storeItem.setAuthor(item.getValue().getAuthor());
            storeItem.setCount(item.getValue().getCount());
            storeItemService.saveStoreOrderItem(storeItem);

        }

        cart.clear();

        List<Store> stores = storeService.queryAllStoreOrder();
        ModelAndView mv = new ModelAndView();
        mv.addObject("stores",stores);
        mv.setViewName("order/storeOrder");
        return mv;
    }

    @RequestMapping("/getStoreOrderDetail.do")
    public ModelAndView getOrderDetail(HttpServletRequest request){
        String orderId = request.getParameter("orderId");
        ModelAndView mv = new ModelAndView();
        List<StoreItem> storeItems = storeItemService.queryStoreOrderItemByOrderId(orderId);
        mv.addObject("storeItems",storeItems);
        mv.setViewName("order/storeOrderItem");
        return mv;
    }

    @RequestMapping("/queryStoreOrderByStatus0.do")
    public ModelAndView queryStoreOrderByStatus0(){
        ModelAndView mv = new ModelAndView();
        List<Store> stores = storeService.queryStoreOrderByStatus0();
        mv.addObject("stores",stores);
        mv.setViewName("purchaser/storeDealt");
        return mv;
    }

    @RequestMapping("/queryStoreOrderByStatus1.do")
    public ModelAndView queryStoreOrderByStatus1(){
        ModelAndView mv = new ModelAndView();
        List<Store> stores = storeService.queryStoreOrderByStatus1();
        mv.addObject("stores",stores);
        mv.setViewName("purchaser/storeFinish");
        return mv;
    }

    @RequestMapping("/showFinishStoreOrder.do")
    public ModelAndView showFinishStoreOrder(){
        List<Store> stores = storeService.queryAllStoreOrder();
        ModelAndView mv = new ModelAndView();
        mv.addObject("stores",stores);
        mv.setViewName("admin/purchaseOrderList");
        return mv;
    }


}
