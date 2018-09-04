package ru.sergio.testmvc.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

public class Product {
    private String name;

    private String code;

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
