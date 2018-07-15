package org.learning.springboot.mongodb.repositories;

import org.learning.springboot.mongodb.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {



}
