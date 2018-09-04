package ru.sergio.testmvc.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

public class Order {
    private String seller;

    private String customer;

    private List<Product> products;

    public Order() {
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
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
                "seller='" + seller + '\'' +
                ", customer='" + customer + '\'' +
                ", products=" + products +
                '}';
    }
}
