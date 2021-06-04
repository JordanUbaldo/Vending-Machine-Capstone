package com.vendingmachine;

import java.text.DecimalFormat;

public class Customer {

    private double totalMoney = 0.00;
    private DecimalFormat df = new DecimalFormat("0.00");

    public void feedMoney(String moneyInput) {
        if (Double.parseDouble(moneyInput) % 1 ==0) {
            this.totalMoney+= Double.parseDouble(moneyInput);
        } else {
            System.out.println("Must be whole dollar amount!");
            System.out.println();
        }
    }

    public String getChange() {
        double quarter = 0.25;
        double dime = 0.10;
        double nickel = 0.05;

        double modQuarters = totalMoney % quarter;
        double modDimes = modQuarters % dime;
        double modNickels = modDimes % nickel;

        int numQuarters = (int) Math.rint((totalMoney - modQuarters) / quarter);
        int numDimes = (int) Math.rint((modQuarters-modDimes) / dime);
        int numNickels = (int) Math.rint((modDimes-modNickels) / nickel);
        totalMoney -= (numQuarters * quarter) + (numDimes * dime) + (numNickels * nickel);

        return "Quarters: " + numQuarters + " Dimes: " + numDimes + " Nickels: " + numNickels;
    }

    public void purchaseProduct(Product product) {
        totalMoney -= Double.parseDouble(product.getPrice());
    }

    public double getTotalMoney() {
        String total = df.format(totalMoney);
        totalMoney = Double.parseDouble(total);

    return totalMoney;
    }
}
