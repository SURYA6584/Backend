package com.rentify.service;

import java.util.List;

import com.rentify.entity.Customers;
import com.rentify.responses.LoginResponse;

public interface CustomerService {
	public List<Customers> getAllCustomerDetails();
	public Customers getAllCustomerDetailsById(String customer_id);
	public String updateCustomerDetail(Customers customerUpdated );
	public String addCustomer(Customers customer);
	public String deleteCustomer(String id);
	public LoginResponse loginCustomer(Customers login);
	

}
