package com.ssafy.vo;

public class Product {
    private String num; // 임의 추가
    private String code;
    private String model;
    private String price;

    public Product(String code, String model, String price) {
        this.code = code; //PK
        this.model = model;
        this.price = price;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
