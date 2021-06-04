package com.vendingmachine;

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
                products.get("A1").itemPurchased();
                for (String product : products.keySet()) {
                    System.out.println(product + ", " + products.get(product).getName() + ", Stock: " + products.get(product).getStock());
                }
                System.out.println("");
            } else if (userInput.equals("2")) {

            } else if (userInput.equals("3")) {
                System.exit(0);
            } else {
                System.out.println("Invalid option");

            }
        }
    }
}
// Need to finish and set up customer class.