package org.learning.springboot.mongodb.service;

import org.learning.springboot.mongodb.domain.Customer;
import org.learning.springboot.mongodb.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Inject
    private CustomerRepository customerRepository;

    @Override
    @Transactional
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {

        Customer existing = customerRepository.findOne(customer.getId());

        existing.setName(customer.getName());
        existing.setEmail(customer.getEmail());

        customerRepository.save(existing);

    }

    @Override
    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findCustomer(String id) {
        return customerRepository.findOne(id);
    }

    @Override
    public void deleteCustomer(String id) {
        customerRepository.delete(id);
    }

}
