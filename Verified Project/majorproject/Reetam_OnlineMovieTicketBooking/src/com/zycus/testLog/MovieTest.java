package com.zycus.testLog;

import java.util.Date;

import org.junit.Test;

import com.zycus.dao.BaseDao;
import com.zycus.entity.PMovies;
import com.zycus.exceptions.DataBaseException;

public class MovieTest {

	@Test
	public void addNewMovie() throws DataBaseException{
		BaseDao dao=new BaseDao();
		
		PMovies movie=new PMovies();
		movie.setMovieName("Man Of Steel");
		movie.setMedium("English");
		movie.setDateStartsFrom(new Date("08/21/2013"));
		movie.setDateEnds(new Date("09/12/2013"));
		
		dao.saveOrUpdate(movie);
	}
}
