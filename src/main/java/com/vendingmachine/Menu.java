package com.vendingmachine;

import java.util.Map;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("(1) Display Vending Machine Items");
        System.out.println("(2) Purchase");
        System.out.println("(3) Exit");

        String userInput = scan.nextLine();

        if (userInput.equals("1")) {
        }

        else if (userInput.equals("2")) {
        }

        else if (userInput.equals("3")) {
        }
        else {
            System.out.println("Invalid option");
        }


    }
}

// Need to finish and set up customer class.