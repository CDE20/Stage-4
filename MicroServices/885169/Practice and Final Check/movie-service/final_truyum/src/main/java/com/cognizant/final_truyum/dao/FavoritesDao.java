package com.cognizant.final_truyum.dao;

import java.util.List;

import com.cognizant.final_truyum.exception.FavoritesEmptyException;
import com.cognizant.final_truyum.model.Movie;

public interface FavoritesDao {
	public void addFavoritesMovie(long userId, long movieId);

	public List<Movie> getAllFavoritesMovies(long userId) throws FavoritesEmptyException;

	public void removeFavoritesMovie(long userId, long movieId);

}
