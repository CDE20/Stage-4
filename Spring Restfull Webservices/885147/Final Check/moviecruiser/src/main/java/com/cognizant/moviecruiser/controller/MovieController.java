package com.cognizant.moviecruiser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.service.MovieService;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

	@Autowired
	MovieService service;

	@GetMapping("/admin")
	public List<Movie> getMovieListAdmin() {
		return service.getMovieListAdmin();
	}

	@GetMapping("/customer")
	public List<Movie> getMovieListCustomer() {
		return service.getMovieListCustomer();
	}

	@GetMapping("/{movieId}")
	public Movie getMovie(@PathVariable long movieId) {
		return service.getMovie(movieId);
	}

	@PutMapping
	public void modifyMovie(@RequestBody Movie movie) {
		service.modifyMovie(movie);
	}
}