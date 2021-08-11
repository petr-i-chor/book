package com.bookproject.bean;

/**
 * @author jh
 * @create 2021-06-18-15:22
 */
public class StoreItem {

    private String  id;
    private String orderId;
    private String bid;
    private String name;
    private String author;
    private Integer count;

    public StoreItem() {
    }

    public StoreItem(String id, String orderId, String bid, String name, String author, Integer count) {
        this.id = id;
        this.orderId = orderId;
        this.bid = bid;
        this.name = name;
        this.author = author;
        this.count = count;
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "StoreItem{" +
                "id='" + id + '\'' +
                ", orderId='" + orderId + '\'' +
                ", bid='" + bid + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", count=" + count +
                '}';
    }
}
