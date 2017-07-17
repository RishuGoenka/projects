package com.zycus.service;

import com.zycus.model.UserSubmissionEntity;

public interface UserSubmissionService {

	public abstract UserSubmissionEntity getById(int submissionId);

	public abstract UserSubmissionEntity getByUserProblem(int userId,
			int problemId);

	public abstract void saveUserSubmission(UserSubmissionEntity submission);

	public abstract void deleteUserSubmission(UserSubmissionEntity submission);

}