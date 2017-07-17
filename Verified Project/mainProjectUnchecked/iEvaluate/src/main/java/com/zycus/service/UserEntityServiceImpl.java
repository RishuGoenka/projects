package com.zycus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zycus.dao.UserEntityDAO;
import com.zycus.dao.UserEntityDAOImpl;
import com.zycus.model.UserEntity;

@Service
public class UserEntityServiceImpl implements UserEntityService {
	@Autowired
	UserEntityDAO userDao = new UserEntityDAOImpl();
	/* (non-Javadoc)
	 * @see com.zycus.service.UserEntityService#save(com.zycus.model.UserEntity)
	 */
	@Override
	public  void save(UserEntity userObject){
		userDao.save(userObject);
	}

	/* (non-Javadoc)
	 * @see com.zycus.service.UserEntityService#getUserByID(int)
	 */
	@Override
	public  UserEntity getUserByID(int id){
		return userDao.getUserByID(id);
	}

	/* (non-Javadoc)
	 * @see com.zycus.service.UserEntityService#getAllUsers()
	 */
	@Override
	public  List<UserEntity> getAllUsers(){
		return userDao.getAllUsers();
	}

	/* (non-Javadoc)
	 * @see com.zycus.service.UserEntityService#update(com.zycus.model.UserEntity)
	 */
	@Override
	public  void update(UserEntity userObject){
		userDao.update(userObject);
	}

	/* (non-Javadoc)
	 * @see com.zycus.service.UserEntityService#getUserByEmail(java.lang.String)
	 */
	@Override
	public  UserEntity getUserByEmail(String emailString){
		return userDao.getUserByEmail(emailString);
	}

	/* (non-Javadoc)
	 * @see com.zycus.service.UserEntityService#isEmailAvailable(java.lang.String)
	 */
	@Override
	public  boolean isEmailAvailable(String email){
		return userDao.isEmailAvailable(email);
	}
}
