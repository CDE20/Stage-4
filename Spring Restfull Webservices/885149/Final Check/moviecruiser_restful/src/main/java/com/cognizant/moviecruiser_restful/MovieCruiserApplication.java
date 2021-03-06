package com.cognizant.moviecruiser_restful;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.moviecruiser.service.MovieDaoService;


@SpringBootApplication(scanBasePackages="com.*")
public class MovieCruiserApplication 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(MovieCruiserApplication.class);
	private static MovieDaoService service;
    public static void main( String[] args )
    {
    	LOGGER.info("Inside Main ");
    	ApplicationContext context = SpringApplication.run(MovieCruiserApplication.class, args);
    	service=context.getBean(MovieDaoService.class);
    }
}
