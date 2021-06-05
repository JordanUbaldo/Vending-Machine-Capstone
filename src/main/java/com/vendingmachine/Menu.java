package com.vendingmachine;

import java.util.Map;
import java.util.Scanner;

public class Menu extends VendingMachine {

    private static VendingMachine vendoMatic = new VendingMachine();
    private static Map<String, Product> products = vendoMatic.getProducts();

    public static void main(String[] args) {
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
            userInput1 = Menu.menuValidation(userInput1);

            if (userInput1.equals("1")) {
                for (String product : products.keySet()) {
                    System.out.println(product + ", $" + products.get(product).getPrice() + " " + products.get(product).getName() + ", " + "Stock: " + products.get(product).getStock());
                }

            } else if (userInput1.equals("2")) {
                Customer customer = new Customer();

                String userInput2 = "";
                while (userInput2 != "3") {
                    System.out.println("(1) Feed Money");
                    System.out.println("(2) Select Product");
                    System.out.println("(3) Finish Transaction");
                    System.out.println("\nCurrent Money Provided: $" + customer.getTotalMoney());
                    System.out.println("\nSelect Your Option:");

                    userInput2 = scan.nextLine();
                    userInput2 = Menu.menuValidation(userInput2);

                    if (userInput2.equals("1")) {
                        System.out.println("Enter Amount (Only Whole Dollars):");
                        String userInput3 = scan.nextLine();

                        try {
                            customer.feedMoney(userInput3);
                        } catch (Exception e) {
                            System.out.println("\nMust Be Whole Dollar Amount!");
                        }

                    } else if (userInput2.equals("2")) {
                        for (String product : products.keySet()) {
                            System.out.println(product + ", $" + products.get(product).getPrice() + " " + products.get(product).getName() + ", " + "Stock: " + products.get(product).getStock());
                        }

                        System.out.println("\nSelect Your Option:");
                        String userInput3 = scan.nextLine().toUpperCase();

                        if (!products.containsKey(userInput3)) {
                            System.out.println("Invalid Option!\n");
                        } else if (Double.parseDouble(products.get(userInput3).getPrice()) > customer.getTotalMoney()) {
                            System.out.println("Not Enough Funds!\n");
                        } else if (products.get(userInput3).getStock().equals("Sold Out!")) {
                            System.out.println(products.get(userInput3).getName() + " Is Sold Out!\n");
                        } else {
                            customer.purchaseProduct(products.get(userInput3));
                            products.get(userInput3).itemPurchased();
                            System.out.println(products.get(userInput3).getName() + ", Cost: $" + products.get(userInput3).getPrice() + ", Money Remaining: $" + customer.getTotalMoney());
                            System.out.println("\n" + products.get(userInput3).getProductMessage() + "\n");
                        }

                    } else if (userInput2.equals("3")) {
                        System.out.println("Change Returned: " + customer.getChange());
                        System.out.println("\nCurrent Money Provided: " + customer.getTotalMoney());
                        break;
                    } else {
                        System.out.println("Invalid Option!\n");
                    }
                }

            } else if (userInput1.equals("3")) {
                System.exit(0);

            } else {
                System.out.println("Invalid Option!");
            }
        }
    }

    public static String menuValidation (String input) {
        if (input.equals("1") || input.equals("2") || input.equals("3")) {
            return input;
        }
        return "";
    }
}