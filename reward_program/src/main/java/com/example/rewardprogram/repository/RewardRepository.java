package com.example.rewardprogram.repository;

import com.example.rewardprogram.model.CustomerTransaction;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Repository
public class RewardRepository {

    // Simulate some data for the transactions (static data for now)
    public List<CustomerTransaction> getCustomerTransactions(String customerId) {
        return Arrays.asList(
                new CustomerTransaction(customerId, 120, LocalDate.of(2024, 7, 15)),
                new CustomerTransaction(customerId, 80, LocalDate.of(2024, 8, 10)),
                new CustomerTransaction(customerId, 130, LocalDate.of(2024, 9, 5))
        );
    }
}
