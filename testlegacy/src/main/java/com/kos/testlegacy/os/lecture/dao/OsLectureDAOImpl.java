package com.kos.testlegacy.os.lecture.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.kos.testlegacy.os.lecture.vo.OsLectureVO;

@Repository
public class OsLectureDAOImpl implements OsLectureDAO {
	Logger logger = LogManager.getLogger(OsLectureDAOImpl.class);
	
	@Autowired(required=false)
	private SqlSession sqlSession;
	
	@Override
	public List<OsLectureVO> osLectureSelectAll(OsLectureVO ovo){
		logger.info("osLectureSelectAll 다오 진입>>> : " );
		
		return sqlSession.selectList("osLectureSelectAll", ovo);
	}
	
	//강의조건조회
	@Override
	public List osLectureSelect(OsLectureVO ovo) {
		// TODO Auto-generated method stub
		logger.info("osLectureSelect 다오 진입>>> : " );
		logger.info("osLectureSelect searchFiler>>> : "+ovo.getSearchFilter());
		logger.info("osLectureSelect getKeyword>>> : " +ovo.getKeyword());
		return sqlSession.selectList("osLectureSelect", ovo);
	}

	//메인페이지 검색기능
	@Override
	public List osLectureSelectMain(OsLectureVO ovo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("osLectureSelectMain", ovo);
	}
	
	@Override
	public List<OsLectureVO> osLectureSelectOne(OsLectureVO ovo){
			logger.info("osLectureSelectOne 다오 진입>>> : " );
		
		return sqlSession.selectList("osLectureSelectOne", ovo);
	}
	//게시글 조회수
    @Override
    public int osBoardLhit(OsLectureVO ovo) {
       // TODO Auto-generated method stub
       logger.info("OsLectureVO 함수 진입 >>> : ");
       return sqlSession.update("osBoardLhit", ovo);
    }
}
