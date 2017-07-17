package com.zycus.testLog;

import org.junit.Test;

import com.zycus.dao.BaseDao;
import com.zycus.entity.PScreen;
import com.zycus.entity.PTicketRate;
import com.zycus.exceptions.DataBaseException;

public class ScreenTest {

	@Test
	public void addScreen() throws DataBaseException{
		BaseDao dao=new BaseDao();
		PScreen screen=new PScreen();
		screen.setScreenName("INOX");
		dao.saveOrUpdate(screen);
	}
	
	@Test
	public void addTickets() throws DataBaseException{
		BaseDao dao=new BaseDao();
		PScreen screen=dao.get(PScreen.class, 2);
		PTicketRate ticket=new PTicketRate();
		ticket.setScreen(screen);
		ticket.setSeatType("type1");
		ticket.setTotalSeats(30);
		ticket.setValueOfBooking(200);
		
		dao.saveOrUpdate(ticket);
	}
	
	@Test
	public void addTicketsII() throws DataBaseException{
		BaseDao dao=new BaseDao();
		PScreen screen=dao.get(PScreen.class, 2);
		//screen.setScreenName("IMAX");
		PTicketRate ticket1=new PTicketRate();
		ticket1.setScreen(screen);
		ticket1.setSeatType("type2");
		ticket1.setTotalSeats(40);
		ticket1.setValueOfBooking(150);
		ticket1.setScreen(screen);
		
		PTicketRate ticket2=new PTicketRate();
		ticket2.setScreen(screen);
		ticket2.setSeatType("type3");
		ticket2.setTotalSeats(50);
		ticket2.setValueOfBooking(100);
		ticket2.setScreen(screen);
		
		dao.saveOrUpdate(ticket1);
		dao.saveOrUpdate(ticket2);
	}
}
