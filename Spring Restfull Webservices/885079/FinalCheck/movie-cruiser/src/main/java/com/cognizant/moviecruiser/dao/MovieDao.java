package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.exception.MovieNotFoundException;
import com.cognizant.moviecruiser.model.Movie;

public interface MovieDao {

	public List<Movie> getMoviesForAdmin();

	public List<Movie> getMoviesForCustomer();

	public void modifyMovie(Movie menuItem);

	public Movie getMovie(long movieId) throws MovieNotFoundException;

}
