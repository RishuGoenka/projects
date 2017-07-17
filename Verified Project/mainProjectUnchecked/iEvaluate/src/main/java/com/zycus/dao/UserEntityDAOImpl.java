package com.zycus.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zycus.model.UserEntity;
@SuppressWarnings("unchecked")
@Repository
@Transactional
public class UserEntityDAOImpl implements UserEntityDAO {

	@PersistenceContext
	private EntityManager manager;

	/* (non-Javadoc)
	 * @see com.zycus.dao.UserEntityDAO#save(com.zycus.model.UserEntity)
	 */
	@Override
	public void save(UserEntity userObject) {

		manager.persist(userObject);
	}

	/* (non-Javadoc)
	 * @see com.zycus.dao.UserEntityDAO#getUserByID(int)
	 */
	@Override
	public UserEntity getUserByID(int id) {

		return manager.find(UserEntity.class, id);
	}

	/* (non-Javadoc)
	 * @see com.zycus.dao.UserEntityDAO#getAllUsers()
	 */
	@Override
	public List<UserEntity> getAllUsers() {

		
		List<UserEntity> userList = manager.createQuery("Select u from UserEntity u")
				.getResultList();
		return userList;
	}

	/* (non-Javadoc)
	 * @see com.zycus.dao.UserEntityDAO#update(com.zycus.model.UserEntity)
	 */
	@Override
	public void update(UserEntity userObject) {

		UserEntity persistentUserEntity = manager.find(UserEntity.class, userObject.getUserId());
		persistentUserEntity = userObject;

	}

	/* (non-Javadoc)
	 * @see com.zycus.dao.UserEntityDAO#getUserByEmail(java.lang.String)
	 */
	@Override
	public UserEntity getUserByEmail(String emailString) {

		UserEntity userObject = null;
		userObject = (UserEntity) manager
				.createQuery("Select u from UserEntity u where u.email =:emailId")
				.setParameter("emailId", emailString).getSingleResult();
		return userObject;
	}

	/* (non-Javadoc)
	 * @see com.zycus.dao.UserEntityDAO#isEmailAvailable(java.lang.String)
	 */
	@Override
	public boolean isEmailAvailable(String email) {

		long value = (Long) manager
				.createQuery(
						"Select COUNT(u) from UserEntity u where u.email =:emailId")
				.setParameter("emailId", email).getSingleResult();

		System.out.println(value);
		if (value == 1) {
			return true;
		} else {
			return false;
		}

	}

}
