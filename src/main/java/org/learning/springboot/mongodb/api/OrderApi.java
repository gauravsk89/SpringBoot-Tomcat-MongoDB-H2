package org.learning.springboot.mongodb.api;

import org.learning.springboot.mongodb.domain.Order;
import org.learning.springboot.mongodb.service.OrderService;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Component
@Path("/orders")
public class OrderApi {

    @Inject
    private OrderService orderService;

    @PUT
    @Path("/")
    @Consumes(APPLICATION_JSON)
    public Response saveOrder(Order order){

        orderService.saveOrder(order);

        return Response
                .created(null)
                .build();
    }

}
