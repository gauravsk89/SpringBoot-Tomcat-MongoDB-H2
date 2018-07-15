package org.learning.springboot.oracle.service;

import org.learning.springboot.oracle.domain.User;

public interface UserService {

    /**
     * method to save a new user
     * @param user
     * @return user identifier
     */
    String saveUser(User user);

    /**
     * get user details by given id
     *
     * @param id
     * @return Customer details object
     */
    User getUserById(Long id);

}
