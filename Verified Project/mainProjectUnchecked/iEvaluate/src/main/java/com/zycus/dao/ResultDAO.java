package com.zycus.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zycus.model.ResultEntity;

@Repository
public interface ResultDAO {

	public abstract List<ResultEntity> getById(int submissionId);

	public abstract void saveResult(ResultEntity result);

	public abstract void deleteResult(ResultEntity result);

}