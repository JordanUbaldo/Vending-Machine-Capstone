package com.vendingmachine;

public class Product {
    private String name;
    private String price;
    private String category;
    private int stock = 5;
    private String slot;

    public Product(String slot, String name, String price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.slot = slot;
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
                return "This Item Has No Message!";
        }
    }

    public void itemPurchased() {
        stock--;
    }

    public String getStock() {
        if (stock > 0) {
            return String.valueOf(stock);
        } else {
            return "Sold Out!";
        }
    }

    public String getSlot() {
        return slot;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }
}