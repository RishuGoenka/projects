package com.zycus.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PMovies {

	private int id;
	private String movieName;
	private String medium;
	private Date dateStartsFrom;
	private Date dateEnds;
	
	private List<PMovieShows> movieShows=new ArrayList<PMovieShows>();
	private List<PBooking> bookings=new ArrayList<PBooking>();
	
	public String toString(){
		return id+"\t"+movieName+"\t"+medium+"\t"+dateStartsFrom+"\t"+dateEnds;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMedium() {
		return medium;
	}
	public void setMedium(String medium) {
		this.medium = medium;
	}
	public Date getDateStartsFrom() {
		return dateStartsFrom;
	}
	public void setDateStartsFrom(Date dateStartsFrom) {
		this.dateStartsFrom = dateStartsFrom;
	}
	public Date getDateEnds() {
		return dateEnds;
	}
	public void setDateEnds(Date dateEnds) {
		this.dateEnds = dateEnds;
	}
	public List<PMovieShows> getMovieShows() {
		return movieShows;
	}
	public void setMovieShows(List<PMovieShows> movieShows) {
		this.movieShows = movieShows;
	}
	public List<PBooking> getBookings() {
		return bookings;
	}
	public void setBookings(List<PBooking> bookings) {
		this.bookings = bookings;
	}
	public int getId() {
		return id;
	}
	
	
}
