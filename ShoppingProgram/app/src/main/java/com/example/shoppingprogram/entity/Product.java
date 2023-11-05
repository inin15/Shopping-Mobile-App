package com.example.shoppingprogram.entity;

public class Product {
    private int imgProduct;
    private String productName;
    private String productPrice;
    //private int addToCartButton;
    public Product(int imgProduct, String productName, String productPrice) {
        this.imgProduct = imgProduct;
        this.productName = productName;
        this.productPrice = productPrice;
        //this.addToCartButton = addToCartButton;
    }
    public int getImgProduct() {
        return imgProduct;
    }
    public void setImgProduct(int imgProduct) {
        this.imgProduct = imgProduct;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getProductPrice() {
        return productPrice;
    }
    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }
//    public int getAddToCartButton() {
//        return addToCartButton;
//    }
//    public void setAddToCartButton(int addToCartButton) {
//        this.addToCartButton = addToCartButton;
//    }
}
