package com.cognizant.springrestlearn;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.cognizant.springrestlearn.controller.CountryController;
import com.cognizant.springrestlearn.service.exception.CountryNotFoundException;
import com.jayway.jsonpath.JsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class SpringRestLearnApplicationTests {
	
	@Autowired
	private MockMvc mvc;

	@Autowired
	private CountryController controller;
	
	@Test
	void contextLoads() {
		assertNotNull(controller);
	}
	
	@Test
	public void testGetCountry() throws Exception{
		ResultActions actions=mvc.perform(get("/country"));
		actions.andExpect(status().isOk());
		actions.andExpect(jsonPath("$.code").exists());
		actions.andExpect(jsonPath("$.code").value("IN"));
		actions.andExpect(jsonPath("$.name").value("India"));
	}

	@Test
	public void testGetCountryException() throws Exception {
		ResultActions actions=mvc.perform(get("/countries/az"));
		actions.andExpect(status().is(404));
		actions.andExpect(status().reason("Country not found"));
	}

}
