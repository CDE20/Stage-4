package com.cognizant.springlearn;

import static org.junit.Assert.assertNotNull;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.ResultActions;
import com.cognizant.springlearn.controller.CountryController;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@SpringBootTest
@AutoConfigureMockMvc
class SpringLearnApplicationTests {
	
	@Autowired
	CountryController countryController;

	
	@Autowired
	private MockMvc mvc;
	
	
	@Test
	void contextLoads() {
		
		assertNotNull(countryController);
	}
	
	@Test

	public void testGetCountry() throws Exception {

	ResultActions actions = mvc.perform(get("/country"));
	actions.andExpect(status().isOk());
	actions.andExpect(jsonPath("$.code").exists());
	actions.andExpect(jsonPath("$.code").value("IN"));
	actions.andExpect(jsonPath("$.country").exists());
	actions.andExpect(jsonPath("$.country").value("India"));

	}
	
	@Test
	public void testExceptional() throws Exception {
			ResultActions actions = mvc.perform(get("/country/aa"));
			actions.andExpect(status().isBadRequest());
			actions.andExpect(status().reason("Country not found"));
			
	}

}
