package com.example.rewardprogram.model;

import java.time.LocalDate;

public class CustomerTransaction {

    private String customerId;
    private double purchaseAmount;
    private LocalDate transactionDate;

    // Constructor
    public CustomerTransaction(String customerId, double purchaseAmount, LocalDate transactionDate) {
        this.customerId = customerId;
        this.purchaseAmount = purchaseAmount;
        this.transactionDate = transactionDate;
    }

    // Getters and Setters
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public double getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(double purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }
}
