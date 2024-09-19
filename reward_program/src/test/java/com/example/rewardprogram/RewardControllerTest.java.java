package com.example.rewardprogram;

import com.example.rewardprogram.controller.RewardController;
import com.example.rewardprogram.model.CustomerTransaction;
import com.example.rewardprogram.service.RewardService;
import com.example.rewardprogram.repository.RewardRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
public class RewardControllerTest {

    @InjectMocks
    private RewardController rewardController;

    @Mock
    private RewardService rewardService;

    @Mock
    private RewardRepository rewardRepository;

    public RewardControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetRewards() {
        // Arrange
        String customerId = "12345";
        CustomerTransaction transaction1 = new CustomerTransaction(customerId, 100.0, LocalDate.now());
        CustomerTransaction transaction2 = new CustomerTransaction(customerId, 150.0, LocalDate.now().minusDays(1));
        List<CustomerTransaction> transactions = Arrays.asList(transaction1, transaction2);

        when(rewardRepository.getCustomerTransactions(customerId)).thenReturn(transactions);
        when(rewardService.calculateTotalRewards(transactions)).thenReturn(250); // assuming 1 point per dollar

        // Act
        String response = rewardController.getRewards(customerId);

        // Assert
        assertThat(response).contains("Total reward points for customer " + customerId + ": 250");
    }
}
