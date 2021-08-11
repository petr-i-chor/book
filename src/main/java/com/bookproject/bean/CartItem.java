package com.bookproject.bean;

/**
 * @author jh
 * @create 2021-06-16-16:36
 */
public class CartItem {

    private String  id;
    private String name;
    private String author;
    private Float price;
    private Integer count;
    private Integer stock;

    private Float totalPrice;

    public CartItem() {
    }

    public CartItem(String id, String name, String author, Float price, Integer count, Integer stock, Float totalPrice) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.count = count;
        this.stock = stock;
        this.totalPrice = totalPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
