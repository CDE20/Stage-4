package com.cognizant.moviecruiser.dao;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Repository;

import com.cognizant.moviecruiser.exception.CustomerNotFoundException;
import com.cognizant.moviecruiser.exception.MovieNotFoundException;
import com.cognizant.moviecruiser.model.Customer;
import com.cognizant.moviecruiser.model.Movie;

@Repository
@ImportResource("customers.xml")
public class CustomerDaoImpl implements CustomerDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerDaoImpl.class);

	@Autowired
	private List<Customer> customers;

	@Autowired
	private MovieDao movieDao;

	@Override
	public List<Customer> getAllCustomers() {
		LOGGER.info("Start");
		
		LOGGER.info("End");
		return customers;
	}

	@Override
	public Customer addFavorite(long customerId, long movieId) throws MovieNotFoundException, CustomerNotFoundException {
		LOGGER.info("Start");

		Customer customer = null;
		
		Optional<Customer> optional = customers.stream().filter(i -> i.getId() == customerId).findFirst();
		if (optional.isPresent()) customer = optional.get();
		
		if (customer == null) throw new CustomerNotFoundException("Customer Not Found Exception");

		List<Movie> favorites = customer.getFavorites();
		Movie movie = movieDao.getMovie(movieId);
		favorites.add(movie);
		customer.setTotalFavoriteCount(favorites.size());

		LOGGER.info("End");
		return customer;
	}

	@Override
	public Customer removeFavorite(long customerId, long movieId) throws MovieNotFoundException, CustomerNotFoundException {
		LOGGER.info("Start");
		
		Customer customer = null;
		Optional<Customer> optional = customers.stream().filter(i -> i.getId() == customerId).findFirst();
		if (optional.isPresent()) customer = optional.get();

		if (customer == null) throw new CustomerNotFoundException("Customer Not Found Exception");

		List<Movie> favorites = customer.getFavorites();
		Movie movie = movieDao.getMovie(movieId);
		favorites.remove(movie);

		customer.setTotalFavoriteCount(favorites.size());

		LOGGER.info("End");
		return customer;
	}

	@Override
	public List<Movie> viewFavorites(long customerId) throws CustomerNotFoundException {
		LOGGER.info("Start");

		Customer customer = null;
		Optional<Customer> optional = customers.stream().filter(i -> i.getId() == customerId).findFirst();
		if (optional.isPresent()) customer = optional.get();
		
		if (customer == null) throw new CustomerNotFoundException("Customer Not Found Exception");

		List<Movie> favorites = customer.getFavorites();

		LOGGER.info("End");
		return favorites;
	}

}
