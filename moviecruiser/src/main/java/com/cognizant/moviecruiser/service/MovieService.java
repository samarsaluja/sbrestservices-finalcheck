package com.cognizant.moviecruiser.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.moviecruiser.dao.MoviesDao;
import com.cognizant.moviecruiser.model.Movie;

@Service
public class MovieService {

	@Autowired
	private MoviesDao daoimpl;

	public List<Movie> getMovieListCustomer() {
		return daoimpl.getMovieListCustomer();
	}

	public Movie getMovie(long id) throws Exception {
		return daoimpl.getMovie(id);
	}

	public void modifyMovies(Movie movie) {
		daoimpl.modifyMovie(movie);
	}

}
