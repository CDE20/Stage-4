package com.cognizant.moviecruiser.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.repository.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;

	public List<Movie> getMovieListAdmin() {

		return movieRepository.findAll();
	}

	public List<Movie> getMovieListCustomer() {

		return movieRepository.findByActiveTrue();
	}

	
	public void modifyMovie(Movie movie) {

		Movie tobeUpdated = movieRepository.findById(movie.getId()).get();
		tobeUpdated.setActive(movie.isActive());
		tobeUpdated.setBoxOffice(movie.getBoxOffice());
		tobeUpdated.setDateOfLaunch(movie.getDateOfLaunch());
		tobeUpdated.setGenre(movie.getGenre());
		tobeUpdated.setHasTeaser(movie.isHasTeaser());
		tobeUpdated.setTitle(movie.getTitle());
		
		movieRepository.save(movie);

	}

	public Movie getMovie(long movieId) {
		return movieRepository.findById(movieId).get();
	}

	public void save(List<Movie> movies) {
		movieRepository.saveAll(movies);

	}

}
