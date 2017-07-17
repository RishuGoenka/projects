package com.zycus.testLog;

import org.junit.Test;

import com.zycus.dao.UserDao;
import com.zycus.entity.PUser;
import com.zycus.exceptions.DaoExceptions;

public class UserDaoTest {

	@Test
	public void addNewUserInDb(){
		UserDao dao=new UserDao();
		
		PUser user=new PUser();
		user.setName("Monoj Mondal");
		user.setEmail("monoj@gmail.com");
		user.setPassword("1234");
		user.setAddress("Ichapure, Howrah");
		user.setPhoneNo("9163904417");
		
		try {
			user=dao.addNewUser(user);
			System.out.println(user);
		} catch (DaoExceptions e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void getAuthentication(){
		UserDao dao=new UserDao();
		
		PUser user=new PUser();
		user.setEmail("reetamnath@gmail.com");
		user.setPassword("abcd");
		
		try {
			user=dao.isAuthenticatedUser(user);
		} catch (DaoExceptions e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(user.getName());
		
	}
}
