package com.zycus.testLog;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.zycus.dao.BaseDao;
import com.zycus.entity.PUser;
import com.zycus.exceptions.DataBaseException;

public class UserTest {
	Logger log=Logger.getLogger(UserTest.class);

	@Test
	public void addUser(){
		
		BaseDao dao=new BaseDao();
		
		PUser user=new PUser();
		
		user.setName("Reetam Nath");
		user.setEmail("reetamnath@gmail.com");
		user.setPassword("abcd");
		user.setAddress("Liluah, Howrah");
		user.setPhoneNo("9062558998");

		try {
			dao.saveOrUpdate(user);
		} catch (DataBaseException e) {
			log.debug("user:"+user);
			log.error(e.getMessage(), e);
		}
	}
}
