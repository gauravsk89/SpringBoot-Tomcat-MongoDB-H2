package org.learning.springboot.oracle.api;

import lombok.extern.slf4j.Slf4j;
import org.learning.springboot.oracle.domain.SignUpDetails;
import org.learning.springboot.oracle.service.SignUpService;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Component
@Path("sign-up")
@Slf4j
public class SignUpApi {

    @Inject
    private SignUpService signUpService;

    @POST
    @Path("/")
    @Consumes(APPLICATION_JSON)
    public Response signUp(SignUpDetails signUpDetails){

        signUpService.saveSignUpDetails(signUpDetails);

        return Response
                .created(null)
                .build();

    }

    @GET
    @Path("/{mobile}")
    @Produces(APPLICATION_JSON)
    public Response getSignupDetailsByMobile(@PathParam("mobile") String mobile){

        log.debug(String.format("Request to get signup details for mobile %s", mobile));

        SignUpDetails signUpDetails = signUpService.getUserDetailsByMobile(mobile);

        return Response
                .ok()
                .entity(signUpDetails)
                .build();
    }

    @GET
    @Path("/test")
    @Produces(APPLICATION_JSON)
    public Response testApi(){

        return Response
                .ok()
                .entity("Your app seems to be working fine.")
                .build();


    }

}
