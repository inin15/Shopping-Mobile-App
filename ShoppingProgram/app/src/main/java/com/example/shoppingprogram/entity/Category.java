package com.example.shoppingprogram.entity;

public class Category {
    private int imgCategory;
    private String nameCategory;
    public Category(int imgCategory, String nameCategory) {
        this.imgCategory = imgCategory;
        this.nameCategory = nameCategory;
    }
    public int getImgCategory() {
        return imgCategory;
    }
    public String getNameCategory() {
        return nameCategory;
    }
    public void setImgCategory(int imgCategory) {
        this.imgCategory = imgCategory;
    }
    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
}
