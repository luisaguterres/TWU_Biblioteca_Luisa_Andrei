package com.twu.biblioteca;

public abstract class Product {
    private String category;

    public Product(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
