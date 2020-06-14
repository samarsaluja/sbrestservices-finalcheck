package com.cognizant.moviecruiser.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.cognizant.moviecruiser.model.Favourite;
import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.service.exception.FavoritesEmptyException;

@Service
public class FavouritesDaoCollectionImpl implements FavouriteDao {

	private static HashMap<Long, Favourite> favourites;

	public FavouritesDaoCollectionImpl() {
		super();
		if (favourites == null) {
			favourites = new HashMap<Long, Favourite>();
		}
	}

	@Override
	public void addFavoritesMovie(long userId, long movieId) throws Exception {
		// TODO Auto-generated method stub
		MoviesDaoCollectionImpl movieDao = new MoviesDaoCollectionImpl();
		Movie movie = movieDao.getMovie(movieId);

		if (favourites.containsKey(userId)) {
			List<Movie> movieList = favourites.get(userId).getMovieList();
			movieList.add(movie);
		} else {
			Favourite favorites = new Favourite(new ArrayList<Movie>(), 0);
			favorites.getMovieList().add(movie);
			favourites.put(userId, favorites);
		}

	}

	@Override
	public List<Movie> getAllFavoritesMovies(long userId) throws FavoritesEmptyException {
		// TODO Auto-generated method stub
		if (favourites.containsKey(userId)) {
			List<Movie> movieList = favourites.get(userId).getMovieList();
			if (movieList.isEmpty()) {
				throw (new FavoritesEmptyException("Empty"));
			} else {
				favourites.get(userId).setNoOfFavorites(movieList.size());
			}
			return movieList;
		} else {
			throw (new FavoritesEmptyException("Empty"));
		}
	}

	@Override
	public void removeFavoritesMovie(long userId, long movieId) {
		// TODO Auto-generated method stub
		List<Movie> movieList = favourites.get(userId).getMovieList();
		for (int i = 0; i < movieList.size(); i++) {
			if (movieList.get(i).getId() == movieId) {
				movieList.remove(i);
				break;
			}
		}

	}

}
