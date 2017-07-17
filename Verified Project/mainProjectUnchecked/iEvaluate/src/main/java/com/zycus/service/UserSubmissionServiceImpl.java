package com.zycus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zycus.dao.UserSubmissionDAO;
import com.zycus.dao.UserSubmissionDAOImpl;
import com.zycus.model.UserSubmissionEntity;
@Service
public class UserSubmissionServiceImpl implements UserSubmissionService {
	@Autowired
	UserSubmissionDAO userSubmissionDao = new UserSubmissionDAOImpl();
	
	
	/* (non-Javadoc)
	 * @see com.zycus.service.UserSubmissionService#getById(int)
	 */
	@Override
	public UserSubmissionEntity getById(int submissionId){
		return userSubmissionDao.getById(submissionId);
	}

	/* (non-Javadoc)
	 * @see com.zycus.service.UserSubmissionService#getByUserProblem(int, int)
	 */
	@Override
	public UserSubmissionEntity getByUserProblem(int userId,
			int problemId){
		return userSubmissionDao.getByUserProblem(userId, problemId);
	}

	/* (non-Javadoc)
	 * @see com.zycus.service.UserSubmissionService#saveUserSubmission(com.zycus.model.UserSubmissionEntity)
	 */
	@Override
	public void saveUserSubmission(UserSubmissionEntity submission){
		userSubmissionDao.saveUserSubmission(submission);
	}

	/* (non-Javadoc)
	 * @see com.zycus.service.UserSubmissionService#deleteUserSubmission(com.zycus.model.UserSubmissionEntity)
	 */
	@Override
	public void deleteUserSubmission(UserSubmissionEntity submission){
		userSubmissionDao.deleteUserSubmission(submission);
	}
}
