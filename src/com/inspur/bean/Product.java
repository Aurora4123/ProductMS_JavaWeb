package com.inspur.bean;

/**
 * @Author：齐文勇
 * @Package：com.inspur.bean
 * @Project：ProductMS
 * @name：Product
 * @Date：2024/10/23 9:10
 * @Filename：Product
 * javaBean,pojo
 */
public class Product {
    private  int id;
    private String name;
    private double price;
    private String category;
    private int stock;
    private int state=2;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
