package com.cognizant.portal.model;

import java.util.Date;

import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Model class to represent the fields that are used to generate the schedule
 * for the meeting between medical representatives and doctors for the
 * pharmaceutical company.
 * 
 * @version 1.8
 * @author Pod3
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "rep_schedule")
public class RepSchedule {
	
	/**
	 * Unique id for each rep schedule
	 */
	@ApiModelProperty(notes = "Represents the unique id of the representative")
	private int id;

	/**
	 * Name of the representative
	 */
	@ApiModelProperty(notes = "The name of the representative")
	private String repName;

	/**
	 * The name of the Doctor
	 */
	@ApiModelProperty(notes = "The name of the Doctor")
	@NotNull(message = "Doctor name is a required field")
	private String doctorName;

	/**
	 * Represents the treating ailment
	 */
	@ApiModelProperty(notes = "Represents the treating ailment")
	@NotNull(message = "Treating ailment is a required field")
	private String treatingAilment;

	/**
	 * The name of the medicines
	 */
	@ApiModelProperty(notes = "The name of the medicine")
	@NotNull(message = "Medicine is a required field")
	private String[] medicine;

	/**
	 * Represents the meeting slot
	 */
	@ApiModelProperty(notes = "Represents the meeting slot")
	@NotNull(message = "Meeting slot is a required field")
	private String meetingSlot;

	/**
	 * Represents the date of meeting
	 */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@ApiModelProperty(notes = "The date of meeting")
	@NotNull(message = "Date of meeting is a required field")
	private Date dateOfMeeting;

	/**
	 * Contact no. of the Doctor
	 */
	@ApiModelProperty(notes = "Contact no. of the Doctor")
	@NotEmpty(message = "doctor contact number must be entered")
	private long doctorContactNo;

}
