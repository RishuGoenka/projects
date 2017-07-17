package com.zycus.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "test_result")
public class ResultEntity implements Serializable {

	private static final long serialVersionUID = 5150405260104361057L;

	@Id
	@GeneratedValue
	private int resultNumber;

	@ManyToOne
	private UserSubmissionEntity userSubmission;

	@Column(nullable=false)
	private double memoryConsumed;

	@Column(nullable=false)
	private double timeTaken;

	@Column(nullable=false)
	private boolean testCasebit;

	public int getResultNumber() {
		return resultNumber;
	}

	public void setResultNumber(int resultNumber) {
		this.resultNumber = resultNumber;
	}

	public UserSubmissionEntity getUserSubmission() {
		return userSubmission;
	}

	public void setUserSubmission(UserSubmissionEntity userSubmission) {
		this.userSubmission = userSubmission;
	}

	public double getMemoryConsumed() {
		return memoryConsumed;
	}

	public void setMemoryConsumed(double memoryConsumed) {
		this.memoryConsumed = memoryConsumed;
	}

	public double getTimeTaken() {
		return timeTaken;
	}

	public void setTimeTaken(double timeTaken) {
		this.timeTaken = timeTaken;
	}

	public boolean isTestCasebit() {
		return testCasebit;
	}

	public void setTestCasebit(boolean testCasebit) {
		this.testCasebit = testCasebit;
	}

	@Override
	public String toString() {
		return "Result [resultNumber=" + resultNumber + ", userSubmission="
				+ userSubmission + ", memoryConsumed=" + memoryConsumed
				+ ", timeTaken=" + timeTaken + ", testCasebit=" + testCasebit
				+ "]";
	}
}
