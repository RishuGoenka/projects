package com.zycus.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.zycus.exceptions.DataBaseException;
import com.zycus.utility.HibernateUtil;

public class BaseDao{

	/*public void chaloSaveKarein(Object obj) throws DataBaseException{
		//Using JPA this time
		//Step No 1: We need an EntityManagerFactory Object
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("JPA");
		//Step no 2: We need an entity manager Object
		EntityManager em=emf.createEntityManager();
		//Step no 3: We need to bind the entityManager to an active transaction
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		
		em.merge(obj);//insert or update
		try{
			tx.commit();
		}
		catch(Exception ex){
			ex.printStackTrace();
			tx.rollback();
			throw new DataBaseException("Problem Regarding Database",ex);
		}
		finally{
			em.close();
		}
	}*/
	
	public void saveOrUpdate(Object obj) throws DataBaseException{
		//Step No. 1: We need to access the SessionFactory object.
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		//Step No. 2: We need a session object
		Session session=sessionFactory.getCurrentSession();
		//Step No. 3: We need an active Transaction
		Transaction tx=session.beginTransaction();
		//for transient object, saveOrUpdate will generate insert query
		//for detached obbject, saveOrUpdate will generate update query
		session.saveOrUpdate(obj); //insert oe update
		try{
			tx.commit();
		}
		catch(Exception ex){
			tx.rollback();
			ex.printStackTrace();
			throw new DataBaseException("Problem Regarding Database",ex);
			//should throw an exception to report the failur
		}
		//try catch
	}
	
	
	/*public void update(Object obj){
		//Step No. 1: We need to access the SessionFactory object.
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		//Step No. 2: We need a session object
		Session session=sessionFactory.getCurrentSession();
		//Step No. 3: We need an active Transaction
		Transaction tx=session.beginTransaction();
		//Now the code for insert
		session.update(obj); //insert
		try{
			tx.commit();
		}
		catch(Exception ex){
			tx.rollback();
			ex.printStackTrace();
			//should throw an exception to report the failur
		}
		//try catch
	}*/
	
	@SuppressWarnings("unchecked")
	public <E> E get(Class<E> classname, Serializable pk) throws DataBaseException{
		//Step No. 1: We need to access the SessionFactory object.
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		//Step No. 2: We need a session object
		Session session=sessionFactory.getCurrentSession();
		//Step No. 3: We need an active Transaction
		Transaction tx=session.beginTransaction();
		//Now the code for insert
		E e=(E)session.get(classname,pk); //Select based on pk.
		try{
			tx.commit();
		}
		catch(Exception ex){
			tx.rollback();
			ex.printStackTrace();
			throw new DataBaseException("Problem Regarding Database",ex);
			//should throw an exception to report the failur
		}
		return e;
	}
}
