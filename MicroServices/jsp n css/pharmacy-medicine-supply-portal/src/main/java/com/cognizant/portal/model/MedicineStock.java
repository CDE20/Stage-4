package com.cognizant.portal.model;

import java.sql.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Model class used to represent the details about the medicine stock.
 * 
 * @version 1.8
 * @author Pod3
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MedicineStock {

	/**
	 * It represents the unique id for medicine stock It will be generated
	 * automatically with a hibernate sequence
	 */
	@ApiModelProperty(notes = "this represents the unique id of the medicine")
	private int id;

	/**
	 * This field represents the name of the medicine stock
	 */
	@NotEmpty(message = "Medicine name is required")
	@ApiModelProperty(notes = "this shows the name of the medicine")
	private String name;

	/**
	 * This field represents all the chemical compositions from which the medicine
	 * is made of
	 */
	@NotEmpty(message = "Chemical composition  is required")
	@ApiModelProperty(notes = "This shows the chemical composition of the medicine")
	private String chemicalComposition;

	/**
	 * This field represents the target ailment
	 */
	@NotEmpty(message = "Target ailment is required")
	@ApiModelProperty(notes = "This shows the target ailment")
	private String targetAilment;

	/**
	 * This field represents the name of the pharmacy
	 */
	@NotEmpty(message = "Pharmacy name is required")
	@ApiModelProperty(notes = "The name of the pharmacy")
	private String pharmacyName;

	/**
	 * This field represents the expiry date of the medicine The date can only be in
	 * the future
	 */
	@Future
	private Date dateOfExpiry;
	
	/**
	 * This field represents the number of tablets present in the stock
	 */
	@Min(value = 1, message = "Number of tablet must be greater than zero")
	private int numberOfTabletsInStock;
}
