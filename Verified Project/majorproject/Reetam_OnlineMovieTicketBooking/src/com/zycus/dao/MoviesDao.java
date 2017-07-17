package com.zycus.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;

import com.zycus.entity.PMovieShows;
import com.zycus.entity.PMovies;
import com.zycus.entity.PScreen;
import com.zycus.entity.PTicketRate;
import com.zycus.exceptions.DaoExceptions;
import com.zycus.utility.HibernateUtil;

public class MoviesDao extends BaseDao{

	@SuppressWarnings("unchecked")
	public List<PMovies> getAllMoviesByDate(Date date) throws DaoExceptions{
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		
		Criteria crit=session.createCriteria(PMovies.class);
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		crit.add(Restrictions.ge("dateEnds", date));
		crit.add(Restrictions.le("dateStartsFrom", date));
		Criteria movieShowcrit=crit.createCriteria("movieShows",CriteriaSpecification.LEFT_JOIN);
		movieShowcrit.createCriteria("showTime", CriteriaSpecification.LEFT_JOIN);
		List<PMovies> list=crit.list();
		try{
			tx.commit();
		}
		catch(Exception ex){
			tx.rollback();
			ex.printStackTrace();
			throw new DaoExceptions("Problem in MovieDao.",ex);
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<PMovieShows> getAllAvailableShows(PMovies movie) throws DaoExceptions{
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		
		Criteria crit=session.createCriteria(PMovieShows.class);
		crit.createCriteria("showTime", CriteriaSpecification.LEFT_JOIN);
		crit.add(Restrictions.eq("movie", movie));
		List<PMovieShows> list=crit.list();
		
		try{
			tx.commit();
		}
		catch(Exception ex){
			tx.rollback();
			ex.printStackTrace();
			throw new DaoExceptions("Problem in MovieDao.",ex);
		}
		return list;
	}
	

	@SuppressWarnings("unchecked")
	public List<PTicketRate> getAllTickets(PScreen screen) throws DaoExceptions{
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		
		Criteria crit=session.createCriteria(PTicketRate.class);
		crit.add(Restrictions.eq("screen", screen));
		List<PTicketRate> list=crit.list();
		
		try{
			tx.commit();
		}
		catch(Exception ex){
			tx.rollback();
			ex.printStackTrace();
			throw new DaoExceptions("Problem in MovieDao.",ex);
		}
		return list;
	}
}
