package com.bookproject.bean;

import java.util.Date;

/**
 * @author jh
 * @create 2021-06-18-15:19
 */
public class Order {
    private String orderId;
    private Date createTime;
    private Float price;
    private Integer status;
    private String username;

    public Order() {
    }

    public Order(String orderId, Date createTime, Float price, Integer status) {
        this.orderId = orderId;
        this.createTime = createTime;
        this.price = price;
        this.status = status;
    }

    public Order(String orderId, Date createTime, Float price, Integer status, String username) {
        this.orderId = orderId;
        this.createTime = createTime;
        this.price = price;
        this.status = status;
        this.username = username;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "order{" +
                "orderId='" + orderId + '\'' +
                ", createTime=" + createTime +
                ", price=" + price +
                ", status=" + status +
                ", username='" + username + '\'' +
                '}';
    }
}
