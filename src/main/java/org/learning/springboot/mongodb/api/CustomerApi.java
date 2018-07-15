package org.learning.springboot.mongodb.api;

import lombok.extern.slf4j.Slf4j;
import org.learning.springboot.mongodb.domain.Customer;
import org.learning.springboot.mongodb.service.CustomerService;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Component
@Path("/customers")
@Slf4j
public class CustomerApi {

    @Inject
    private CustomerService customerService;

    @POST
    @Path("/")
    @Consumes(APPLICATION_JSON)
    public Response createCustomer(Customer customer) {

        customerService.saveCustomer(customer);

        return Response
                .created(null)
                .build();
    }


    @GET
    @Path("")
    @Produces(APPLICATION_JSON)
    public Response getAllCustomers(){

        List<Customer> customers = customerService.findAllCustomers();

        return Response
                .ok()
                .entity(customers)
                .build();
    }

    @GET
    @Path("/{id}")
    @Produces(APPLICATION_JSON)
    public Response getCustomerById(@PathParam("id") String id){

        Customer customer = customerService.findCustomer(id);

        return Response
                .ok()
                .entity(customer)
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteCustomerById(@PathParam("id") String id){

        customerService.deleteCustomer(id);

        return Response
                .noContent()
                .build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(APPLICATION_JSON)
    public Response updateCustomer(@PathParam("id") String id, Customer customer){

        customerService.updateCustomer(customer);

        return Response
                .noContent()
                .build();
    }

}
