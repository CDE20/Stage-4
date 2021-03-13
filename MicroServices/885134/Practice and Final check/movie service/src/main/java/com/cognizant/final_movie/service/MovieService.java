package com.cognizant.final_movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.final_movie.dao.MovieDao;
import com.cognizant.final_movie.model.Movie;


@Service
public class MovieService {
	
	@Autowired
	MovieDao dao;
	
	public List<Movie> getMovieListAdmin()
	{
		return dao.getMovieListAdmin();
	}
	
	public List<Movie> getMovieListCustomer()
	{
		return dao.getMovieListCustomer();
	}
	
	public Movie getMovie(long movieId)
	{
		return dao.getMovie(movieId);
	}
	
	public void modifyMovie(Movie movie)
	{
		dao.modifyMovie(movie);
	}

}