package com.cognizant.portal.model;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Model class used to represent the details about the medicine supply.
 * 
 * @version 1.8
 * @author Pod3
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "medicine_supply")
public class MedicineSupply {

	/**
	 * Represents the unique id for the medicine supply table
	 */

	@JsonIgnore
	@ApiModelProperty(notes = "the unique id of the medicine")
	private int id;

	/**
	 * Represents the name of the pharmacy
	 */
	@ApiModelProperty(notes = "The name of the pharmacy")
	private String pharmacyName;

	/**
	 * Represents the name of the medicine
	 */
	@ApiModelProperty(notes = "The name of the medicine")
	private String medicineName;

	/**
	 * Represents the supplyCount
	 */
	@ApiModelProperty(notes = "shows the supply count")
	private int supplyCount;
}