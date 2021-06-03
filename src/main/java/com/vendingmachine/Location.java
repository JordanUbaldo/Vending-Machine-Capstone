package com.vendingmachine;

import java.util.Map;

public class Location {

    private Map<String, Product> products;

    public Location(Map<String, Product> products) {
        this.products = products;
    }

    public Map<String, Product> getProducts() {
        return products;
    }

    public void setProducts(Map<String, Product> products) {
        this.products = products;
    }
}

// Maybe use to contain map?