package com.cognizant.moviecruiser.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.service.FavouriteService;
import com.cognizant.moviecruiser.service.exception.FavoritesEmptyException;

@RestController
@RequestMapping(value = "/favourites")
public class FavouritesController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(FavouritesController.class);
	
	@Autowired
	private static FavouriteService service;
	
	@PostMapping(value = "/{userId}/{movieId}")
	public void addMovieToFavourite(@RequestBody long userId ,@RequestBody long movieId) throws Exception {
		LOGGER.info("START");
		service.addMovieInFavourite(userId, movieId);
		LOGGER.info("END");
	}
	
	@GetMapping(value = "/{userId}")
	public List<Movie> getAllMovies(long userId) throws FavoritesEmptyException{
		LOGGER.info("START");
		LOGGER.info("END");
		return service.getFavouritesList(userId);
	}
	
	@DeleteMapping(value = "/{userId}/{movieId}")
	public void removeMovie(@PathVariable("userId") long userId , @PathVariable("movieId") long movieId ) {
		LOGGER.info("START");
		service.removeFromFavourite(userId, movieId);
		LOGGER.info("END");
	}
	

}
