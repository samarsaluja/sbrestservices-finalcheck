package com.cognizant.moviecruiser.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.moviecruiser.dao.FavouriteDao;
import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.service.exception.FavoritesEmptyException;

@Service
public class FavouriteService {

	@Autowired
	private static FavouriteDao daoimpl;

	public void addMovieInFavourite(long userId, long movieId) throws Exception {
		daoimpl.addFavoritesMovie(userId, movieId);
	}

	public List<Movie> getFavouritesList(long userId) throws FavoritesEmptyException {
		return daoimpl.getAllFavoritesMovies(userId);
	}

	public void removeFromFavourite(long userId, long movieId) {
		daoimpl.removeFavoritesMovie(userId, movieId);
	}

}
