package com.example.rewardprogram.service;

import com.example.rewardprogram.model.CustomerTransaction;
import com.example.rewardprogram.repository.RewardRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RewardServiceTest {

    @Test
    public void testCalculateTotalRewards() {
        RewardRepository rewardRepository = Mockito.mock(RewardRepository.class);
        RewardService rewardService = new RewardService(rewardRepository);

        List<CustomerTransaction> transactions = Arrays.asList(
                new CustomerTransaction("CUST001", 50),
                new CustomerTransaction("CUST001", 20)
        );

        int totalRewards = rewardService.calculateTotalRewards(transactions);
        assertEquals(70, totalRewards);
    }
}
