package org.learning.springboot.oracle.service;

import lombok.extern.slf4j.Slf4j;
import org.learning.springboot.mongodb.repositories.CustomerRepository;
import org.learning.springboot.oracle.domain.SignUpDetails;
import org.learning.springboot.oracle.repositories.SignUpRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;

@Service
@Slf4j
public class SignUpServiceImpl implements SignUpService{

    @Inject
    private SignUpRepository signUpRepository;

    @Override
    @Transactional
    public void saveSignUpDetails(SignUpDetails signUpDetails) {

        signUpRepository.save(signUpDetails);

        log.debug(String.format("Signup details saved with Mobile %s", signUpDetails.getMobile()));

        System.out.println(String.format(" >>>>>>>>>>>>>>>>> Signup details saved with Mobile %s", signUpDetails.getMobile()));
    }

    @Override
    public SignUpDetails getUserDetailsByMobile(String mobile) {

        SignUpDetails signUpDetails = signUpRepository.findByMobile(mobile);

        log.debug(String.format("Signup details %s", signUpDetails));

        return signUpDetails;
    }
}
