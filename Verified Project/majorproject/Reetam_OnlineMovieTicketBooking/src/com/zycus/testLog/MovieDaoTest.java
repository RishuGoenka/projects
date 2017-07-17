package com.zycus.testLog;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.zycus.dao.MoviesDao;
import com.zycus.entity.PMovieShows;
import com.zycus.entity.PMovies;
import com.zycus.entity.PScreen;
import com.zycus.entity.PTicketRate;
import com.zycus.exceptions.DaoExceptions;
import com.zycus.exceptions.DataBaseException;
import com.zycus.frontController.TicketFrontController;

public class MovieDaoTest {
	Logger log = Logger.getLogger(TicketFrontController.class);
	@SuppressWarnings("deprecation")
	@Test
	public void getMovies() throws DataBaseException{
		MoviesDao dao=new MoviesDao();
		Date date=new Date("8/21/2013");
		List<PMovies> list=dao.getAllMoviesByDate(date);
		
		for(PMovies movies : list){
			System.out.println(movies.getMovieName());
			for(PMovieShows show : movies.getMovieShows()){
				//PShowTime time=dao.get(PShowTime.class, show.getId());
				System.out.println(show.getShowTime());
				System.out.println("Screen Id:"+show.getScreen().getId());
			}
		}
	}
	
	@Test
	public void showShows(){
		MoviesDao dao=new MoviesDao();
		
		List<PMovieShows> list=null;
		try {
			PMovies movie=dao.get(PMovies.class, 6);
			
			list = dao.getAllAvailableShows(movie);
			log.debug("hahahahaha");
		} catch (DataBaseException e) {
			// TODO Auto-generated catch block
			log.error("Error in get method", e);
			//e.printStackTrace();
		}
		
		for(PMovieShows show : list){
			System.out.println(show.getShowTime());
		}
	}
	
	@Test
	public void getTickets() throws DaoExceptions{
		MoviesDao dao=new MoviesDao();
		
		PScreen screen=null;
		try {
			screen=dao.get(PScreen.class, 1);
		} catch (DataBaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<PTicketRate> list=dao.getAllTickets(screen);
		for(PTicketRate ticket:list){
			System.out.println(ticket);
		}
		
	}
}
