package com.twu.biblioteca;

public abstract class Product {
    private String category;
    private boolean checkout;

    public Product(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public boolean hasBeenCheckouted() {
        return checkout;
    }

    public void changeStatus(boolean status) { checkout = status; }

}
