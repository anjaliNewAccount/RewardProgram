package com.example.rewardprogram.repository;

import com.example.rewardprogram.model.CustomerTransaction;
import com.example.rewardprogram.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class RewardRepository {

    private static final List<CustomerTransaction> TRANSACTIONS = new ArrayList<>();
    private static final ConcurrentHashMap<String, Customer> CUSTOMERS = new ConcurrentHashMap<>();

    static {
        // Sample customers
        CUSTOMERS.put("CUST001", new Customer("CUST001", "John Doe"));
        CUSTOMERS.put("CUST002", new Customer("CUST002", "Jane Smith"));
    }

    static {
        // Sample transactions
        TRANSACTIONS.add(new CustomerTransaction("CUST001", 50));
        TRANSACTIONS.add(new CustomerTransaction("CUST001", 20));
        TRANSACTIONS.add(new CustomerTransaction("CUST002", 100));
    }

    public Customer getCustomer(String customerId) {
        return CUSTOMERS.get(customerId);
    }

    public List<CustomerTransaction> getCustomerTransactions(String customerId) {
        List<CustomerTransaction> result = new ArrayList<>();
        for (CustomerTransaction transaction : TRANSACTIONS) {
            if (transaction.getCustomerId().equals(customerId)) {
                result.add(transaction);
            }
        }
        return result;
    }

    public void addCustomer(Customer customer) {
        CUSTOMERS.put(customer.getCustomerId(), customer);
    }

    public void updateCustomer(String customerId, Customer updatedCustomer) {
        CUSTOMERS.put(customerId, updatedCustomer);
    }

    public void deleteCustomer(String customerId) {
        CUSTOMERS.remove(customerId);
    }
}
