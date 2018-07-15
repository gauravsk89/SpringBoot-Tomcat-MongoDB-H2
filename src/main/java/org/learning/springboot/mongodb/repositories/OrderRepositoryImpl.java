package org.learning.springboot.mongodb.repositories;

import org.learning.springboot.mongodb.domain.Customer;
import org.learning.springboot.mongodb.domain.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    @Inject
    private MongoTemplate mongoTemplate;


    @Override
    public void saveOrder(Order order) {

        mongoTemplate.save(order);

    }

    @Override
    public List<Order> findAllOrders() {
        return null;
    }

    @Override
    public Order findOrder(String id) {
        return null;
    }

    @Override
    public void deleteOrder(String id) {

    }

    @Override
    public void updateOrder(Order order) {

    }

}
