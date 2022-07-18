package com.example.pocio.patterns.strategy;

public class PayByPayPal implements PayStrategy {

    @Override
    public void pay(int paymentAmount) {
        System.out.println("Paying " + paymentAmount + " using PayPal. Redirecting to the page.");
    }

}
