package com.rentify.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rentify.entity.Property;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Integer> {

}
