package com.edusol.billing.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.hibernate.sql.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.edusol.billing.model.Product;
import com.edusol.billing.model.Bill;
import com.edusol.billing.model.Customer;
import com.edusol.billing.repository.BillingRepository;
import com.edusol.billing.repository.CustomerRepository;
import com.edusol.billing.repository.ProductRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;





@Service
public class BillingService {
	
	@Autowired
	RestTemplate template;
	
	final private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired
	private BillingRepository billingRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CustomerRepository customerRepository;

	
	
	public Bill addBill(Bill bill) {
		
		billingRepository.save(bill);
		logger.info(bill.toString());
		return bill;
		
		}

	public ResponseEntity<List<Bill>> getBills() {
		List<Bill> bills = billingRepository.findAll();
		logger.info(bills.toString());
		return new ResponseEntity<List<Bill>>(bills,HttpStatus.OK);
	}

	public Optional<Bill> getById(int id) {
		
		return billingRepository.findById(id);
		
	}


	/*
	 * public List<Bill> getByName(String name) {
	 * logger.info("Getting bill details by name:"+name); List<Bill> bill =
	 * billingRepository.findByName(name); return bill;
	 * 
	 * }
	 * 
	 * 
	 * public ResponseEntity<String> deleteByName(String name) {
	 * logger.info("Deleting bill by customer name :"+name); List result; String
	 * message = "";
	 * 
	 * try { result =billingRepository.findByName(name); if (result.isEmpty()) {
	 * message = "record Not found "+name; logger.error("record Not found"); return
	 * new ResponseEntity<String>(message,HttpStatus.NOT_FOUND); } else {
	 * billingRepository.deleteAll(result);
	 * message="Record deleted Successfully. "+name; logger.info(message); } return
	 * new ResponseEntity<String>(message,HttpStatus.OK); } catch(Exception e){
	 * 
	 * message = "record Not found "+name; logger.error("record Not found"); return
	 * new ResponseEntity<String>(message,HttpStatus.NOT_FOUND); } }
	 * 
	 */
	  public List<Product> getproduct() {
	  
	  final String url = "http://localhost:2331/product";
	  
	  
	  HttpHeaders header = new HttpHeaders();
	  header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	  
	  HttpEntity<String> entity = new HttpEntity<String>(header);
	  
	  ResponseEntity<Product[]> response = template.exchange(url, HttpMethod.GET,
	  entity, Product[].class);
	  
	  System.out.print(response.getBody().toString());
	  
	  List<Product> product = Arrays.asList(response.getBody());
	  
	  return product; 
	  
	  }

	  
	  	public List<Customer> getcustomer() {
		
		final String url = "http://localhost:8077/cust/get";
		  
		  
		  HttpHeaders header = new HttpHeaders();
		  header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		  
		  HttpEntity<String> entity = new HttpEntity<String>(header);
		  
		  ResponseEntity<Customer[]> response = template.exchange(url, HttpMethod.GET,
		  entity, Customer[].class);
		  
		  System.out.print(response.getBody().toString());
		  
		  List<Customer> customer = Arrays.asList(response.getBody());
		  
		  return customer;
		  
		  
	}

	
	  public String add() {
	  
		/*List pr = getproduct();
		
		productRepository.saveAll(pr);
		
		List<Product> productlist = null;
		productlist=productRepository.findAll();
		for(Product produc:productlist) {
			
			if(produc.getName().equals(prod)) {
				int p =produc.getP_id();
				
			}
		}  */
		  List<Customer> cust = getcustomer();
		 List<Product> prod2 = getproduct();	 
		  productRepository.saveAll(prod2);	  
	   	  customerRepository.saveAll(cust);
	   	  
	   	
		return "Added Successful";
		
	  }
	 public String getBill(String cust,String Prod){
		int c_id=0,p_id=0,b_id=0;
		
		//ArrayList<Product> productlist = new ArrayList<Product>();
		//ArrayList<Customer> customerlist = new ArrayList<Customer>();
		//String message=billingS.add();
		List<Product> pli= productRepository.findAll();
		List<Customer> cu= customerRepository.findAll();
		ArrayList<Product> p = new ArrayList<Product>(pli);
		ArrayList<Customer> c = new ArrayList<Customer>(cu);
		for(Product product:p) {
			if(product.getName().equals(Prod)) {
				
				for(Customer customer:c) {
					if(customer.getC_name().equals(cust)) {
						
						Long count=billingRepository.count();
						 c_id= customer.getC_id();
						 p_id= product.getId();
						 b_id=count.intValue();
						b_id=b_id+1;
					
						billingRepository.saveAll(List.of(new Bill(b_id,c_id,p_id)));
						
						
						
					}
				}
				
			}
		}
		String message = "Bill No: "+b_id+" Customer Id: "+c_id+" Product Id: "+p_id;
		return message;
		
	 }
	 
	 public Optional<Product> productId(int id){
		 
		 return productRepository.findById(id);
	 }

	public String total(int id) {
		String message="";
		double sum=0.0d;
		List<Product> prod2 = getproduct();	 
		 
		  ArrayList<Product> p=new ArrayList<Product>(prod2);
		  
		
		for(Product product:p) {
			if(product.getId()==(id)) {
				
				sum=sum+product.getAmount();
				
		
			}
		}
		 message="Toal amount= "+sum;
		return message;
	}
}

	
	  	
	 
	
	
	
	

	
	
	
	
	


