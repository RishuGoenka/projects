package com.zycus.fasad;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.zycus.dao.DaoFactory;
import com.zycus.dao.MoviesDao;
import com.zycus.dao.UserDao;
import com.zycus.entity.PMovies;
import com.zycus.entity.PUser;
import com.zycus.exceptions.DaoExceptions;

public class Fasad {
	DaoFactory factory;
	UserDao userMasterDao;
	MoviesDao movieMasterDao;
	Logger log=Logger.getLogger(Fasad.class);
	

	public Fasad() {
		factory=new DaoFactory();
		userMasterDao=factory.getUserMasterDao();
		movieMasterDao=factory.getMovieMasterDao();
	}

	
	public PUser getValidUser(PUser newUser) {
		PUser chekedUser=null;
		try {
			chekedUser=userMasterDao.isAuthenticatedUser(newUser);
		} catch (DaoExceptions e) {
			log.error(newUser);
			log.error("Error in getValidUser() in fasad.",e);
			e.printStackTrace();
		}
		return chekedUser;
		
	}


	public List<PMovies> getMoviesByDate(Date date) {
		List<PMovies> movieList=null;
		try {
			movieList=movieMasterDao.getAllMoviesByDate(date);
		} catch (DaoExceptions e) {
			log.error(date);
			log.error("Error in getMoviesByDate() in fasad.",e);
			e.printStackTrace();
		}
		return movieList;
	}

}
