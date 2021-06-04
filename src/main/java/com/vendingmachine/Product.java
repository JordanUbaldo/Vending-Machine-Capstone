package com.vendingmachine;

public class Product extends VendingMachine {

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
        if (category.equals("Candy")) {
            return "Munch Munch, Yum!";
        } else if (category.equals("Chip")) {
            return "Crunch Crunch, Yum!";
        } else if (category.equals("Drink")) {
            return "Glug Glug, Yum!";
        } else if (category.equals("Gum")) {
            return "Chew Chew, Yum!";
        } else {
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

    public String getStock() {
        if (stock > 0) {
            return String.valueOf(stock);
        } else {
            return "Sold Out!";
        }
    }

    public void itemPurchased() {
        stock--;
    }
}