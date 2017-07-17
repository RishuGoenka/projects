package com.zycus.testLog;

import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.zycus.dao.BaseDao;
import com.zycus.entity.PBooking;
import com.zycus.entity.PMovieShows;
import com.zycus.entity.PMovies;
import com.zycus.entity.PScreen;
import com.zycus.entity.PShowTime;
import com.zycus.entity.PTicketRate;
import com.zycus.entity.PUser;
import com.zycus.exceptions.DataBaseException;

public class BookingTest {
	Logger log=Logger.getLogger(BookingTest.class);

	@SuppressWarnings("deprecation")
	@Test
	public void addNewBooking() {
		BaseDao dao=new BaseDao();
		PMovies movie=null;
		PUser user=null;
		PMovieShows shows=null;
		PShowTime time=null;
		PScreen screen=null;
		PTicketRate ticket=null;
		PBooking booking=new PBooking();
		
		try {
			movie=dao.get(PMovies.class, 1);
			user=dao.get(PUser.class, 1);
			shows=dao.get(PMovieShows.class, 1);
			time=dao.get(PShowTime.class, shows.getShowTime().getId());
			screen=dao.get(PScreen.class,shows.getScreen().getId());
			ticket=dao.get(PTicketRate.class, 2);
			
			
			booking.setDateOfBooking(new Date());
			booking.setShowDate(new Date("08/25/2013"));
			booking.setMovie(movie);
			booking.setMovieShow(shows);
			booking.setSeatNo("TI1");
			booking.setTicket(ticket);
			booking.setUser(user);
			
			dao.saveOrUpdate(booking);
		} catch (DataBaseException e) {
			log.debug("movie:"+movie);
			log.debug("user:"+user);
			log.debug("shows:"+shows);
			log.debug("time:"+time);
			log.debug("screen:"+screen);
			log.debug("ticket:"+ticket);
			log.error(e.getMessage(), e);
		}
		
		
		
	}
}
