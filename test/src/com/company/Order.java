package com.company;

import java.util.List;

public class Order {
    String name;
    List<Product> products;


    public Order(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", products=" + products +
                '}';
    }
}
