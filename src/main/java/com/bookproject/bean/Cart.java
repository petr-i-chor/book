package com.bookproject.bean;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author jh
 * @create 2021-06-16-16:36
 */
public class Cart {

    private Map<String,CartItem> items = new LinkedHashMap<String,CartItem>();

    public Map<String, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<String, CartItem> items) {
        this.items = items;
    }

    public void addCart(CartItem cartItem){
        CartItem item = items.get(cartItem.getId());
        if (item==null){
            items.put(cartItem.getId(),cartItem);
        }else{
            item.setCount(item.getCount()+1);
            item.setTotalPrice(item.getCount()*item.getPrice());
        }
    }

    public void deleteCart(String id){
        items.remove(id);
    }

    public void clear() {
        items.clear();
    }

    public void modifyCart(String id ,Integer count){
        CartItem item = items.get(id);
        if (item!=null){
            item.setCount(count);
            item.setTotalPrice(item.getPrice()*item.getCount());
        }
    }


    public Integer getTotalCount() {

        Integer totalCount = 0;
        Set<Map.Entry<String, CartItem>> entries = items.entrySet();
        for (Map.Entry<String, CartItem> entry :entries ) {
            totalCount=entry.getValue().getCount()+totalCount;
        }
        return totalCount;
    }


    public float getCartTotalPrice() {
        float cartTotalPrice =0;
        Set<Map.Entry<String, CartItem>> entries = items.entrySet();
        for (Map.Entry<String, CartItem> entry :entries ) {
            cartTotalPrice=entry.getValue().getTotalPrice()+cartTotalPrice;
        }
        return cartTotalPrice;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "items=" + items +
                '}';
    }

}
