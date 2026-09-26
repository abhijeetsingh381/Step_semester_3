package main.java.basics.class_problems;

import java.util.Scanner;

abstract class Payment {
    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public abstract double calculateAmount();

    public abstract String getType();
}

class CardPayment extends Payment {

    public CardPayment(double amount) {
        super(amount);
    }

    public double calculateAmount() {
        return amount + (amount * 0.02);
    }

    public String getType() {
        return "CARD";
    }
}

class WalletPayment extends Payment {

    public WalletPayment(double amount) {
        super(amount);
    }

    public double calculateAmount() {
        return amount + (amount * 0.01);
    }

    public String getType() {
        return "WALLET";
    }
}

class BankTransfer extends Payment {

    public BankTransfer(double amount) {
        super(amount);
    }

    public double calculateAmount() {
        return amount;
    }

    public String getType() {
        return "BANKTRANSFER";
    }
}

public class PaymentSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double amount = sc.nextDouble();

            Payment payment;

            if (type.equals("CARD")) {
                payment = new CardPayment(amount);
            } else if (type.equals("WALLET")) {
                payment = new WalletPayment(amount);
            } else {
                payment = new BankTransfer(amount);
            }

            double result = payment.calculateAmount();

            System.out.printf("%s: %.2f%n",
                    payment.getType(), result);

            total = total + result;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}