package com.cognizant.moviecruiser.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.moviecruiser.dao.MovieDao;
import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser_restful.exception.MovieNotFoundException;
@Service
public class MovieDaoService {
	
	@Autowired
	MovieDao movieDao;
	
	
	public List<Movie> getMovieListAdmin(){
		return movieDao.getMovieListAdmin();
	}
	
	public List<Movie> getMovieListCustomer(){
		return movieDao.getMovieListCustomer();
	}
	
	public void modifyMovie(int movieId,Movie movie) throws MovieNotFoundException {
		movieDao.modifyMovie(movieId, movie);
	}
	
	
	public Movie getMovie(int movieId) {
		return movieDao.getMovie(movieId);
	}
}
