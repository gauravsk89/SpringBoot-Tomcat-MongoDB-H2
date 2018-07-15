package org.learning.springboot.oracle.repositories;

import org.learning.springboot.oracle.domain.SignUpDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignUpRepository extends JpaRepository<SignUpDetails, Long>{

    SignUpDetails findByMobile(String mobile);

}
