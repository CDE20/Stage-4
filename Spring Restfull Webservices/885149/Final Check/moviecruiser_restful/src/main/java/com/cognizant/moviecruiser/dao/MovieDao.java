package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser_restful.exception.MovieNotFoundException;

public interface MovieDao {
	public List<Movie> getMovieListAdmin();

	public List<Movie> getMovieListCustomer();

	public void modifyMovie(int movieId,Movie movie) throws MovieNotFoundException;

	public Movie getMovie(long movieId);
}
