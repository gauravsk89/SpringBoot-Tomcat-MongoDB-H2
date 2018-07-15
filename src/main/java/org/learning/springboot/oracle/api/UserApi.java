package org.learning.springboot.oracle.api;

import io.swagger.annotations.Api;
import org.learning.springboot.oracle.domain.User;
import org.learning.springboot.oracle.service.UserService;
import org.learning.springboot.util.ApiLinkBuilder;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Component
@Path("/users")
@Api(value = "Customer Api", description = "Api to perform user CRUD operations")
public class UserApi {

    @Inject
    private ApiLinkBuilder apiLinkBuilder;

    @Inject
    private UserService userService;

    @POST
    @Path("/")
    @Consumes(APPLICATION_JSON)
    public Response saveUser(
            @Context UriInfo uriInfo,
            User user){

        System.out.println("uriInfo = [" + uriInfo + "], user = [" + user + "]");

        String userId = userService.saveUser(user);
        URI uri = apiLinkBuilder.createObjectLink(uriInfo, userId);

        return Response.
                created(uri)
                .build();
    }

    @GET
    @Path("/{id}")
    @Produces(APPLICATION_JSON)
    public Response getUser(@PathParam("id") Long id){

        User user = userService.getUserById(id);

        return Response
                .ok()
                .entity(user)
                .build();
    }

}