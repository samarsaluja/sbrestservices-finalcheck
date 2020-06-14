package com.cognizant.moviecruiser.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.service.MovieService;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(MovieController.class);

	@Autowired
	private static MovieService service;

	@GetMapping(value = "/list")
	public List<Movie> getAllMovies() {
		LOGGER.info("START");
		List<Movie> customerList = new ArrayList<Movie>();
		customerList = service.getMovieListCustomer();
		LOGGER.info("END");
		return customerList;
	}

	@GetMapping(value = "/{id}")
	public Movie getMovie(@PathVariable("id") long id) throws Exception {
		LOGGER.info("START");
		LOGGER.info("END");
		return service.getMovie(id);
	}

	@PostMapping()
	public void modifyMovie(@RequestBody Movie movie) {
		LOGGER.info("START");
		service.modifyMovies(movie);
		LOGGER.info("END");
	}

}
