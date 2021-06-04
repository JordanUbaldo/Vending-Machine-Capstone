package com.vendingmachine;

import java.sql.SQLOutput;
import java.util.Map;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {

        VendingMachine vendoMatic = new VendingMachine();
        Map<String, Product> products = vendoMatic.getProducts();

        Scanner scan = new Scanner(System.in);

        String userInput = "";
        while (userInput != "3") {
            System.out.println("=================================");
            System.out.println("Welcome to the Vendo-Matic 800");
            System.out.println("=================================" + "\n");
            System.out.println("(1) Display Vending Machine Items");
            System.out.println("(2) Purchase");
            System.out.println("(3) Exit");
            System.out.println();
            System.out.println("Select Your Option:");
            userInput = scan.nextLine();

            if (userInput.equals("1")) {
                for (String product : products.keySet()) {
                    System.out.println(product + ", $" + products.get(product).getPrice() + " " + products.get(product).getName() + ", " + "Stock: " + products.get(product).getStock());
                }
                System.out.println();
            } else if (userInput.equals("2")) {
                String userInput2 = "";
                Customer customer = new Customer();
                while (userInput2 != "3") {
                    System.out.println();
                    System.out.println("(1) Feed Money");
                    System.out.println("(2) Select Product");
                    System.out.println("(3) Finish Transaction");
                    System.out.println();
                    System.out.println("Current Money Provided: $" + customer.getTotalMoney());
                    System.out.println();
                    System.out.println("Select Your Option:");
                    userInput2 = scan.nextLine();

                    if (userInput2.equals("1")) {
                        System.out.println();
                        System.out.println("Enter Amount (Only Whole Dollars):");
                        String userInput3 = scan.nextLine();
                        try {
                            customer.feedMoney(userInput3);
                        } catch (Exception e) {
                            System.out.println("Must be whole dollar amount!");
                            System.out.println();
                        }
                    } else if (userInput2.equals("2")) {
                        for (String product : products.keySet()) {
                            System.out.println(product + ", $" + products.get(product).getPrice() + " " + products.get(product).getName() + ", " + "Stock: " + products.get(product).getStock());
                        }
                        // Filter for Sold out or invalid on the user option below. (If else statement?)
                        System.out.println("Select Your Option:");
                        String userInput4 = scan.nextLine().toUpperCase();

                        if (!products.containsKey(userInput4)) {
                            System.out.println("Invalid Option!");
                        } else if (Double.parseDouble(products.get(userInput4).getPrice()) > customer.getTotalMoney()) {
                            System.out.println("Not Enough Funds!");
                        } else if (products.get(userInput4).getStock().equals("Sold Out!")) {
                            System.out.println(products.get(userInput4).getName() + " is sold out!");
                        } else {
                            customer.purchaseProduct(products.get(userInput4));
                            products.get(userInput4).itemPurchased();
                            System.out.println(products.get(userInput4).getName() + ", Cost: $" + products.get(userInput4).getPrice() + ", Money Remaining: $" + customer.getTotalMoney());
                            System.out.println(products.get(userInput4).getProductMessage());
                        }

                    } else if (userInput2.equals("3")) {
                        System.out.println(customer.getChange());
                        System.out.println("Current Money Provided: " + customer.getTotalMoney());
                        break;
                    } else {
                        System.out.println();
                        System.out.println("Invalid option");
                    }
                }

            } else if (userInput.equals("3")) {
                System.exit(0);
            } else {
                System.out.println("Invalid option");
                System.out.println();
            }
        }
    }
}