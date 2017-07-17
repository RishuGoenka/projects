package com.zycus.entity;

import java.util.Date;

public class PBooking {

	private int id;
	private Date dateOfBooking;
	private Date showDate;
	private String seatNo;
	
	private PUser user;
	//private PScreen screen;
	private PMovies movie;
	private PMovieShows movieShow;
	private PTicketRate ticket;
	
	public String toString(){
		return id+"\t"+dateOfBooking+"\t"+showDate+"\t"+seatNo+"\t"+user.getId()+"\t"+movie.getId()+"\t"+movieShow.getId()+"\t"+ticket.getId();
	}
	
	public Date getDateOfBooking() {
		return dateOfBooking;
	}
	public void setDateOfBooking(Date dateOfBooking) {
		this.dateOfBooking = dateOfBooking;
	}
	public Date getShowDate() {
		return showDate;
	}
	public void setShowDate(Date showDate) {
		this.showDate = showDate;
	}
	public String getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}
	public PUser getUser() {
		return user;
	}
	public void setUser(PUser user) {
		this.user = user;
	}
	/*public PScreen getScreen() {
		return screen;
	}
	public void setScreen(PScreen screen) {
		this.screen = screen;
	}*/
	public PMovies getMovie() {
		return movie;
	}
	public void setMovie(PMovies movie) {
		this.movie = movie;
	}
	
	public PMovieShows getMovieShow() {
		return movieShow;
	}
	public void setMovieShow(PMovieShows movieShow) {
		this.movieShow = movieShow;
	}
	public PTicketRate getTicket() {
		return ticket;
	}
	public void setTicket(PTicketRate ticket) {
		this.ticket = ticket;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
