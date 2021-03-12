package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.exception.CustomerNotFoundException;
import com.cognizant.moviecruiser.exception.MovieNotFoundException;
import com.cognizant.moviecruiser.model.Customer;
import com.cognizant.moviecruiser.model.Movie;

public interface CustomerDao {

	List<Customer> getAllCustomers();

	public Customer addFavorite(long customerId, long movieId) throws MovieNotFoundException, CustomerNotFoundException;

	public Customer removeFavorite(long customerId, long movieId) throws MovieNotFoundException, CustomerNotFoundException;

	public List<Movie> viewFavorites(long customerId) throws CustomerNotFoundException;

}
