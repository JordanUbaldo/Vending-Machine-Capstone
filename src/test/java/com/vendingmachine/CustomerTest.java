package com.vendingmachine;

import com.vendingmachine.Customer;
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
}
