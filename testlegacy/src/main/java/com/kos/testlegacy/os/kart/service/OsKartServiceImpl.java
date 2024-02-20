package com.kos.testlegacy.os.kart.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kos.testlegacy.os.kart.dao.OsKartDAO;
import com.kos.testlegacy.os.kart.vo.OsBuyVO;
import com.kos.testlegacy.os.kart.vo.OsKartVO;


@Service
@Transactional
public class OsKartServiceImpl implements OsKartService {
	Logger logger = LogManager.getLogger(OsKartServiceImpl.class);
	
		// 서비스에서 DAO 연결하기 
		// 필드 @Autowired 어노테이션으로  DI (의존성 주입하기)
		@Autowired(required=false)
		private OsKartDAO osKartDAO;
		
		
		@Override
		public List<OsKartVO> osKartSelectAll(OsKartVO okvo) {
			// TODO Auto-generated method stub
			logger.info("kosmoCartSelectAll 함수 진입 >>> : ");		
			return osKartDAO.osKartSelectAll(okvo);
		}
		
		@Override
		public int osKartDelete(OsKartVO okvo) {
			// TODO Auto-generated method stub
			logger.info("osKartDelete 함수 진입 >>> : ");
			return osKartDAO.osKartDelete(okvo);
		}
		
		@Override
		public int osKartDeleteArray(ArrayList<OsKartVO> aList) {
			// TODO Auto-generated method stub
			logger.info("osKartDeleteArray 함수 진입 >>> : ");		
			return osKartDAO.osKartDeleteArray(aList);
		}
		
		@Override
		public int osKartInsert(OsKartVO okvo) {
			logger.info("osKartInsert 함수 진입 >>> : ");
			
			return osKartDAO.osKartInsert(okvo);
		}
		
		@Override
		public int osKartUpdate(OsBuyVO obo) {
			logger.info("osKartUpdate 함수 진입 >>> :");
			
			return osKartDAO.osKartUpdate(obo);
		}
		
}
