package com.rentify.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rentify.entity.Property;
import com.rentify.repository.PropertyRepository;



@Service
public class PropertyServiceImpl implements PropertyService{
	@Autowired
	private PropertyRepository propertyRepository;
	
	public List<Property> getAllProperty(){
		return propertyRepository.findAll();
	}
	
	public Property getPropertyById(Integer id) {
		return propertyRepository.findById(id).get();
	}
	
	public String addProperty(Property property, MultipartFile imageFile) {
        try {
            byte[] imageBytes = imageFile.getBytes();
            property.setImage(imageBytes);
            propertyRepository.save(property);
            return "Restaurant Added Successfully";
        } catch (IOException e) {
            // Log the error (use a logger in a real application)
            return "Error uploading image: " + e.getMessage();
        }
    }
	
	public String updateProperty(Property restaurantUpdate) {
		Optional<Property> PropertyOptional = propertyRepository.findById(restaurantUpdate.getPropertyId());
		if(PropertyOptional.isPresent()) {
			Property restaurantExisting = PropertyOptional.get();
			restaurantExisting.setType(restaurantUpdate.getType());
			restaurantExisting.setAreaInSqrft(restaurantUpdate.getAreaInSqrft());
			restaurantExisting.setRatePerSqrtft(restaurantUpdate.getRatePerSqrtft());
			restaurantExisting.setPropertyAmenities(restaurantUpdate.getPropertyAmenities());
			restaurantExisting.setImage(restaurantUpdate.getImage());
			restaurantExisting.setLocation(restaurantUpdate.getLocation());
			propertyRepository.save(restaurantExisting);
			
			return "Updated Sucessfully !!";
		}
		
	
		else {
			return "Provide a Valid Property ID";
		}
	}

	public String deleteProperty(Integer id) {
		propertyRepository.deleteById(id);
		return "Restaurant Deleted Sucessfully !!";
	}


}
