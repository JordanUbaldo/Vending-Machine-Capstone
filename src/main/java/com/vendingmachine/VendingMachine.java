package com.vendingmachine;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.*;

public class VendingMachine {

    public Map<String, Product> getProducts() {
        File inputFile = new File("vendingmachine.csv");
        Map<String, Product> products = new LinkedHashMap<>();

        try (Scanner fileScanner = new Scanner(inputFile)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] lineArray = line.split("\\|", 4);
                Product product = new Product(lineArray[1], lineArray[2], lineArray[3]);
                products.put(lineArray[0], product);

            }

        } catch (IOException e) {
            System.out.println("Error: Invalid File");
        }
        return products;
    }

    public void addToLog(String logInfo) { //fix time, date formatting.

        File log = new File("log.txt");

        try (PrintWriter print = new PrintWriter(new FileWriter(log, true))) {
            print.println(LocalDateTime.now() + " " + logInfo);
        } catch (IOException e) {
            System.out.println("Could Not Add To File");
        }
    }

    public String getSlot(Product product) { //Maybe get rid of this method? Depending on how to get key for log.
        String slot = "";
        for (Map.Entry<String, Product> entry : getProducts().entrySet()) {
            if (entry.getValue().equals(product)) {
                slot = entry.getKey();
            }
        } return slot;
    }
}