package com.zycus.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.zycus.model.ResultEntity;

@Repository
@Transactional
public class ResultDAOImpl implements ResultDAO {
	@PersistenceContext
	private EntityManager manager;

	/* (non-Javadoc)
	 * @see com.zycus.dao.ResultDAO#getById(int)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<ResultEntity> getById(int submissionId) {
		List<ResultEntity> results = manager
				.createQuery(
						"From Test_Result table1 Where table1.userSubmission.submissionId = ?")
				.setParameter(1, submissionId).getResultList();
		return results;
	}

	/* (non-Javadoc)
	 * @see com.zycus.dao.ResultDAO#saveResult(com.zycus.model.ResultEntity)
	 */
	@Override
	public void saveResult(ResultEntity result) {
		manager.persist(result);
	}

	/* (non-Javadoc)
	 * @see com.zycus.dao.ResultDAO#deleteResult(com.zycus.model.ResultEntity)
	 */
	@Override
	public void deleteResult(ResultEntity result) {
		manager.remove(result);
	}
}