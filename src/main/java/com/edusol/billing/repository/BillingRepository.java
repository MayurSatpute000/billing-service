package com.edusol.billing.repository;



import org.springframework.data.jpa.repository.JpaRepository;


import com.edusol.billing.model.Bill;


public interface BillingRepository extends JpaRepository<Bill,Integer> {

	//List<Bill> findByName(String name);

}
