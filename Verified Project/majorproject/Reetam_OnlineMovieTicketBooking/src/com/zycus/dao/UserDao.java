package com.zycus.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.zycus.entity.PUser;
import com.zycus.exceptions.DaoExceptions;
import com.zycus.exceptions.DataBaseException;
import com.zycus.utility.HibernateUtil;

public class UserDao extends BaseDao{

	
	public PUser addNewUser(PUser user) throws DaoExceptions{
		try {
			saveOrUpdate(user);
		} catch (DataBaseException e) {
			e.printStackTrace();
			throw new DaoExceptions("Problem in dao.",e);
		}
		return user;
	}
	
	@SuppressWarnings("unchecked")
	public PUser isAuthenticatedUser(PUser user) throws DaoExceptions{
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria crit=session.createCriteria(PUser.class);
		crit.add(Restrictions.eq("email", user.getEmail()));
		crit.add(Restrictions.eq("password", user.getPassword()));
		List<PUser> list=crit.list();
		try{
			tx.commit();
		}
		catch(Exception ex){
			tx.rollback();
			ex.printStackTrace();
			throw new DaoExceptions("Problem in dao.",ex);
		}
		if(list.size()==1){
			user=list.get(0);
		}
		else{
			user=null;
		}
		return user;
	}
}
