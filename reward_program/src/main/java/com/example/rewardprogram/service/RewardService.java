package com.example.rewardprogram.service;

import com.example.rewardprogram.model.CustomerTransaction;
import com.example.rewardprogram.model.Customer;
import com.example.rewardprogram.repository.RewardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RewardService {

    private final RewardRepository rewardRepository;

    public RewardService(RewardRepository rewardRepository) {
        this.rewardRepository = rewardRepository;
    }

    public Customer getCustomerWithRewards(String customerId) {
        Customer customer = rewardRepository.getCustomer(customerId);
        List<CustomerTransaction> transactions = rewardRepository.getCustomerTransactions(customerId);
        int totalRewards = calculateTotalRewards(transactions);
        customer.setTotalRewards(totalRewards);
        return customer;
    }

    public int calculateTotalRewards(List<CustomerTransaction> transactions) {
        return transactions.stream()
                           .mapToInt(CustomerTransaction::getRewardPoints)
                           .sum();
    }

    public void addCustomer(Customer customer) {
        rewardRepository.addCustomer(customer);
    }

    public void updateCustomer(String customerId, Customer updatedCustomer) {
        rewardRepository.updateCustomer(customerId, updatedCustomer);
    }

    public void deleteCustomer(String customerId) {
        rewardRepository.deleteCustomer(customerId);
    }
}
