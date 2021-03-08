package com.cognizant.moviecruiser.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cognizant.moviecruiser.model.Movie;

public interface FavoritesDao {
	public void addFavoritesMovie(long userId, long movieId);

	public List<Movie> getAllFavoritesMovies(long userId) throws FavoritesEmptyException;

	public void removeFavoritesMovie(long userId, long movieId);
}
