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
@NoArgsConstructor
@AllArgsConstructor
@Table(name="property")
public class Property {
	@Id
	@Column(name="propertyId")
	private Integer propertyId;
	
	@Column(name = "image", columnDefinition = "LONGBLOB")
    private byte[] image;
	
	@Column(name="type")
	private String type;
	
	@Column(name="areaInSqrft")
	private String areaInSqrft;
	
	@Column(name="ratePerSqrtft")
	private String ratePerSqrtft;
	
	@Column(name ="location")
	private String location;
	
	
	@Column(name="propertyAmenities")
	private String propertyAmenities;
	
	

}

