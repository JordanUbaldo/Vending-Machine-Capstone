package com.vendingmachine;

public class Customer {

    private double totalMoney = 0.00;

    public void feedMoney(String moneyInput) {
        if (Double.parseDouble(moneyInput) % 1 ==0) {
            this.totalMoney+= Double.parseDouble(moneyInput);
        } else {
            System.out.println("Must be whole dollar amount!");
            System.out.println();
        }
    }

    public void purchaseProduct(Product product) {
        totalMoney -= Double.parseDouble(product.getPrice());
    }

    public double getTotalMoney() {
        return totalMoney;
    }
}
