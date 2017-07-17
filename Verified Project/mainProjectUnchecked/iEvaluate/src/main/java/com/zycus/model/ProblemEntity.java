package com.zycus.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table (name="problem")
public class ProblemEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5433178729946475203L;
	@Id
	@GeneratedValue
	@Column(name="problemid")
	private int problemId;
	

	@Column(name="problemtext")
	private String problemText;
	
	@Column(name="problemname")
	private String problemName;
	
	@Column(name="problemcategory" )
	private String problemCategory;
	
	@Column(name="difficulty")
	private String difficulty;
	
	public ProblemEntity(int problemId, String problemText, String problemName,
			String problemCategory, String difficulty) {
		super();
		this.problemId = problemId;
		this.problemText = problemText;
		this.problemName = problemName;
		this.problemCategory = problemCategory;
		this.difficulty = difficulty;
	}
	public ProblemEntity() {
		super();
	}
	public int getProblemId() {
		return problemId;
	}
	public void setProblemId(int problemId) {
		this.problemId = problemId;
	}
	public String getProblemText() {
		return problemText;
	}
	public void setProblemText(String problemText) {
		this.problemText = problemText;
	}
	public String getProblemName() {
		return problemName;
	}
	public void setProblemName(String problemName) {
		this.problemName = problemName;
	}
	public String getProblemCategory() {
		return problemCategory;
	}
	public void setProblemCategory(String problemCategory) {
		this.problemCategory = problemCategory;
	}
	public String getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	@Override
	public String toString() {
		return "Problem [problemId=" + problemId + ", problemText="
				+ problemText + ", problemName=" + problemName
				+ ", problemCategory=" + problemCategory + ", difficulty="
				+ difficulty + "]";
	}
	
}
