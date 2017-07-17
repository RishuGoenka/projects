package com.zycus.entity;

public class PMovieShows {

	private int id;
	private PScreen screen;
	private PShowTime showTime;
	private PMovies movie;
	
	public String toString(){
		return id+"\t"+screen.getId()+"\t"+showTime.getId()+"\t"+movie.getId();
	}
	
	public PScreen getScreen() {
		return screen;
	}
	public void setScreen(PScreen screen) {
		this.screen = screen;
	}
	public void setId(int id) {
		this.id = id;
	}
	public PShowTime getShowTime() {
		return showTime;
	}
	public void setShowTime(PShowTime showTime) {
		this.showTime = showTime;
	}
	public PMovies getMovie() {
		return movie;
	}
	public void setMovie(PMovies movie) {
		this.movie = movie;
	}
	public int getId() {
		return id;
	}
	
	
}
