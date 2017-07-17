package com.zycus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zycus.dao.ResultDAO;
import com.zycus.dao.ResultDAOImpl;
import com.zycus.model.ResultEntity;

@Service
public class ResultServiceImpl implements ResultService {
	
	@Autowired
	ResultDAO resultDao = new ResultDAOImpl();
	
	/* (non-Javadoc)
	 * @see com.zycus.service.ResultService#setResultDao(com.zycus.dao.ResultDAO)
	 */
	@Override
	public void setResultDao(ResultDAO resultDao) {
		this.resultDao = resultDao;
	}

	/* (non-Javadoc)
	 * @see com.zycus.service.ResultService#getById(int)
	 */
	@Override
	public  List<ResultEntity> getById(int submissionId){
		return resultDao.getById(submissionId);
	}

	/* (non-Javadoc)
	 * @see com.zycus.service.ResultService#saveResult(com.zycus.model.ResultEntity)
	 */
	@Override
	public  void saveResult(ResultEntity result){
		resultDao.saveResult(result);
	}

	/* (non-Javadoc)
	 * @see com.zycus.service.ResultService#deleteResult(com.zycus.model.ResultEntity)
	 */
	@Override
	public  void deleteResult(ResultEntity result){
		resultDao.deleteResult(result);
	}
}
