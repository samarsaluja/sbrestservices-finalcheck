package com.cognizant.moviecruiser.model;

import java.util.List;

public class Favourite {

	private List<Movie> movieList;
	private long noOfFavorites;

	public Favourite() {
		super();
	}

	public List<Movie> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<Movie> movieList) {
		this.movieList = movieList;
	}

	public long getNoOfFavorites() {
		return noOfFavorites;
	}

	public void setNoOfFavorites(long noOfFavorites) {
		this.noOfFavorites = noOfFavorites;
	}

	public Favourite(List<Movie> movieList, long noOfFavorites) {
		super();
		this.movieList = movieList;
		this.noOfFavorites = noOfFavorites;
	}

	@Override
	public String toString() {
		return "Favourite [movieList=" + movieList + ", noOfFavorites=" + noOfFavorites + "]";
	}

}
