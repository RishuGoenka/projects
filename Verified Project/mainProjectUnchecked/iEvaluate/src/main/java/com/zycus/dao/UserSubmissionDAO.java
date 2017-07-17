package com.zycus.dao;

import com.zycus.model.UserSubmissionEntity;

public interface UserSubmissionDAO {

	public abstract UserSubmissionEntity getById(int submissionId);

	public abstract UserSubmissionEntity getByUserProblem(int userId,
			int problemId);

	public abstract void saveUserSubmission(UserSubmissionEntity submission);

	public abstract void deleteUserSubmission(UserSubmissionEntity submission);

}