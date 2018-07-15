package org.learning.springboot.oracle.service;

import org.learning.springboot.oracle.domain.SignUpDetails;

public interface SignUpService {

    void saveSignUpDetails(SignUpDetails signUpDetails);


    SignUpDetails getUserDetailsByMobile(String mobile);
}
