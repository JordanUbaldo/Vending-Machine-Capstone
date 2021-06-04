package com.vendingmachine;

public class Product {

    private String name;
    private String price;
    private String category;
    private int stock = 5;

    public Product(String name, String price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getProductMessage() {
        switch (category) {
            case "Candy":
                return "Munch Munch, Yum!";
            case "Chip":
                return "Crunch Crunch, Yum!";
            case "Drink":
                return "Glug Glug, Yum!";
            case "Gum":
                return "Chew Chew, Yum!";
            default:
                return "This item has no message! :(";
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getStock() {
        return stock;
    }
}