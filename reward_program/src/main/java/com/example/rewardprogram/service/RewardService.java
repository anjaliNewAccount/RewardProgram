package com.example.rewardprogram.service;

import com.example.rewardprogram.model.CustomerTransaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RewardService {

    // Method to calculate reward points
    public int calculateRewardPoints(double amount) {
        int points = 0;
        if (amount > 100) {
            points += (amount - 100) * 2 + 50; // 2 points for each dollar over $100
        } else if (amount > 50) {
            points += (amount - 50); // 1 point for each dollar between $50 and $100
        }
        return points;
    }

    // Calculate total reward points for a customer
    public int calculateTotalRewards(List<CustomerTransaction> transactions) {
        return transactions.stream()
                .mapToInt(transaction -> calculateRewardPoints(transaction.getPurchaseAmount()))
                .sum();
    }
}
