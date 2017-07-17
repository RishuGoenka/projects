package com.zycus.service;

import java.util.List;

import com.zycus.dao.ResultDAO;
import com.zycus.model.ResultEntity;

public interface ResultService {

	public abstract void setResultDao(ResultDAO resultDao);

	public abstract List<ResultEntity> getById(int submissionId);

	public abstract void saveResult(ResultEntity result);

	public abstract void deleteResult(ResultEntity result);

}