package com.cognizant.moviecruiser.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.service.exception.FavoritesEmptyException;

@Service
public interface FavouriteDao {
	public void addFavoritesMovie(long userId, long movieId) throws Exception;

	public List<Movie> getAllFavoritesMovies(long userId) throws FavoritesEmptyException;

	public void removeFavoritesMovie(long userId, long movieId);

}
