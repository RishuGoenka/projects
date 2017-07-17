package com.zycus.service;

import java.util.List;

import com.zycus.dao.ProblemEntityDAO;
import com.zycus.model.ProblemEntity;

public interface ProblemEntityService {

	public abstract void setProblemDAO(ProblemEntityDAO problemDAO);

	public abstract List<ProblemEntity> getAllProblems();

	public abstract void add(ProblemEntity ProblemEntity);

	public abstract void update(ProblemEntity ProblemEntity);

	public abstract void delete(ProblemEntity ProblemEntity);

	public abstract ProblemEntity getByID(int ProblemEntityId);

	public abstract List<ProblemEntity> getByCategory(
			String ProblemEntityCategory);

	public abstract List<ProblemEntity> getByName(String ProblemEntityname);

	public abstract List<ProblemEntity> getByDifficulty(String difficulty);

}