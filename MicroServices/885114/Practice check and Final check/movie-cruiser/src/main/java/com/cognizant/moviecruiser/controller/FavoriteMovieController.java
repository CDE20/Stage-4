package com.cognizant.moviecruiser.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.moviecruiser.exception.CustomerNotFoundException;
import com.cognizant.moviecruiser.exception.MovieNotFoundException;
import com.cognizant.moviecruiser.model.Customer;
import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class FavoriteMovieController {

	private static final Logger LOGGER = LoggerFactory.getLogger(FavoriteMovieController.class);

	@Autowired
	private CustomerService customerService;

	@GetMapping
	public List<Customer> getAllCustomer() throws MovieNotFoundException {
		LOGGER.info("Start");

		List<Customer> customers = customerService.getAllCustomers();

		LOGGER.info("End");

		return customers;
	}

	@GetMapping("/fav/{customerId}")
	public List<Movie> viewFavorites(@PathVariable("customerId") long customerId) throws CustomerNotFoundException {
		LOGGER.info("Strat");

		List<Movie> favorites = customerService.viewFavorites(customerId);
		
		LOGGER.info("End");
		return favorites;
	}
	
	@PostMapping("/fav/{customerId}/{movieId}")
	public Customer addFavorite(@PathVariable("customerId") long customerId, @PathVariable("movieId") long movieId)
			throws MovieNotFoundException, CustomerNotFoundException {
		LOGGER.info("Strat");

		Customer customer = customerService.addFavorite(customerId, movieId);

		LOGGER.info("End");
		return customer;
	}

	@DeleteMapping("/fav/{customerId}/{movieId}")
	public Customer removeFavorite(@PathVariable("customerId") long customerId, @PathVariable("movieId") long movieId) throws MovieNotFoundException, CustomerNotFoundException {
		LOGGER.info("Start");

		Customer customer = customerService.removeFavorite(customerId, movieId);

		LOGGER.info("End");
		return customer;
	}

}
