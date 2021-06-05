package com.vendingmachine;

import java.text.DecimalFormat;

public class Customer extends VendingMachine {

    private double totalMoney = 0.00;
    private DecimalFormat df = new DecimalFormat("0.00");

    public void feedMoney(String moneyInput) {
        if (Double.parseDouble(moneyInput) % 1 ==0) {
            Double fedMoney = Double.parseDouble(moneyInput);
            this.totalMoney += fedMoney;
            addToLog("FEED MONEY: $" + fedMoney + " $" + totalMoney);
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

        int numQuarters = (int) Math.round((totalMoney - modQuarters) / quarter);
        int numDimes = (int) Math.round((modQuarters-modDimes) / dime);
        int numNickels = (int) Math.round((modDimes-modNickels) / nickel);
        double amountOfChange = totalMoney;
        totalMoney -= (numQuarters * quarter) + (numDimes * dime) + (numNickels * nickel);
        addToLog("GIVE CHANGE: $" + amountOfChange + " $" + totalMoney);
        return "Quarters: " + numQuarters + " Dimes: " + numDimes + " Nickels: " + numNickels;
    }

    public void purchaseProduct(Product product) {
        double moneyBeforePurchase = totalMoney;
        totalMoney -= Double.parseDouble(product.getPrice());

        addToLog(product.getName() + " " + product.getSlot() + " $" + moneyBeforePurchase + " $" + totalMoney);
    }

    public double getTotalMoney() {
        String total = df.format(totalMoney);
        totalMoney = Double.parseDouble(total);

    return totalMoney;
    }
}
