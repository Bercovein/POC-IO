package com.example.pocio.patterns.strategy;

public class PayByCreditCard implements PayStrategy {

    @Override
    public void pay(int paymentAmount) {
        System.out.println("Paying " + paymentAmount + " using Credit Card. Please type your security number.");
    }

}