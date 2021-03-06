package com.cognizant.moviecruiser_restful.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.service.MovieDaoService;
import com.cognizant.moviecruiser_restful.exception.MovieNotFoundException;

@RestController
@RequestMapping("/movies")
public class MovieController {
	
	@Autowired
	MovieDaoService service;
	
	@GetMapping("/admin-movies")
	public List<Movie> getAllMoviesAdmin(){
		return service.getMovieListAdmin();
	}
	
	@GetMapping("/customer-movies")
	public List<Movie> getAllMoviesCustomer(){
		return service.getMovieListCustomer();
	}
	
	@PutMapping("/admin/{movieId}")
	public void modifyMovieDetails(@PathVariable int movieId,@RequestBody Movie movie) throws MovieNotFoundException {
		service.modifyMovie(movieId, movie);
	}
	

}
