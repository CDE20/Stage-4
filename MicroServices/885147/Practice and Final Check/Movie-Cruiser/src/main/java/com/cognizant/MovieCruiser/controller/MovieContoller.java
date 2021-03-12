package com.cognizant.MovieCruiser.controller;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.MovieCruiser.dao.MoviesDAO;
import com.cognizant.MovieCruiser.model.movie;



@RestController
public class MovieContoller {
	@Autowired
	MoviesDAO movieService;
	
	
	@GetMapping("/customer/movies")
	public List<movie> getCustomerMovie()
	{
		return movieService.getCustomerAllMovies();
	}
	@GetMapping("/admin/movies")
	public List<movie> getAdminMovie()
	{
		return movieService. getAdminAllMovies();
	}
	@GetMapping("/customer/{mname}")
	public movie getMovie(@PathVariable String mname)
	{
		System.out.println(mname);
		return movieService.getMovie(mname);
	}
	@PutMapping("/admin/{name}")
	public void editMovie(@PathVariable String name, @RequestBody movie Movie)
	{
		movieService.updateMovie(name,Movie);
	}

	
	@GetMapping("/customer/favourite")
	public Map<List<String>,Long> favourite()
	{
	    List<String> Movie= new ArrayList<String>();
	    movieService.getCustomerFavourite().forEach(m->Movie.add(m.getMoviename()));
	    long countOfFavourites=movieService.favouriteCount();
	    System.out.println(countOfFavourites);
	    Map<List<String>,Long> map=new HashMap<List<String>,Long>();
	    map.put(Movie,countOfFavourites-1);
	    return map;
	    
	}
	
}
