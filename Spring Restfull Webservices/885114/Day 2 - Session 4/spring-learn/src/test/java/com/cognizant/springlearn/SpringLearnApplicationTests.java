package com.cognizant.springlearn;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.cognizant.springlearn.controller.CountryController;
import com.cognizant.springlearn.controller.EmployeeController;

@SpringBootTest
@AutoConfigureMockMvc
class SpringLearnApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private CountryController countryController;
	@Autowired
	private EmployeeController employeeController;

	@Test
	void contextLoads() {
		assertNotNull(countryController);
		assertNotNull(employeeController);
	}

	@Test
	public void testGetCountry() throws Exception {
		ResultActions actions = mvc.perform(get("/countries/country"));
		actions.andExpect(status().isOk());
		actions.andExpect(jsonPath("$.code").exists());
		actions.andExpect(jsonPath("$.code").value("IN"));

		actions.andExpect(jsonPath("$.name").exists());
		actions.andExpect(jsonPath("$.name").value("India"));
	}

	@Test
	public void testGetCountryException() throws Exception {
		ResultActions actions = mvc.perform(get("/countries/ab"));
//		actions.andExpect(status().isBadRequest());
		actions.andExpect(status().isNotFound());
		actions.andExpect(status().reason("Country not found"));
	}

	// Employee with id = 6 doesn't exist. 
	@Test
	public void testGetEmployeeException() throws Exception {
		ResultActions actions = mvc
				.perform(put("/employees").contentType(MediaType.APPLICATION_JSON).content(getContentOfEmployee6()));
		actions.andExpect(status().isNotFound());
		actions.andExpect(status().reason("Employee Not Found"));
	}
	
	private String getContentOfEmployee6() {
		return "{\"id\":6,\"name\":\"atik\",\"salary\":30000,\"permanent\":true,\"dateOfBirth\":\"03/06/1998\",\"department\":{\"id\":1,\"name\":\"computer\"},\"skill\":{\"id\":1,\"name\":\"java\"}}";
	}
	private String getContentOfEmployee1() {
		return "{\"id\":6,\"name\":\"atik\",\"salary\":30000,\"permanent\":true,\"dateOfBirth\":\"03/06/1998\",\"department\":{\"id\":1,\"name\":\"computer\"},\"skill\":{\"id\":1,\"name\":\"java\"}}";
	}
	
	@Test
	public void testDeleteEmployeeException() throws Exception {
		ResultActions actions = mvc.perform(delete("/employees").contentType(MediaType.APPLICATION_JSON).content(getContentOfEmployee1()));
		actions.andExpect(status().isNotFound());
		actions.andExpect(status().reason("Employee Not Found"));
	}

}
