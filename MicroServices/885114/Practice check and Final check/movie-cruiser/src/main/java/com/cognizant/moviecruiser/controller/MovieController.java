package com.cognizant.moviecruiser.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.moviecruiser.exception.MovieNotFoundException;
import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);

	@Autowired
	private MovieService movieService;

	@GetMapping("/admin")
	public List<Movie> getMoviesForAdmin() throws MovieNotFoundException {
		LOGGER.info("Start");

		List<Movie> movies = movieService.getMoviesForAdmin();

		LOGGER.info("End");

		return movies;
	}

	@PutMapping("/admin")
	public Movie modifyMovie(@RequestBody Movie movie) throws MovieNotFoundException {
		LOGGER.info("Start");

		movieService.modifyMovie(movie);

		LOGGER.info("End");

		return movieService.getMovie(movie.getId());
	}

	@GetMapping("/admin/{movieId}")
	public Movie getMovie(@PathVariable("movieId") long movieId) throws MovieNotFoundException {
		LOGGER.info("Start");

		Movie movie = movieService.getMovie(movieId);

		LOGGER.info("End");

		return movie;
	}

	@GetMapping("/customer")
	public List<Movie> getMoviesForCustomer() throws MovieNotFoundException {
		LOGGER.info("Start");

		List<Movie> movies = movieService.getMoviesForCustomer();

		LOGGER.info("End");

		return movies;
	}

}
