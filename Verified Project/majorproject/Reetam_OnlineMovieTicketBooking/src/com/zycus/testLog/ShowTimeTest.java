package com.zycus.testLog;

import org.junit.Test;

import com.zycus.dao.BaseDao;
import com.zycus.entity.PShowTime;
import com.zycus.exceptions.DataBaseException;

public class ShowTimeTest {

	@Test
	public void addShowTime() throws DataBaseException{
		BaseDao dao= new BaseDao();
		
		PShowTime showTime=new PShowTime();
		
		showTime.setShowTime("21:30");
		
		dao.saveOrUpdate(showTime);
	}
}
