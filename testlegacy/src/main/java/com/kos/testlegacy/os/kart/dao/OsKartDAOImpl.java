package com.kos.testlegacy.os.kart.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kos.testlegacy.os.kart.vo.OsBuyVO;
import com.kos.testlegacy.os.kart.vo.OsKartVO;



@Repository
public class OsKartDAOImpl implements OsKartDAO {
	Logger logger = LogManager.getLogger(OsKartDAOImpl.class);
	
	@Autowired(required=false)
	private SqlSession sqlSession;

	@Override
	public List<OsKartVO> osKartSelectAll(OsKartVO kcvo) {
		// TODO Auto-generated method stub
		logger.info("osKartInsert 함수 진입 >>> : ");	
		return sqlSession.selectList("osKartSelectAll", kcvo);
	}
	
	
	@Override
	public int osKartDelete(OsKartVO okvo) {
		// TODO Auto-generated method stub
		logger.info("osKartDelete 함수 진입 >>> : ");
		return(Integer)sqlSession.update("osKartDelete",okvo);
	}
	
	@Override
	public int osKartDeleteArray(ArrayList<OsKartVO> aList) {
		// TODO Auto-generated method stub
		logger.info("kosmoCartDeleteArray 함수 진입 >>> : ");			
		return (Integer)sqlSession.update("osKartDeleteArray", aList);
	}
	
	@Override
	public int osKartInsert(OsKartVO okvo) {
		logger.info("osKartInsert 함수 진입 >>> : ");	
		
		return (Integer)sqlSession.insert("osKartInsert", okvo);
	}
	
	@Override
	public int osKartUpdate(OsBuyVO obo) {
		logger.info("osKartUpdate 함수 진입 >>> :");
		
		return (Integer)sqlSession.insert("osKartUpdate", obo);
	}
}
