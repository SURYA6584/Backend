package com.rentify.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="customers")
public class Customers {

	    @Id
	    @Column(name="customer_id")
		private String customer_id;
	    
	    @Column(name="first_name")
		private String first_name;
	    
	    @Column(name="last_name")
		private String last_name;
	    
	    
	    @Column(name="email" ,unique=true)
		private String email;
	    
	    @Column(name="phone_number")
		private String phone_number;
	    
	    @Column(name="delivery_address")
		private String delivery_address;
	    
	    @Column(name="password")
		private String password;

		
}
