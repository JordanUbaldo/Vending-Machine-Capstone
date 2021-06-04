package com.vendingmachine;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class VendingMachine {

    public static void main(String[] args) {
        Location vendingMachine = new Location();
        Map<String, Product> products = vendingMachine.getProducts();

        //Tests
        System.out.println(products.get("C2").getProductMessage());
        for (String product: products.keySet()) {
            System.out.println(products.get(product).getName());
        }
    }
}