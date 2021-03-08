package com.cognizant.final_movie.dao;

import java.util.List;

import com.cognizant.final_movie.exception.FavoritesEmptyException;
import com.cognizant.final_movie.model.Movie;


public interface FavoritesDao {
	public void addFavoritesMovie(long userId, long movieId);

	public List<Movie> getAllFavoritesMovies(long userId) throws FavoritesEmptyException;

	public void removeFavoritesMovie(long userId, long movieId);

}