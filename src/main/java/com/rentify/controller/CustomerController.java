package com.rentify.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.rentify.entity.Customers;
import com.rentify.responses.LoginResponse;
import com.rentify.service.CustomerService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customerdetails")
	public List<Customers> getAllCustomerDetails(){
		List<Customers> customers= customerService.getAllCustomerDetails();
		//model.addAttribute("customers", customers);
		return customers;
	}
	
	@GetMapping("/customerdetailsbyid/{id}")
	public Customers getAllCustomerDetailsById(@PathVariable("id")String id){
		
		return customerService.getAllCustomerDetailsById(id);
	}
	
	@PutMapping("/upadatecustomerdetail")
	public void updateCustomerDetail(@RequestBody Customers customerUpdated ) {
		    customerService.updateCustomerDetail(customerUpdated);
	}
	
	@PostMapping("/addcustomer")
	public void addCustomer(@RequestBody Customers customer) {
		customerService.addCustomer(customer);

	}
	
	@DeleteMapping("/deletecustomer/{id}")
	public void deleteCustomer(@PathVariable("id")String id) {
		customerService.deleteCustomer(id);

	}
	
	@PostMapping("/login")
	public ResponseEntity<?> loginCustomer(@RequestBody Customers login){
		LoginResponse loginResponse= customerService.loginCustomer(login);
		return ResponseEntity.ok(loginResponse);
	}
	
	
}























