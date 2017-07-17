package com.zycus.entity;

import java.util.ArrayList;
import java.util.List;

public class PScreen {

	private int id;
	private String screenName;
	
	private List<PTicketRate> ticket=new ArrayList<PTicketRate>();

	public String toString(){
		return id+"\t"+screenName;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public List<PTicketRate> getTicket() {
		return ticket;
	}

	public void setTicket(List<PTicketRate> ticket) {
		this.ticket = ticket;
	}
	
	
}
