package com.webapp.bankingportal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp.bankingportal.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}



