package com.example.demo.Repository;

import com.example.demo.DTO.CustomerDTO;
import com.example.demo.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByMobileNumber(String mobileNumber);//name has to be same column in entity
    //
    Customer findByEmail(String email);
}

