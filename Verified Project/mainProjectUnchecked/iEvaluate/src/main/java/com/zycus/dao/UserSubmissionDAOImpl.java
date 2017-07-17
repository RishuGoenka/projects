package com.zycus.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.zycus.model.UserSubmissionEntity;

@Repository
@Transactional
public class UserSubmissionDAOImpl implements UserSubmissionDAO {
	@PersistenceContext
	private EntityManager manager;

	/* (non-Javadoc)
	 * @see com.zycus.dao.UserSubmissionDAO#getById(int)
	 */
	@Override
	public UserSubmissionEntity getById(int submissionId) {
		return manager.find(UserSubmissionEntity.class, submissionId);
	}

	/* (non-Javadoc)
	 * @see com.zycus.dao.UserSubmissionDAO#getByUserProblem(int, int)
	 */
	@Override
	public UserSubmissionEntity getByUserProblem(int userId, int problemId) {
		return (UserSubmissionEntity) manager
				.createQuery(
						"Select table1 From UserSubmission table1 Where table1.user.userId = ? And table1.problem.problemId = ?")
				.setParameter(1, userId).setParameter(2, problemId);
	}

	/* (non-Javadoc)
	 * @see com.zycus.dao.UserSubmissionDAO#saveUserSubmission(com.zycus.model.UserSubmissionEntity)
	 */
	@Override
	public void saveUserSubmission(UserSubmissionEntity submission) {
		manager.persist(submission);
	}

	/* (non-Javadoc)
	 * @see com.zycus.dao.UserSubmissionDAO#deleteUserSubmission(com.zycus.model.UserSubmissionEntity)
	 */
	@Override
	public void deleteUserSubmission(UserSubmissionEntity submission) {
		manager.remove(submission);
	}
}