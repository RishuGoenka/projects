package com.zycus.entity;

public class PTicketRate {

	private int id;
	private double valueOfBooking;
	private String seatType;
	private int totalSeats;

	private PScreen screen;

	public String toString(){
		return id+"\t"+valueOfBooking+"\t"+seatType+"\t"+totalSeats+"\t"+screen.getId();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getValueOfBooking() {
		return valueOfBooking;
	}

	public void setValueOfBooking(double valueOfBooking) {
		this.valueOfBooking = valueOfBooking;
	}

	public String getSeatType() {
		return seatType;
	}

	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	public PScreen getScreen() {
		return screen;
	}

	public void setScreen(PScreen screen) {
		this.screen = screen;
	}


}
