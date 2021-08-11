package com.bookproject.controller;

import com.bookproject.bean.Book;
import com.bookproject.bean.Cart;
import com.bookproject.bean.CartItem;
import com.bookproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jh
 * @create 2021-06-17-16:16
 */
@Controller
public class CartController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/clearCart.do")
    public String clearCart(HttpServletRequest request){
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        cart.clear();
        String identity = (String) request.getSession().getAttribute("identity");
        if ("teacher".equals(identity)){
            return "redirect:cart/cart.jsp";
        }else if("admin".equals(identity)){
            return "redirect:admin/purchaserCart.jsp";
        }else {
            return "redirect:error.jsp";
        }
    }

    @RequestMapping("/deleteCart.do")
    public String deleteCart(HttpServletRequest request){
        String bid = request.getParameter("bid");
        String identity = (String) request.getSession().getAttribute("identity");
        System.out.println("删除操作");
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        cart.deleteCart(bid);

        if ("teacher".equals(identity)){
            return "redirect:cart/cart.jsp";
        }else if("admin".equals(identity)){
            return "redirect:admin/purchaserCart.jsp";
        }else {
            return "redirect:error.jsp";
        }
    }

    @RequestMapping("/modifyCart.do")
    public String modifyCart(HttpServletRequest request, CartItem cartItem){
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        cart.modifyCart(cartItem.getId(),cartItem.getCount());
        String identity = (String) request.getSession().getAttribute("identity");
        if ("teacher".equals(identity)){
            return "redirect:cart/cart.jsp";
        }else if("admin".equals(identity)){
            return "redirect:admin/purchaserCart.jsp";
        }else {
            return "redirect:error.jsp";
        }
    }

    @RequestMapping("/addCart.do")
    public String addCart(HttpServletRequest request){
        String bid = request.getParameter("bid");
        Book book = bookService.queryBook(bid);
        CartItem cartItem = new CartItem(book.getBid(),book.getName(),book.getAuthor(),book.getPrice(),1,book.getStock(), book.getPrice());
        String referer = request.getHeader("Referer");
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        cart.addCart(cartItem);
        return "redirect:"+referer;
    }
}
