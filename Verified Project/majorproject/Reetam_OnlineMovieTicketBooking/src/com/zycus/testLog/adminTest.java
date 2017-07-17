package com.zycus.testLog;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.zycus.dao.BaseDao;
import com.zycus.entity.PMovieShows;
import com.zycus.entity.PMovies;
import com.zycus.entity.PScreen;
import com.zycus.entity.PShowTime;
import com.zycus.exceptions.DataBaseException;

public class adminTest {
	Logger log=Logger.getLogger(adminTest.class);

	@Test
	public void addMovieShows() {
		BaseDao dao=new BaseDao();
		PMovies movie=null;
		PScreen screen=null;
		PShowTime showTime=null;
		PMovieShows movieShow=null;
		
		try {
			movie=dao.get(PMovies.class, 2);
			screen=dao.get(PScreen.class, 1);
			showTime=dao.get(PShowTime.class,3);
			
			movieShow=new PMovieShows();
			movieShow.setMovie(movie);
			movieShow.setScreen(screen);
			movieShow.setShowTime(showTime);
			
			dao.saveOrUpdate(movieShow);
		} catch (DataBaseException e) {
			log.debug("movie:"+movie);
			log.debug("shows:"+movieShow);
			log.debug("time:"+showTime);
			log.debug("screen:"+screen);
			log.error(e.getMessage(), e);
		}
	}
}
