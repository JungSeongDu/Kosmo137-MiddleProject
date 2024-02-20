package com.kos.testlegacy.os.rboard.service;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kos.testlegacy.os.rboard.dao.OsRboardDAO;
import com.kos.testlegacy.os.rboard.vo.OsRboardVO;

@Service
@Transactional
public class OsRboardServiceImpl implements OsRboardService {
	Logger logger = LogManager.getLogger(OsRboardServiceImpl.class);
	
	// 서비스에서 DAO 연결하기 
	// 필드 @Autowired 어노테이션으로  DI (의존성 주입하기)
	@Autowired(required=false)	
	private OsRboardDAO osRboardDAO;

	@Override
	public int osRboardInsert(OsRboardVO rbvo) {
		// TODO Auto-generated method stub
		logger.info("osRboardInsert 함수 진입 >>> : ");			
		return osRboardDAO.osRboardInsert(rbvo);
	}

	@Override
	public List<OsRboardVO> osRboardSelectAll(OsRboardVO rbvo) {
		// TODO Auto-generated method stub
		logger.info("osRboardSelectAll 함수 진입 >>> : ");			
		return osRboardDAO.osRboardSelectAll(rbvo);
	}

	@Override
	public int osRboardDelete(OsRboardVO rbvo) {
		// TODO Auto-generated method stub
		logger.info("kosRboardDelete 함수 진입 >>> : ");			
		return osRboardDAO.osRboardDelete(rbvo);
	}

}
