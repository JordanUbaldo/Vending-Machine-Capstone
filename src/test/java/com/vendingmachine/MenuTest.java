package com.vendingmachine;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MenuTest {
    private Menu objectUnderTest;

    @Before
    public void new_menu() {
        objectUnderTest = new Menu();
    }

    @Test
    public void invalid_menu_input_returns_blank_string() {
        String testInput = "5";
        String output = Menu.menuValidation(testInput);
        Assert.assertEquals("", output);
    }

    @Test
    public void valid_menu_input_returns_input() {
        String testInput = "1";
        String output = Menu.menuValidation(testInput);
        Assert.assertEquals("1", output);
    }
}
