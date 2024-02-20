package com.kos.testlegacy.os.mem.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kos.testlegacy.os.kart.vo.OsBuyVO;
import com.kos.testlegacy.os.lecture.vo.OsLectureVO;
import com.kos.testlegacy.os.mem.vo.OsMemVO;

@Repository
public class OsMemDAOImpl implements OsMemDAO {
	Logger logger = LogManager.getLogger(OsMemDAOImpl.class);
	
	@Autowired(required=false)
	private SqlSession sqlSession;
	
	@Override
	public int osMemInsert(OsMemVO ovo) {
		// TODO Auto-generated method stub
		logger.info("  dao.osMemInsert >>> : ");
		return (Integer)sqlSession.insert("osMemInsert", ovo);
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
		return sqlSession.selectList("idCheck", ovo);
	}
	
	@Override
	public List<OsMemVO> loginCheck(OsMemVO ovo){
		return sqlSession.selectList("loginCheck", ovo);
	}
	
	@Override
	public List<OsMemVO> mypageCheck(OsMemVO ovo) {
		logger.info("osMypageFormdao >>> :");
		return sqlSession.selectList("mypageCheck", ovo);
	}
	
	@Override
	public List<OsBuyVO> byCheck(OsBuyVO obo){
		logger.info("byCheck >>> : 다오" + obo.getMid());
		return sqlSession.selectList("byCheck", obo);
	}
	
	@Override
	public List<OsMemVO> idFindSelect(OsMemVO ovo){
		logger.info("byCheck >>> 서비스 :" + ovo.getMid());
		return sqlSession.selectList("idFindSelect",ovo);
	}
	@Override
	public int mypageUpdate(OsMemVO ovo) {
		logger.info("osBoardUpdate 함수 진입 >>> : ");	
		
		return sqlSession.update("mypageUpdate", ovo);
	}
	
	@Override
	public int mypageDelete(OsMemVO ovo) {
		logger.info("osBoardDelete 함수 진입 >>> : ");	
		
		return sqlSession.update("mypageDelete", ovo);
	}

}
