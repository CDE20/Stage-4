package com.cognizant;



import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.cognizant.springlearn.SpringLearnApplication;
import com.cognizant.springlearn.controller.CountryController;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

import ch.qos.logback.core.status.Status;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest(classes = SpringLearnApplication.class)
@AutoConfigureMockMvc
class SpringLearnApplicationTests {

	@Autowired
	private CountryController countryController;
	
	@Autowired
	private MockMvc mvc;
	
	@Test
	void contextLoads() {
		
		assertNotNull(countryController);
	}
	
	@Test
	public void testGetCountry() throws Exception{
			ResultActions actions = mvc.perform(get("/country"));
			actions.andExpect(status().isOk());
			actions.andExpect(jsonPath("$.code").exists());
			actions.andExpect(jsonPath("$.code").value("IN"));
			actions.andExpect(jsonPath("$.name").exists());
			actions.andExpect(jsonPath("$.name").value("India"));
	}
	
	@Test
	public void testGetCountryException() throws Exception{
		ResultActions actions = mvc.perform(get("/countries/ff"));
		//actions.andExpect(status().isBadRequest());
		actions.andExpect(status().reason("Country Not Found"));
		
	}

}
