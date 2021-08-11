package com.bookproject.bean;

/**
 * @author jh
 * @create 2021-06-18-15:22
 */
public class OrderItem {
    private String  id;
    private String bid;

    private String name;

    private String author;
    private Float price;
    private Integer count;
    private Float totalPrice;
    private String orderId;
    public OrderItem() {
    }

    public OrderItem(String id, String bid, String name, String author, Float price, Integer count, Float totalPrice, String orderId) {
        this.id = id;
        this.bid = bid;
        this.name = name;
        this.author = author;
        this.price = price;
        this.count = count;
        this.totalPrice = totalPrice;
        this.orderId = orderId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id='" + id + '\'' +
                ", bid='" + bid + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", totalPrice=" + totalPrice +
                ", orderId='" + orderId + '\'' +
                '}';
    }

}
