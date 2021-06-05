package com.vendingmachine;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Map;
import java.util.Scanner;

public class VendingMachineTest {

    private VendingMachine objectUnderTest;

    @Before
    public void new_vending_machine() {
        objectUnderTest = new VendingMachine();
    }

    @Test
    public void test_get_products() {
        Product expectedProduct = new Product("A1", "Potato Crisps", "3.05", "Chip");
        String expectedSlot = expectedProduct.getSlot();
        Map<String, Product> testProducts = objectUnderTest.getProducts();
        Product testProduct = testProducts.get("A1");
        String output = testProduct.getSlot();
        Assert.assertEquals(expectedSlot, output);
    }

    @Test
    public void test_add_to_log() {
        String output = "";
        objectUnderTest.addToLog("Testing Add To Log");
       File testFile = new File("/Users/student/workspace/java-capstone-module-1-team-7/log.txt");
        try (Scanner fileScanner = new Scanner(testFile)) {
            while (fileScanner.hasNextLine()) {
                String lineTest = fileScanner.nextLine();
                if (lineTest.contains("Testing Add To Log")) {
                    output = "It works!";
                }
            }
        } catch (Exception e) {
            output = "";
        }
        Assert.assertEquals("It works!", output);
    }
}
