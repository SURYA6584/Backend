package com.rentify.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.rentify.entity.Property;

public interface PropertyService {
	public List<Property> getAllProperty();
	public Property getPropertyById(Integer id);
	public String addProperty(Property property, MultipartFile imageFile);
	public String updateProperty(Property propertyUpdate);
	public String deleteProperty(Integer id);


}
