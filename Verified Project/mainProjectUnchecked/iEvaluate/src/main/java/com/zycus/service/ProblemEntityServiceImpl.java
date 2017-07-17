package com.zycus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zycus.dao.ProblemEntityDAO;
import com.zycus.dao.ProblemEntityDAOImpl;
import com.zycus.model.ProblemEntity;
@Service
public class ProblemEntityServiceImpl implements ProblemEntityService {

	@Autowired
	ProblemEntityDAO problemDAO = new ProblemEntityDAOImpl();

	/* (non-Javadoc)
	 * @see com.zycus.service.ProblemEntityService#setProblemDAO(com.zycus.dao.ProblemEntityDAO)
	 */
	@Override
	public void setProblemDAO(ProblemEntityDAO problemDAO) {
		this.problemDAO = problemDAO;
	}
	
	/* (non-Javadoc)
	 * @see com.zycus.service.ProblemEntityService#getAllProblems()
	 */
	@Override
	public  List<ProblemEntity> getAllProblems(){
		return problemDAO.getAllProblems();
	}

	/* (non-Javadoc)
	 * @see com.zycus.service.ProblemEntityService#add(com.zycus.model.ProblemEntity)
	 */
	@Override
	public  void add(ProblemEntity ProblemEntity){
		problemDAO.add(ProblemEntity);
	}

	/* (non-Javadoc)
	 * @see com.zycus.service.ProblemEntityService#update(com.zycus.model.ProblemEntity)
	 */
	@Override
	public  void update(ProblemEntity ProblemEntity){
		problemDAO.update(ProblemEntity);
	}

	/* (non-Javadoc)
	 * @see com.zycus.service.ProblemEntityService#delete(com.zycus.model.ProblemEntity)
	 */
	@Override
	public  void delete(ProblemEntity ProblemEntity){
		problemDAO.delete(ProblemEntity);
	}

	/* (non-Javadoc)
	 * @see com.zycus.service.ProblemEntityService#getByID(int)
	 */
	@Override
	public  ProblemEntity getByID(int ProblemEntityId){
		return problemDAO.getByID(ProblemEntityId);
	}

	/* (non-Javadoc)
	 * @see com.zycus.service.ProblemEntityService#getByCategory(java.lang.String)
	 */
	@Override
	public  List<ProblemEntity> getByCategory(
			String ProblemEntityCategory){
		return problemDAO.getByCategory(ProblemEntityCategory);
	}

	/* (non-Javadoc)
	 * @see com.zycus.service.ProblemEntityService#getByName(java.lang.String)
	 */
	@Override
	public  List<ProblemEntity> getByName(String ProblemEntityname){
		return problemDAO.getByName(ProblemEntityname);
	}

	/* (non-Javadoc)
	 * @see com.zycus.service.ProblemEntityService#getByDifficulty(java.lang.String)
	 */
	@Override
	public  List<ProblemEntity> getByDifficulty(String difficulty){
		return problemDAO.getByDifficulty(difficulty);
	}
}
