package com.vendingmachine;

import java.text.DecimalFormat;

public class Customer extends VendingMachine {
    private double totalMoney = 0.00;
    private DecimalFormat df = new DecimalFormat("0.00");

    public void feedMoney(String moneyInput) {
        if (Double.parseDouble(moneyInput) % 1 == 0 && Double.parseDouble(moneyInput) > 0) {
            double fedMoney = Double.parseDouble(moneyInput);
            this.totalMoney += fedMoney;
            addToLog("FEED MONEY: $" + fedMoney + " $" + totalMoney);
        } else {
            System.out.println("Must be whole dollar amount!");
        }
    }

    public String getChange() {
        double quarter = 25;
        double dime = 10;
        double nickel = 5;

        double modQuarters = (totalMoney * 100) % quarter;
        double modDimes = modQuarters % dime;
        double modNickels = modDimes % nickel;

        int numQuarters = (int) Math.round(((totalMoney * 100) - modQuarters) / quarter);
        int numDimes = (int) Math.round((modQuarters - modDimes) / dime);
        int numNickels = (int) Math.round((modDimes - modNickels) / nickel);

        double amountOfChange = totalMoney;
        totalMoney -= (numQuarters * (quarter / 100) + (numDimes * (dime / 100)) + (numNickels * (nickel / 100)));

        addToLog("GIVE CHANGE: $" + amountOfChange + " $" + totalMoney);
        return "Quarters [" + numQuarters + "] Dimes [" + numDimes + "] Nickels [" + numNickels + "]";
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

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }
}
