package com.bookproject.bean;

import java.util.Date;

/**
 * @author jh
 * @create 2021-06-18-15:19
 */
public class Store {

    private String orderId;
    private Date createTime;
    private Integer status;

    public Store() {
    }

    public Store(String orderId, Date createTime, Integer status) {
        this.orderId = orderId;
        this.createTime = createTime;
        this.status = status;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Store{" +
                "orderId='" + orderId + '\'' +
                ", createTime=" + createTime +
                ", status=" + status +
                '}';
    }
}
