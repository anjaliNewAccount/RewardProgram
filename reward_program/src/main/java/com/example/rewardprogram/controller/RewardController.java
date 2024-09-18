package com.example.rewardprogram.controller;

import com.example.rewardprogram.service.RewardService;
import com.example.rewardprogram.repository.RewardRepository;
import com.example.rewardprogram.model.CustomerTransaction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RewardController {

    private final RewardService rewardService;
    private final RewardRepository rewardRepository;

    public RewardController(RewardService rewardService, RewardRepository rewardRepository) {
        this.rewardService = rewardService;
        this.rewardRepository = rewardRepository;
    }

    // Endpoint to get total reward points for a customer
    @GetMapping("/rewards")
    public String getRewards(@RequestParam String customerId) {
        List<CustomerTransaction> transactions = rewardRepository.getCustomerTransactions(customerId);
        int totalPoints = rewardService.calculateTotalRewards(transactions);
        return "Total reward points for customer " + customerId + ": " + totalPoints;
    }
}
