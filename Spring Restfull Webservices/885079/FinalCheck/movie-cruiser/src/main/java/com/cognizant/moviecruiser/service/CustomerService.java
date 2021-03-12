package com.cognizant.moviecruiser.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.moviecruiser.dao.CustomerDao;
import com.cognizant.moviecruiser.exception.CustomerNotFoundException;
import com.cognizant.moviecruiser.exception.MovieNotFoundException;
import com.cognizant.moviecruiser.model.Customer;
import com.cognizant.moviecruiser.model.Movie;

@Service
public class CustomerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

	@Autowired
	private CustomerDao customerDao;

	public List<Customer> getAllCustomers() {
		LOGGER.info("Start");

		List<Customer> customers = customerDao.getAllCustomers();

		LOGGER.info("End");
		return customers;
	}

	public Customer addFavorite(long customerId, long movieId)
			throws MovieNotFoundException, CustomerNotFoundException {
		LOGGER.info("Start");
		
		Customer customer = customerDao.addFavorite(customerId, movieId);
		
		LOGGER.info("End");
		return customer;
	}

	public Customer removeFavorite(long customerId, long movieId)
			throws MovieNotFoundException, CustomerNotFoundException {
		LOGGER.info("Start");

		Customer customer = customerDao.removeFavorite(customerId, movieId);

		LOGGER.info("End");
		return customer;
	}

	public List<Movie> viewFavorites(long customerId) throws CustomerNotFoundException {
		LOGGER.info("Start");
		
		List<Movie> favorites = customerDao.viewFavorites(customerId);
		
		LOGGER.info("End");
		return favorites;
	}

}
