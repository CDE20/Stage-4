package com.cognizant.moviecruiser;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.service.MovieService;
import com.cognizant.moviecruiser.util.DateUtil;

@SpringBootApplication
@EntityScan(basePackages = { "com" })
@ComponentScan(basePackages = { "com.cognizant.moviecruiser.service" })
@EnableJpaRepositories(basePackages = { "com.cognizant.moviecruiser.repository" })
public class MoviecruiserApplication implements CommandLineRunner{

	@Autowired
	private MovieService movieService;
	
	public static void main(String[] args) {
		SpringApplication.run(MoviecruiserApplication.class, args);
			
	}

	@Override
	public void run(String... args) throws Exception {

		List<Movie> list = getAllMoviesToStore();
		movieService.save(list);
		System.err.println("Finished Storing... Now Implement the MovieDaoSqlImplTest.java in UPDATE MODE");
	}

	private List<Movie> getAllMoviesToStore() {
		Movie movie;

		movie = new Movie(1, "Avatar", "$2,787,965,087", true, DateUtil.convertToDate("15/03/2017"), "Science Fiction",
				true);
		List<Movie> movieList = new ArrayList<>();
		movieList.add(movie);
		movie = new Movie(2, "The Avengers", "$1,518,812,988", true, DateUtil.convertToDate("23/12/2017"), "Superhero",
				false);
		movieList.add(movie);
		movie = new Movie(3, "Titanic", "$2,187,463,944", true, DateUtil.convertToDate("21/08/2017"), "Romance", false);
		movieList.add(movie);
		movie = new Movie(4, "Jurassic World", "$1,671,713,208", false, DateUtil.convertToDate("02/07/2017"),
				"Science Fiction", true);
		movieList.add(movie);
		movie = new Movie(5, "Avengers: End Game", "$2,750,760,348", true, DateUtil.convertToDate("02/11/2022"),
				"Superhero", true);
		movieList.add(movie);

		return movieList;
	}

}
