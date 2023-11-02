package com.example.shoppingprogram.entity;

public class Product {
    private int productId;
    private String description;
    public Product(int productId, String description) {
        this.productId = productId;
        this.description = description;
    }
    public int getProductId() {
        return productId;
    }
    public String getDescription() {
        return description;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
