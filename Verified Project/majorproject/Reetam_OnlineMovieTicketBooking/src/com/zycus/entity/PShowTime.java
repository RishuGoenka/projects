package com.zycus.entity;

public class PShowTime {

	private int id;
	private String showTime;
	
	public String toString(){
		return id+"\t"+showTime;
	}
	
	public String getShowTime() {
		return showTime;
	}
	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
