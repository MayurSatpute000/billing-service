package com.edusol.billing.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edusol.billing.model.Bill;
import com.edusol.billing.model.Product;
import com.edusol.billing.repository.ProductRepository;
import com.edusol.billing.model.Customer;


import com.edusol.billing.service.BillingService;

import oracle.jdbc.proxy.annotation.GetProxy;




@RestController
@RequestMapping("/bills")
public class BillingController {
	
	@Autowired
	private BillingService billingService;
	@Autowired
	private ProductRepository productRepository;
	
	//For adding Bill
	
	@PostMapping
	public ResponseEntity<Bill> addBill (@RequestBody Bill bill){
		
		return new ResponseEntity<Bill> (billingService.addBill(bill),HttpStatus.CREATED);
	}
	//For get a list of bills
	
	@GetMapping
	public ResponseEntity<List<Bill>> getBills(){
		
		return billingService.getBills();
	}
	
	//For get bill from Id of Bill
	
	@GetMapping("/{id}")
	public Optional<Bill> getBillById(@PathVariable int id){
		
		return billingService.getById(id);
		
	}
	
	/*
	 * @GetMapping("/name/{name}") public ResponseEntity<List<Bill>>
	 * getByName(@PathVariable String name){
	 * 
	 * return new
	 * ResponseEntity<List<Bill>>(billingService.getByName(name),HttpStatus.OK);
	 * 
	 * }
	 * 
	 * @DeleteMapping("/{name}") public ResponseEntity<String>
	 * deleteByName(@PathVariable String name ){
	 * 
	 * return billingService.deleteByName(name);
	 * 
	 * }
	 */
	
		//For get product list from product service
	
	  @GetMapping("/get-product") public List<Product> getProduct(){
	  
	  return billingService.getproduct(); 
	  }
	  
	//For get customer list from customer service
	  
	  @GetMapping("/get-customer") public List<Customer> getCustomer(){
		  
		 return billingService.getcustomer(); 
	  }
	 
	  //For saving customer and product data into billing service for creating bill
	  
	  @GetMapping("/add")
		public String add(){
			
			return billingService.add();
			
		}
	  
	  //For get data by customer name and product name and save into bill
	  
	  @GetMapping("/save-bill/{cust}/{prod}")
	  	public String getBill(@PathVariable String cust,@PathVariable String prod){
	  		return billingService.getBill(cust,prod);
	  	}
	  
	  //For get total with customer id
	  @GetMapping("/total/{id}")
	  public String billById(@PathVariable int id) {
		  return billingService.total(id);
	  }
}
