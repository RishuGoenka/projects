package com.zycus.dao;

public class DaoFactory {

	public MoviesDao getMovieMasterDao(){
		return new MoviesDao();
	}
	
	public UserDao getUserMasterDao(){
		return new UserDao();
	}
}
