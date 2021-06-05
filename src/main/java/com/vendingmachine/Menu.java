package com.vendingmachine;

import java.util.Map;
import java.util.Scanner;

public class Menu extends VendingMachine {

    public static void main(String[] args) {

        VendingMachine vendoMatic = new VendingMachine();
        Map<String, Product> products = vendoMatic.getProducts();

        Scanner scan = new Scanner(System.in);
        String userInput1 = "";

        while (!userInput1.equals("3")) {

            System.out.println("\n=================================");
            System.out.println("Welcome to the Vendo-Matic 800");
            System.out.println("=================================");
            System.out.println("\n(1) Display Vending Machine Items");
            System.out.println("(2) Purchase");
            System.out.println("(3) Exit");
            System.out.println("\nSelect Your Option:");

            userInput1 = scan.nextLine();
            userInput1 = Menu.mainMenu(userInput1);

            if (userInput1.equals("1")) {

                for (String product : products.keySet()) {
                    System.out.println(product + ", $" + products.get(product).getPrice() + " " + products.get(product).getName() + ", " + "Stock: " + products.get(product).getStock());
                }

            } else if (userInput1.equals("2")) {

                String userInput2 = "";
                Customer customer = new Customer();

                while (userInput2 != "3") {
                    System.out.println("(1) Feed Money");
                    System.out.println("(2) Select Product");
                    System.out.println("(3) Finish Transaction");
                    System.out.println("\nCurrent Money Provided: $" + customer.getTotalMoney());
                    System.out.println("\nSelect Your Option:");

                    userInput2 = scan.nextLine();

                    if (userInput2.equals("1")) {

                        System.out.println("Enter Amount (Only Whole Dollars):");
                        String userInput3 = scan.nextLine();

                        try {
                            customer.feedMoney(userInput3);
                        } catch (Exception e) {
                            System.out.println("\nMust Be Whole Dollar Amount!");
                            System.out.println();
                        }

                    } else if (userInput2.equals("2")) {

                        for (String product : products.keySet()) {
                            System.out.println(product + ", $" + products.get(product).getPrice() + " " + products.get(product).getName() + ", " + "Stock: " + products.get(product).getStock());
                        }

                        System.out.println("\nSelect Your Option:");
                        String userInput3 = scan.nextLine().toUpperCase();

                        if (!products.containsKey(userInput3)) {
                            System.out.println("\nInvalid Option!");
                        } else if (Double.parseDouble(products.get(userInput3).getPrice()) > customer.getTotalMoney()) {
                            System.out.println("\nNot Enough Funds!");
                        } else if (products.get(userInput3).getStock().equals("Sold Out!")) {
                            System.out.println(products.get("\n" + userInput3).getName() + " Is Sold Out!");
                        } else {
                            customer.purchaseProduct(products.get(userInput3));
                            products.get(userInput3).itemPurchased();
                            System.out.println(products.get(userInput3).getName() + ", Cost: $" + products.get(userInput3).getPrice() + ", Money Remaining: $" + customer.getTotalMoney());
                            System.out.println("\n" + products.get(userInput3).getProductMessage());
                        }

                    } else if (userInput2.equals("3")) {
                        System.out.println(customer.getChange());
                        System.out.println("\nCurrent Money Provided: " + customer.getTotalMoney());
                        break;
                    } else {
                        System.out.println("\nInvalid Option!");
                    }
                }

            } else if (userInput1.equals("3")) {
                System.exit(0);

            } else {
                System.out.println("Invalid Option!");
            }
        }
    }

    public static String mainMenu(String input) {

        if (input.equals("1") || input.equals("2") || input.equals("3")) {
            return input;
        }
        return "";
    }
}