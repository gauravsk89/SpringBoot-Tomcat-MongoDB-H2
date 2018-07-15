package org.learning.springboot.mongodb.repositories;

import org.learning.springboot.mongodb.domain.Order;

import java.util.List;

public interface OrderRepository {

    void saveOrder(Order order);

    List<Order> findAllOrders();

    Order findOrder(String id);

    void deleteOrder(String id);

    void updateOrder(Order order);
}
