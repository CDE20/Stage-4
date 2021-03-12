package com.cognizant.moviecruiser.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.moviecruiser.dao.MovieDao;
import com.cognizant.moviecruiser.exception.MovieNotFoundException;
import com.cognizant.moviecruiser.model.Movie;

@Service
public class MovieService {

	@Autowired
	private MovieDao movieDao;

	public List<Movie> getMoviesForAdmin() {
		return movieDao.getMoviesForAdmin();
	}

	public List<Movie> getMoviesForCustomer() {
		return movieDao.getMoviesForCustomer();
	}

	public void modifyMovie(Movie movie) {
		movieDao.modifyMovie(movie);
	}

	public Movie getMovie(long movieId) throws MovieNotFoundException {
		return movieDao.getMovie(movieId);
	}

}
