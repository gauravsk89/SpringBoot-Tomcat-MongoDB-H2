package org.learning.springboot.configuration;

import org.glassfish.jersey.server.ResourceConfig;
import org.learning.springboot.mongodb.api.CustomerApi;
import org.learning.springboot.mongodb.api.OrderApi;
import org.learning.springboot.oracle.api.SignUpApi;
import org.learning.springboot.oracle.api.UserApi;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("/rest")
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {

		register(UserApi.class);
		register(SignUpApi.class);
		register(CustomerApi.class);
		register(OrderApi.class);

		// registering exception mappers
//		register(ValidationExceptionMapper.class);
//		register(ThrowableMapper.class);
//		register(ApiServiceExceptionMapper.class);
	}

}
