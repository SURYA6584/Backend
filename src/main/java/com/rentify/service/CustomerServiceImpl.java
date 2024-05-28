package com.rentify.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rentify.entity.Customers;
import com.rentify.repository.CustomerRepository;
import com.rentify.responses.LoginResponse;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	

	
	public List<Customers> getAllCustomerDetails(){
		return customerRepository.findAll();
	}
	
	
	
	public Customers getAllCustomerDetailsById(String customer_id){
		
		return customerRepository.findById(customer_id).get();
	}

	
	
	public String updateCustomerDetail(Customers customerUpdated ) {
	    Optional<Customers> customerOptional = customerRepository.findById(customerUpdated.getCustomer_id());
	    if(customerOptional.isPresent()) {
	    	Customers customerExisting = customerOptional.get();
	    	
	    	customerExisting.setFirst_name(customerUpdated.getFirst_name());
	    	customerExisting.setLast_name(customerUpdated.getLast_name());
	    	customerExisting.setPhone_number(customerUpdated.getPhone_number());
	    	customerExisting.setDelivery_address(customerUpdated.getDelivery_address());
	    	customerExisting.setEmail(customerUpdated.getEmail());
	    	customerExisting.setPassword(customerUpdated.getPassword());
	    	
	    	customerRepository.save(customerExisting);
	    	return "Changes Updated Sucessfully";
	    	
	    }
	    else return "Customer ID not Found";
	}

	
	
	public String addCustomer(Customers customer) {
	    String plainPassword = customer.getPassword();

	    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	     
	    // Encode the plain password using bcrypt
	    String encodedPassword = passwordEncoder.encode(plainPassword);

	    // Set the encoded password back to the customer object
	    customer.setPassword(encodedPassword);

	    // Generate a random string of length 4 to 5 characters
	    String customerId = generateRandomString(4, 5);
	    customer.setCustomer_id(customerId);
	   
	    customerRepository.save(customer);

	    return "Customer Added Successfully";
	}

	private String generateRandomString(int minLength, int maxLength) {
	    int length = (int) (Math.random() * (maxLength - minLength + 1)) + minLength;
	    return UUID.randomUUID().toString().substring(0, length).toUpperCase();
	}

	
	
	public String deleteCustomer(String id) {
		Optional<Customers> customer =customerRepository.findById(id);
		Customers CustomerDelete = customer.orElse(null);
		if(CustomerDelete==null) {
			return "Id provided is not Valid !!";
		}
		else {
			customerRepository.delete(CustomerDelete);
			return "Deleted Sucessfully !!";
		}
	}

	
	public LoginResponse loginCustomer(Customers login) {
	    String msg = "";
	    Customers customer1 = customerRepository.findByEmail(login.getEmail());
	    if (customer1 != null) {
	        String password = login.getPassword();
	        String encodedPassword = customer1.getPassword(); // Get the encoded password from the database
	        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	        boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
	        if (isPwdRight) {
	            // Password matches, perform additional logic if needed
	            return new LoginResponse("Login Success", true);
	        } else {
	            return new LoginResponse("Invalid password", false);
	        }
	    } else {
	        return new LoginResponse("Email not found", false);
	    }
	}




	
	
	
	
}
