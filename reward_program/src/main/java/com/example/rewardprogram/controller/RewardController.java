package com.example.rewardprogram.controller;

import com.example.rewardprogram.model.CustomerTransaction;
import com.example.rewardprogram.model.Customer;
import com.example.rewardprogram.service.RewardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class RewardController {

    private final RewardService rewardService;

    public RewardController(RewardService rewardService) {
        this.rewardService = rewardService;
    }

    // Endpoint to get total reward points and customer details
    @GetMapping("/{customerId}/rewards")
    public Customer getCustomerRewards(@PathVariable String customerId) {
        return rewardService.getCustomerWithRewards(customerId);
    }

    // Endpoint to add a new customer
    @PostMapping
    public String addCustomer(@RequestBody Customer customer) {
        rewardService.addCustomer(customer);
        return "Customer added successfully!";
    }

    // Endpoint to edit customer details
    @PutMapping("/{customerId}")
    public String editCustomer(@PathVariable String customerId, @RequestBody Customer customer) {
        rewardService.updateCustomer(customerId, customer);
        return "Customer details updated successfully!";
    }

    // Endpoint to delete a customer
    @DeleteMapping("/{customerId}")
    public String deleteCustomer(@PathVariable String customerId) {
        rewardService.deleteCustomer(customerId);
        return "Customer deleted successfully!";
    }
}
