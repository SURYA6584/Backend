package com.rentify.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rentify.entity.Property;
import com.rentify.service.PropertyService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class RestaurantController {
	
	@Autowired
	private PropertyService propertyService;
	
	@GetMapping("/getAllRestaurant")
	public List<Property> getAllProperty(){
		return propertyService.getAllProperty();
	}
	
	@GetMapping("/getRestarauntById/{id}")
	public Property getRestarauntById(@PathVariable ("id") Integer id) {
		return propertyService.getPropertyById(id);
	}
	
    @PostMapping("/addrestaurant")
    public String addRestaurant(
            @RequestParam("propertyId") Integer propertyId,
            @RequestParam("type") String type,
            @RequestParam("areaInSqrft") String areaInSqrft,
            @RequestParam("ratePerSqrtft") String ratePerSqrtft,
            @RequestParam("location") String location,
            @RequestParam("propertyAmenities") String propertyAmenities,
            @RequestParam("image") MultipartFile imageFile) {
    	Property property = new Property();
        property.setPropertyId(propertyId);
        property.setType(type);
        property.setAreaInSqrft(areaInSqrft);
        property.setRatePerSqrtft(ratePerSqrtft);
        property.setLocation(location);
        property.setPropertyAmenities(propertyAmenities);
        return propertyService.addProperty(property, imageFile);
    }
	@PostMapping("/updaterestaurant")
	public void updateRestaurant(@RequestBody Property propertyUpdate) {
		propertyService.updateProperty(propertyUpdate);
	}
	@DeleteMapping("/deleterestaurant/{id}")
	public void deleteRestaurant(@PathVariable ("id") Integer id) {
		propertyService.deleteProperty(id);
		
	}
}