package com.edusol.billing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.edusol.billing.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {


}
