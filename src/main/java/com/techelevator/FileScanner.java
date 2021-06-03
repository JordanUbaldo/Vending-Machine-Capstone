package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileScanner {

    public static void main(String[] args) throws FileNotFoundException {

        File inputFile = new File("vendingmachine.csv");
        List<Location> products = new ArrayList<>();

        try (Scanner fileScanner = new Scanner(inputFile)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] lineArray = line.split("\\|", 4);
                if (lineArray[0].startsWith("A1")) {
                    Location a1 = new Location(lineArray[1], lineArray[2], lineArray[3]);
                    products.add(a1);
                } else if (lineArray[0].startsWith("A2")) {
                    Location a2 = new Location(lineArray[1], lineArray[2], lineArray[3]);
                    products.add(a2);
                } else if (lineArray[0].startsWith("A3")) {
                    Location a3 = new Location(lineArray[1], lineArray[2], lineArray[3]);
                    products.add(a3);
                } else if (lineArray[0].startsWith("A4")) {
                    Location a4 = new Location(lineArray[1], lineArray[2], lineArray[3]);
                    products.add(a4);
                } else if (lineArray[0].startsWith("B1")) {
                    Location b1 = new Location(lineArray[1], lineArray[2], lineArray[3]);
                    products.add(b1);
                } else if (lineArray[0].startsWith("B2")) {
                    Location b2 = new Location(lineArray[1], lineArray[2], lineArray[3]);
                    products.add(b2);
                } else if (lineArray[0].startsWith("B3")) {
                    Location b3 = new Location(lineArray[1], lineArray[2], lineArray[3]);
                    products.add(b3);
                } else if (lineArray[0].startsWith("B4")) {
                    Location b4 = new Location(lineArray[1], lineArray[2], lineArray[3]);
                    products.add(b4);
                } else if (lineArray[0].startsWith("C1")) {
                    Location c1 = new Location(lineArray[1], lineArray[2], lineArray[3]);
                    products.add(c1);
                } else if (lineArray[0].startsWith("C2")) {
                    Location c2 = new Location(lineArray[1], lineArray[2], lineArray[3]);
                    products.add(c2);
                } else if (lineArray[0].startsWith("C3")) {
                    Location c3 = new Location(lineArray[1], lineArray[2], lineArray[3]);
                    products.add(c3);
                } else if (lineArray[0].startsWith("C4")) {
                    Location c4 = new Location(lineArray[1], lineArray[2], lineArray[3]);
                    products.add(c4);
                } else if (lineArray[0].startsWith("D1")) {
                    Location d1 = new Location(lineArray[1], lineArray[2], lineArray[3]);
                    products.add(d1);
                } else if (lineArray[0].startsWith("D2")) {
                    Location d2 = new Location(lineArray[1], lineArray[2], lineArray[3]);
                    products.add(d2);
                } else if (lineArray[0].startsWith("D3")) {
                    Location d3 = new Location(lineArray[1], lineArray[2], lineArray[3]);
                    products.add(d3);
                } else if (lineArray[0].startsWith("D4")) {
                    Location d4 = new Location(lineArray[1], lineArray[2], lineArray[3]);
                    products.add(d4);
                }
            }
        }
    }
}
