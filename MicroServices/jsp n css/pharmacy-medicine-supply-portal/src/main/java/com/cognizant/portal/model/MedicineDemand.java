package com.cognizant.portal.model;

import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Model class used to represent the details about the medicine demand.
 * 
 * @version 1.8
 * @author Pod3
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "medicine_demand")
public class MedicineDemand {

	/**
	 * Represents the unique id for medicine demand
	 */
	private int id;
	
	/**
	 * Represents the name of the medicine
	 */
	@NotEmpty(message = "Medicine field must not be empty")
	@NotNull(message = "Medicine field must not be null")
	private String medicine;
	
	/**
	 * Represents the demand count
	 */
	private int demandCount;
}
