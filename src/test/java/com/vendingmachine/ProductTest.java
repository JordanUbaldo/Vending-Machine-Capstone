package com.vendingmachine;

import org.junit.Assert;
import org.junit.Test;

public class ProductTest {

    @Test
    public void test_item_purchased() {
        Product objectUnderTest = new Product("A1", "Snickers", "2.80", "Candy");
        objectUnderTest.itemPurchased();
        objectUnderTest.itemPurchased();
        objectUnderTest.itemPurchased();
        String output = objectUnderTest.getStock();
        Assert.assertEquals("2", output);
    }

    @Test
    public void test_item_sold_out() {
        Product objectUnderTest = new Product("A1", "Snickers", "2.80", "Candy");
        objectUnderTest.itemPurchased();
        objectUnderTest.itemPurchased();
        objectUnderTest.itemPurchased();
        objectUnderTest.itemPurchased();
        objectUnderTest.itemPurchased();
        objectUnderTest.itemPurchased();
        objectUnderTest.itemPurchased();
        String output = objectUnderTest.getStock();
        Assert.assertEquals("Sold Out!", output);
    }

    @Test
    public void test_get_product_message_candy() {
        Product objectUnderTest = new Product("A1", "Snickers", "2.80", "Candy");
        String output = objectUnderTest.getProductMessage();
        Assert.assertEquals("Munch Munch, Yum!", output);
    }

    @Test
    public void test_get_product_message_chip() {
        Product objectUnderTest = new Product("A2", "Doritos", "2.80", "Chip");
        String output = objectUnderTest.getProductMessage();
        Assert.assertEquals("Crunch Crunch, Yum!", output);
    }

    @Test
    public void test_get_product_message_drink() {
        Product objectUnderTest = new Product("A3", "Water", "2.80", "Drink");
        String output = objectUnderTest.getProductMessage();
        Assert.assertEquals("Glug Glug, Yum!", output);
    }

    @Test
    public void test_get_product_message_gum() {
        Product objectUnderTest = new Product("A4", "Five Gum", "2.80", "Gum");
        String output = objectUnderTest.getProductMessage();
        Assert.assertEquals("Chew Chew, Yum!", output);
    }

    @Test
    public void test_get_product_message_no_message() {
        Product objectUnderTest = new Product("B1", "Cupcake", "2.80", "Cake");
        String output = objectUnderTest.getProductMessage();
        Assert.assertEquals("This Item Has No Message!", output);
    }
}
