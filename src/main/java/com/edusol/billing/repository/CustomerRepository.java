package com.edusol.billing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edusol.billing.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
