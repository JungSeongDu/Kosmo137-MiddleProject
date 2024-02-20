package com.kos.testlegacy.os.mem.service;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kos.testlegacy.os.kart.vo.OsBuyVO;
import com.kos.testlegacy.os.lecture.vo.OsLectureVO;
import com.kos.testlegacy.os.mem.dao.OsMemDAO;
import com.kos.testlegacy.os.mem.vo.OsMemVO;

@Service
@Transactional
public class OsMemServiceImpl implements OsMemService {
	Logger logger = LogManager.getLogger(OsMemServiceImpl.class);
	
	@Autowired(required=false)
	private OsMemDAO osMemDAO;
	
	@Override
	public int osMemInsert(OsMemVO ovo) {
		// TODO Auto-generated method stub
		logger.info("  service.osMemInsert >>> : ");
		return osMemDAO.osMemInsert(ovo);
	}

	@Override
	public String OsMemSelectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String OsMemSelect(OsMemVO ovo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String OsMemUpdate(OsMemVO ovo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OsMemVO> idCheck(OsMemVO ovo) {
		// TODO Auto-generated method stub
		logger.info(" OsMemService.idCheck() 진입 >>> : ");
		return osMemDAO.idCheck(ovo);
	}
	
	@Override
	public List<OsMemVO> loginCheck(OsMemVO ovo){
		return osMemDAO.loginCheck(ovo);
	}
	@Override
	public List<OsMemVO> mypageCheck(OsMemVO ovo){
		logger.info("osMypageFormservice >>> :");
		return osMemDAO.mypageCheck(ovo);
	}
	
	@Override
	public List<OsBuyVO> byCheck(OsBuyVO obo){
		logger.info("byCheck >>> 서비스 :" + obo.getMid());
		return osMemDAO.byCheck(obo);
	}
	
	@Override
	public List<OsMemVO> idFindSelect(OsMemVO ovo){
		logger.info("byCheck >>> 서비스 :" + ovo.getMid());
		return osMemDAO.idFindSelect(ovo);
	}
	@Override
	public int mypageUpdate(OsMemVO ovo){
		logger.info("osMypageUpdateService >>> :");
		return osMemDAO.mypageUpdate(ovo);
	}
	
	@Override
	public int mypageDelete(OsMemVO ovo) {
		logger.info("osMypagedeleteService >>> : ");			
		return osMemDAO.mypageDelete(ovo);
	}

}
