package com.example.chap10;

public class Product {

    private String[] productList;
    private int num1;
    private int num2;

    public Product() {
        this.productList = new String[]{"item1", "item2"};
        this.num1 = 10;
        this.num2 = 20;
    }

    public String[] getProductList() {
        return productList;
    }

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }
}
