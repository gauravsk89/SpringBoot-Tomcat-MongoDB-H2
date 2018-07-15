package org.learning.springboot.mongodb.service;

import org.learning.springboot.mongodb.domain.Order;

public interface OrderService {

    void saveOrder(Order order);

}
