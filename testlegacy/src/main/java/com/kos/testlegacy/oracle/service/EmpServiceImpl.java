package com.kos.testlegacy.oracle.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kos.testlegacy.oracle.dao.EmpDAO;
import com.kos.testlegacy.oracle.vo.EmpVO;

@Service("empService")
@Transactional
public class EmpServiceImpl implements EmpService {
	private Logger logger = LogManager.getLogger(EmpServiceImpl.class);
	
	@Autowired(required = false)
	@Resource(name = "empDAO")
	private EmpDAO empDAO;
	
	@Override
	public List<EmpVO> empSelect() {
		// TODO Auto-generated method stub
		logger.info("testSelect() 함수 진입 >>> : ");
		
		return empDAO.empSelect();
	}

}
