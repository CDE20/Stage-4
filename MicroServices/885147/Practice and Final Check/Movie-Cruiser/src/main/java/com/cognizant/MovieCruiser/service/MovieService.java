package com.cognizant.MovieCruiser.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import com.cognizant.MovieCruiser.dao.MoviesDAO;
import com.cognizant.MovieCruiser.model.movie;

public class MovieService {
	
	@Autowired
	MoviesDAO moviesDAO;
	
	public movie getMovie(String name)
	{
		
		return moviesDAO.getMovie(name);
	}	
	
	public List<movie> getCustomerMovie()
	{
		return moviesDAO.getCustomerAllMovies();
	}
		public List<movie> getAdminMovie()
	{
		return moviesDAO. getAdminAllMovies();
	}
	
	public void editMovie(String name,movie Movie)
	{
		moviesDAO.updateMovie(name,Movie);
	}

	public Map<List<movie>,Long> favourite()
	{
	    List<movie> Movie=moviesDAO.getCustomerFavourite();
	    long countOfFavourites=moviesDAO.favouriteCount();
	    Map<List<movie>,Long> map=new HashMap<List<movie>,Long>();
	    map.put(Movie,countOfFavourites);
	    return map;
	    
	}
	
	

}
