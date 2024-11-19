package com.himanshu.esd.esd_yummy.repo;


import com.himanshu.esd.esd_yummy.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
    Optional<Customer> findByEmail(String email);
    // optinal means taht data may or may not present
}
