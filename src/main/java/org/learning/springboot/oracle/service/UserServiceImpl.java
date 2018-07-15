package org.learning.springboot.oracle.service;

import lombok.extern.slf4j.Slf4j;
import org.learning.springboot.oracle.domain.User;
import org.learning.springboot.oracle.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import javax.inject.Inject;

@Service
@Slf4j
public class UserServiceImpl implements UserService{

    @Value(value = "${test.value}")
    private String value;

    @Inject
    private UserRepository userRepository;

    @Override
    public String saveUser(User user) {

        log.debug(String.format("Read value from property file %s", value));

        System.out.println(String.format(">>>>>>>> Read value from property file %s", value));

        user = userRepository.save(user);

        return user.getId().toString();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findOne(id);
    }
}
