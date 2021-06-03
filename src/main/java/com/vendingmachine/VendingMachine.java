package com.vendingmachine;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class VendingMachine {

    public static void main(String[] args) {

        File inputFile = new File("vendingmachine.csv");
        Map<String, Product> products = new HashMap<>();

        try (Scanner fileScanner = new Scanner(inputFile)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] lineArray = line.split("\\|", 4);
                if (lineArray[0].startsWith("A1")) {
                    Product a1 = new Product(lineArray[1], lineArray[2], lineArray[3]);
                    products.put("A1", a1);
                } else if (lineArray[0].startsWith("A2")) {
                    Product a2 = new Product(lineArray[1], lineArray[2], lineArray[3]);
                    products.put("A2", a2);
                } else if (lineArray[0].startsWith("A3")) {
                    Product a3 = new Product(lineArray[1], lineArray[2], lineArray[3]);
                    products.put("A3", a3);
                } else if (lineArray[0].startsWith("A4")) {
                    Product a4 = new Product(lineArray[1], lineArray[2], lineArray[3]);
                    products.put("A4", a4);
                } else if (lineArray[0].startsWith("B1")) {
                    Product b1 = new Product(lineArray[1], lineArray[2], lineArray[3]);
                    products.put("B1", b1);
                } else if (lineArray[0].startsWith("B2")) {
                    Product b2 = new Product(lineArray[1], lineArray[2], lineArray[3]);
                    products.put("B2", b2);
                } else if (lineArray[0].startsWith("B3")) {
                    Product b3 = new Product(lineArray[1], lineArray[2], lineArray[3]);
                    products.put("B3", b3);
                } else if (lineArray[0].startsWith("B4")) {
                    Product b4 = new Product(lineArray[1], lineArray[2], lineArray[3]);
                    products.put("B4", b4);
                } else if (lineArray[0].startsWith("C1")) {
                    Product c1 = new Product(lineArray[1], lineArray[2], lineArray[3]);
                    products.put("C1", c1);
                } else if (lineArray[0].startsWith("C2")) {
                    Product c2 = new Product(lineArray[1], lineArray[2], lineArray[3]);
                    products.put("C2", c2);
                } else if (lineArray[0].startsWith("C3")) {
                    Product c3 = new Product(lineArray[1], lineArray[2], lineArray[3]);
                    products.put("C3", c3);
                } else if (lineArray[0].startsWith("C4")) {
                    Product c4 = new Product(lineArray[1], lineArray[2], lineArray[3]);
                    products.put("C4", c4);
                } else if (lineArray[0].startsWith("D1")) {
                    Product d1 = new Product(lineArray[1], lineArray[2], lineArray[3]);
                    products.put("D1", d1);
                } else if (lineArray[0].startsWith("D2")) {
                    Product d2 = new Product(lineArray[1], lineArray[2], lineArray[3]);
                    products.put("D2", d2);
                } else if (lineArray[0].startsWith("D3")) {
                    Product d3 = new Product(lineArray[1], lineArray[2], lineArray[3]);
                    products.put("D3", d3);
                } else if (lineArray[0].startsWith("D4")) {
                    Product d4 = new Product(lineArray[1], lineArray[2], lineArray[3]);
                    products.put("D4", d4);
                }

            }
        } catch (IOException e) {
            System.out.println("Error: Invalid File");
        } System.out.println(products.get("A1").getProductMessage());
    }
}