package com.kos.testlegacy.oracle.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kos.testlegacy.oracle.vo.EmpVO;


@Repository("empDAO")
public class EmpDAOImpl implements EmpDAO{
	
	Logger logger = LogManager.getLogger(EmpDAOImpl.class);
	
	@Autowired(required = false)
	@Resource(name = "sqlSession_oracle")
	//private SqlSessionTemplate sqlSession;
	private DefaultSqlSessionFactory sqlSession;
	
	@Override
	public List<EmpVO> empSelect(){
		//TODO Auto-generated method stub
		logger.info("empSelect 함수 진입 >>> : ");
		
		return sqlSession.openSession().selectList("empSelect");
		// return sqlSession.selectList("empSelect");
	}

}
