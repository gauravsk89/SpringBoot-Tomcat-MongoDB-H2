package org.learning.springboot.mongodb.service;

import org.learning.springboot.mongodb.domain.Order;
import org.learning.springboot.mongodb.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;

@Service
public class OrderServiceImpl implements OrderService{

    @Inject
    private OrderRepository orderRepository;

    @Override
    @Transactional
    public void saveOrder(Order order) {
        orderRepository.saveOrder(order);
    }
}
