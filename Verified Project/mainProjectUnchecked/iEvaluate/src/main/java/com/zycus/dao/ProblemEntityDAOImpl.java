package com.zycus.dao;


	import java.util.List;

	import javax.persistence.EntityManager;
	import javax.persistence.PersistenceContext;

	import org.springframework.stereotype.Repository;
	import org.springframework.transaction.annotation.Transactional;

	import com.zycus.model.ProblemEntity;

	@Repository
	@Transactional
	public class ProblemEntityDAOImpl implements ProblemEntityDAO {

		@PersistenceContext
	    private EntityManager manager;
		
		/* (non-Javadoc)
		 * @see com.zycus.dao.ProblemEntityDAO#getAllEmployees()
		 */
		@Override
		public List<ProblemEntity> getAllProblems() 
	    {
			return manager.createQuery("Select p From ProblemEntity p", ProblemEntity.class).getResultList();
	    }
		
	    /* (non-Javadoc)
		 * @see com.zycus.dao.ProblemEntityDAO#add(com.zycus.model.ProblemEntity)
		 */
	    @Override
		public void add(ProblemEntity ProblemEntity) 
	    {
	        manager.persist(ProblemEntity);
	    }
	    
	    /* (non-Javadoc)
		 * @see com.zycus.dao.ProblemEntityDAO#update(com.zycus.model.ProblemEntity)
		 */
	    @Override
		public void update(ProblemEntity ProblemEntity) 
	    {
	        manager.createQuery("update ProblemEntity set ProblemEntitytext=?, ProblemEntityname=?, ProblemEntitycategory=?, difficulty=? where ProblemEntityid=?")
	        .setParameter(1, ProblemEntity.getProblemText())
	        .setParameter(2, ProblemEntity.getProblemName())
	        .setParameter(3, ProblemEntity.getProblemCategory())
	        .setParameter(4, ProblemEntity.getDifficulty())
	        .setParameter(5, ProblemEntity.getProblemId())
	        .executeUpdate();
	    }
	    
	    /*public void update(ProblemEntity updatedProblemEntity) 
	    {
	       ProblemEntity ProblemEntity = (ProblemEntity) manager.find(ProblemEntity.class, updatedProblemEntity.getProblemEntityId());
	       ProblemEntity.setProblemEntityText(updatedProblemEntity.getProblemEntityText());
	       ProblemEntity.setProblemEntityName(updatedProblemEntity.getProblemEntityName());
	       ProblemEntity.setProblemEntityCategory(updatedProblemEntity.getProblemEntityCategory());
	       ProblemEntity.setDifficulty(updatedProblemEntity.getDifficulty());
	    }*/
	    
	    /* (non-Javadoc)
		 * @see com.zycus.dao.ProblemEntityDAO#delete(com.zycus.model.ProblemEntity)
		 */
	    @Override
		public void delete(ProblemEntity ProblemEntity) 
	    {
	        manager.remove(ProblemEntity);
	    }
	    
	    /* (non-Javadoc)
		 * @see com.zycus.dao.ProblemEntityDAO#getByID(int)
		 */
	    @Override
		public ProblemEntity getByID(int ProblemEntityId)
	    {
	    	return (ProblemEntity) manager.find(ProblemEntity.class, ProblemEntityId);
	    }
	    
	    /* (non-Javadoc)
		 * @see com.zycus.dao.ProblemEntityDAO#getByCategory(java.lang.String)
		 */
	    @Override
		@SuppressWarnings("unchecked")
		public List<ProblemEntity> getByCategory(String ProblemEntityCategory)
	    {
	    	return manager.createQuery("Select p From ProblemEntity p where p.ProblemEntityCategory=?")
	    			.setParameter(1, ProblemEntityCategory)
	    			.getResultList();
	    }
	    
	    /* (non-Javadoc)
		 * @see com.zycus.dao.ProblemEntityDAO#getByName(java.lang.String)
		 */
	    @Override
		@SuppressWarnings("unchecked")
		public List<ProblemEntity> getByName(String ProblemEntityname)
	    {
	    	return manager.createQuery("Select p From ProblemEntity p where p.ProblemEntityName=?")
	    			.setParameter(1, ProblemEntityname)
	    			.getResultList();
	    }
	    
	    /* (non-Javadoc)
		 * @see com.zycus.dao.ProblemEntityDAO#getByDifficulty(java.lang.String)
		 */
	    @Override
		@SuppressWarnings("unchecked")
		public List<ProblemEntity> getByDifficulty(String difficulty)
	    {
	    	return manager.createQuery("Select p From ProblemEntity p where p.difficulty=?")
	    			.setParameter(1, difficulty)
	    			.getResultList();
	    }
	}

