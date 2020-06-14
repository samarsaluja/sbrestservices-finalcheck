package com.cognizant.moviecruiser.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.service.exception.MovieNotFoundException;

@Service
public class MoviesDaoCollectionImpl implements MoviesDao {

	private List<Movie> movieList;

	public MoviesDaoCollectionImpl() {
		if (movieList == null) {
			ApplicationContext context = new ClassPathXmlApplicationContext("movies.xml");
			movieList = (ArrayList) context.getBean("movielist");
		}
	}

	@Override
	public List<Movie> getMovieListAdmin() {
		// TODO Auto-generated method stub
		return movieList;
	}

	@Override
	public List<Movie> getMovieListCustomer() {
		// TODO Auto-generated method stub
		List<Movie> customerList = new ArrayList<Movie>();
		for (int i = 0; i < movieList.size(); i++) {
			Movie movie = movieList.get(i);
			if ((movie.getDateOfLaunch().equals(new Date()) || movie.getDateOfLaunch().before(new Date()))
					&& movie.isActive()) {
				customerList.add(movie);
			}
		}
		return customerList;
	}

	@Override
	public void modifyMovie(Movie movie) {
		// TODO Auto-generated method stub
		for (int i = 0; i < movieList.size(); i++) {
			if (movieList.get(i).equals(movie)) {
				movieList.set(i, movie);
				break;
			}
		}

	}

	@Override
	public Movie getMovie(long movieId) throws Exception {
		// TODO Auto-generated method stub
		Movie movie = null;
		for (int i = 0; i < movieList.size(); i++) {
			if (movieList.get(i).getId() == movieId) {
				movie = movieList.get(i);
				break;
			}
		}
		if (movie == null) {
			throw new MovieNotFoundException("Movie Not Found");
		}
		return movie;
	}

}
