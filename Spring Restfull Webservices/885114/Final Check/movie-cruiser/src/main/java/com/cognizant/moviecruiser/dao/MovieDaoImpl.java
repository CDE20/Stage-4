package com.cognizant.moviecruiser.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Repository;

import com.cognizant.moviecruiser.exception.MovieNotFoundException;
import com.cognizant.moviecruiser.model.Movie;

@Repository
@ImportResource("movies.xml")
public class MovieDaoImpl implements MovieDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(MovieDaoImpl.class);

	@Autowired
	private List<Movie> movies;

	@Override
	public List<Movie> getMoviesForAdmin() {
		LOGGER.info("Start");
		
		LOGGER.info("End");
		return movies;
	}

	@Override
	public List<Movie> getMoviesForCustomer() {
		LOGGER.info("Start");

		ArrayList<Movie> menuItems = new ArrayList<>();
		Date currentDate = new Date();
		for (Movie mi : movies) {
			if (mi.getDateOfLaunch().compareTo(currentDate) <= 0) {
				if (mi.isActive())
					menuItems.add(mi);
			}
		}

		LOGGER.info("End");
		return menuItems;
	}

	@Override
	public void modifyMovie(Movie movie) {
		LOGGER.info("Start");
		
		for (int i = 0; i < movies.size(); i++) {
			if (movies.get(i).equals(movie)) {
				movies.remove(i);
				movies.add(i, movie);
			}
		}
		
		LOGGER.info("End");
	}

	@Override
	public Movie getMovie(long movieId) throws MovieNotFoundException {
		LOGGER.info("Start");

		boolean got = false;
		for (Movie m : movies) {
			if (m.getId() == movieId) {
				got = true;
				return m;
			}
		}
		if (!got) throw new MovieNotFoundException("Movie Not Found");

		LOGGER.info("End");
		return null;
	}

}
