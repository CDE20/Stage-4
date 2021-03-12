package com.cognizant.MovieCruiser.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.MovieCruiser.model.movie;
@Component
public class MoviesDAO {
	
	List<movie> movies=new ArrayList<movie>();
	public MoviesDAO()
	{
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("movies.xml");
		 movies = (List<movie>) classPathXmlApplicationContext.getBean("movieList");
	}
	public List<movie> getAdminAllMovies()
	{
		return movies;
	}
	public List<movie> getCustomerAllMovies()
	{
		return movies.stream().filter(t->t.getStatus().equalsIgnoreCase("active")).collect(Collectors.toList());
	}
	public movie getMovie(String name)
	{
		return movies.stream().filter(t->t.getMoviename().equalsIgnoreCase(name)).filter(t->t.getStatus().equalsIgnoreCase("active")).findFirst().get();
	}
	public void updateMovie(String name,movie Movie)
	{
		for(movie Movies:movies)
		{
			if(Movies.getMoviename().equals(Movie.getMoviename()))
			{
				Movies.setBoxoffice(Movie.getBoxoffice() ); 
				Movies.setGenere(Movie.getGenere());
				Movies.setStatus(Movie.getStatus());
				Movies.setLaunch(Movie.getLaunch());
				Movies.setFavourite(Movie.getFavourite());
			}
		}
	}
	
	public List<movie> getCustomerFavourite()
	{
		return movies.stream().filter(t->t.getFavourite().equalsIgnoreCase("yes")).filter(t->t.getStatus().equalsIgnoreCase("active")).collect(Collectors.toList());
	}
	public long favouriteCount()
	{
		return movies.stream().filter(t->t.getFavourite().equalsIgnoreCase("yes")).count();
	}
	
}
