package com.rentify.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rentify.entity.Customers;

@Repository
public interface CustomerRepository extends JpaRepository<Customers,String >{
	Optional<Customers> findOneByEmailAndPassword(String email,String password);
	Customers findByEmail(String email);
	Optional<Customers> findById(String customer_id);

}
