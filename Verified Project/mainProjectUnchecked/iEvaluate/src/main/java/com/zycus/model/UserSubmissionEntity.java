package com.zycus.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "submission")

public class UserSubmissionEntity implements Serializable {

	private static final long serialVersionUID = -2860477707632724889L;

	@Id
	@GeneratedValue
	private int submissionId;

	@ManyToOne
	private UserEntity user;

	@ManyToOne
	private ProblemEntity problem;

	@Column(nullable=false)
	private int versionNumber;

	public UserSubmissionEntity(int userId) {
		this.user = new UserEntity(userId);
	}

	public int getSubmissionId() {
		return submissionId;
	}

	public void setSubmissionId(int submissionId) {
		this.submissionId = submissionId;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public ProblemEntity getProblem() {
		return problem;
	}

	public void setProblem(ProblemEntity problem) {
		this.problem = problem;
	}

	public int getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(int versionNumber) {
		this.versionNumber = versionNumber;
	}

	@Override
	public String toString() {
		return "UserSubmissionEntity [submissionId=" + submissionId + ", user="
				+ user + ", problem=" + problem + ", versionNumber="
				+ versionNumber + "]";
	}

}
