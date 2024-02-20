package com.kos.testlegacy.os.rboard.dao;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kos.testlegacy.os.rboard.vo.OsRboardVO;

@Repository
public class OsRboardDAOImpl implements OsRboardDAO {
	Logger logger = LogManager.getLogger(OsRboardDAOImpl.class);
	
	@Autowired(required=false)
	private SqlSessionTemplate sqlSession;

	@Override
	public int osRboardInsert(OsRboardVO rbvo) {
		// TODO Auto-generated method stub
		logger.info("osRboardInsert 함수 진입 >>> : ");			
		return sqlSession.insert("osRboardInsert", rbvo);
	}

	@Override
	public List<OsRboardVO> osRboardSelectAll(OsRboardVO rbvo) {
		// TODO Auto-generated method stub
		logger.info("osRboardSelectAll 함수 진입 >>> : ");	
		return sqlSession.selectList("osRboardSelectAll", rbvo);
	}

	@Override
	public int osRboardDelete(OsRboardVO rbvo) {
		// TODO Auto-generated method stub
		logger.info("osRboardDelete 함수 진입 >>> : ");			
		return sqlSession.update("osRboardDelete", rbvo);
	}

}
