package com.vendingmachine;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CustomerTest {
    private Customer objectUnderTest;

    @Before
    public void new_customer() {
        objectUnderTest = new Customer();
    }

    @Test
    public void double_rounding_returns_1_nickel() {
        objectUnderTest.setTotalMoney(86.8);
        String output = objectUnderTest.getChange();
        Assert.assertEquals("Quarters [347] Dimes [0] Nickels [1]", output);
    }

    @Test
    public void double_rounding_returns_1_dime_1_nickel() {
        objectUnderTest.setTotalMoney(86.15);
        String output = objectUnderTest.getChange();
        Assert.assertEquals("Quarters [344] Dimes [1] Nickels [1]", output);
    }

    @Test
    public void test_feed_money() {
        objectUnderTest.feedMoney("20");
        double output = objectUnderTest.getTotalMoney();
        Assert.assertEquals(20.0, output, 0.0);
    }

    @Test
    public void test_feed_money_not_whole_dollar() {
        objectUnderTest.feedMoney("19.23");
        double output = objectUnderTest.getTotalMoney();
        Assert.assertEquals(0, output, 0.0);
    }

    @Test
    public void test_feed_money_negative() {
        objectUnderTest.feedMoney("-10");
        double output = objectUnderTest.getTotalMoney();
        Assert.assertEquals(0, output, 0.0);
    }

    @Test
    public void test_purchase_product() {
        Product testProduct = new Product("A1", "Doritos", "2.85", "Chip");
        objectUnderTest.setTotalMoney(10);
        objectUnderTest.purchaseProduct(testProduct);
        double output = objectUnderTest.getTotalMoney();
        Assert.assertEquals(7.15, output, 0.0);
    }
}
