package org.learning.springboot.mongodb.service;

import org.learning.springboot.mongodb.domain.Customer;

import java.util.List;

public interface CustomerService {

    void saveCustomer(Customer customer);

    List<Customer> findAllCustomers();

    Customer findCustomer(String id);

    void deleteCustomer(String id);

    void updateCustomer(Customer customer);
}
