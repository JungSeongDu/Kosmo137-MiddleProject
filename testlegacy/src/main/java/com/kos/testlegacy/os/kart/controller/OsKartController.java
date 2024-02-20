package com.kos.testlegacy.os.kart.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kos.testlegacy.os.kart.service.OsKartService;
import com.kos.testlegacy.os.kart.vo.OsBuyVO;
import com.kos.testlegacy.os.kart.vo.OsKartVO;
import com.kos.testlegacy.common.NumUtil;

@Controller
public class OsKartController {
	
	Logger logger = LogManager.getLogger(OsKartController.class);
	
	// 필드 오토와이어드 
		@Autowired(required=false)
		private OsKartService osKartService;
	
	//카트 목록
	@RequestMapping(value="osKartSelectAll", method=RequestMethod.GET)
	public String osKartSelectAll(OsKartVO okvo, Model model) {
		logger.info("osKartSelectAll 함수 진입 >>> : ");
		
		okvo.setKnum("1234");
		logger.info("okv0.getKnum() >>> : " + okvo.getKnum());
		
		List<OsKartVO> kartListAll = osKartService.osKartSelectAll(okvo);
		if(kartListAll.size()>0) {
			logger.info("OsKartController listAll.size() >>> : " + kartListAll.size());
			model.addAttribute("kartListAll",kartListAll);
			return "kart/osKartSelectAll";
		}
		return "kart/osKartSelectAll";
	}
	
	
	//한건 삭제
	@RequestMapping(value="osKartDelete", method=RequestMethod.GET)
	public String osKartDelete(HttpServletRequest req, OsKartVO okvo, Model model) {
		
		logger.info("osKartDelete 함수 진입 >>> : ");
		
		okvo.setKnum(req.getParameter("knumV"));
		logger.info("osKArtDelete 함수 진입 okvo.getKnum() >>> : " + okvo.getKnum());
		
		int nCnt = osKartService.osKartDelete(okvo);
		if(nCnt > 0) {
			logger.info("osKartDelete 함수 진입 nCnt >>> : " + nCnt);
		}
		return "kart/osKartDelete";
	}
	
	//선택삭제 전체 삭제
	@RequestMapping(value="osKartDeleteArray",method=RequestMethod.GET)
	public String osKartDeleteArray(HttpServletRequest req,OsKartVO okvo, Model model) {
		logger.info("osKartDeleteArray 함수 진입 >>> : ");
		
		String knumV[] = req.getParameterValues("knum");
		ArrayList<OsKartVO> aList = new ArrayList<OsKartVO>();
		
		for(int i=0; i<knumV.length; i++) {
			OsKartVO _okvo = new OsKartVO();
			_okvo.setKnum(knumV[i]);
			aList.add(_okvo);
		}
		
		int nCnt = osKartService.osKartDeleteArray(aList);		
		if (nCnt == -1) {
			logger.info("osKartDeleteArray 함수 진입 nCnt >>> : " + nCnt);
		}
		return "kart/osKartDelete";
	}
	
	@RequestMapping(value="osKartInsert", method=RequestMethod.POST)
	public String osKartInsert(OsKartVO okvo, Model model,HttpServletRequest req) {
		logger.info("osKartInsert >>> : ");

		okvo.setLname(req.getParameter("lname"));
		okvo.setLprice(req.getParameter("lprice"));
		okvo.setLnum(req.getParameter("lnum"));
		okvo.setLfile(req.getParameter("lfile"));
		okvo.setLcur(req.getParameter("lcur"));
		logger.info("getParameter >>> : " + okvo.getLname());
		logger.info("getParameter >>> : " + okvo.getLprice());
		logger.info("getParameter >>> : " + okvo.getLnum());
		logger.info("getParameter >>> : " + okvo.getLfile());
		logger.info("getParameter >>> : " + okvo.getLcur());
		
		int nCnt = osKartService.osKartInsert(okvo);
		if (nCnt > 0) {
			logger.info("osKartInsert 함수 진입 nCnt >>> : " + nCnt);
			
			return "kart/osKartInsert";
		}
		return "lecture/osLectureSelectOne";
	}
	
	//결제하기(insert)
	@RequestMapping(value="osKartUpdate", method=RequestMethod.POST)
	public String osKartUpdate(OsKartVO okvo, Model model,HttpServletRequest req, OsBuyVO obo) {
		logger.info("osKartUpdate >>> : ");
		
		HttpSession session = req.getSession();
		String mid = (String)session.getAttribute("mid");
		String lname = req.getParameter("lname");
		String lnum = req.getParameter("lnum");
		String lfile = req.getParameter("lfile");
		String lcur = req.getParameter("lcur");
		
		//OsBuyVO에 셋
		obo.setMid(mid);
		obo.setLname(lname);
		obo.setLnum(lnum);
		obo.setLfile(lfile);
		obo.setLcur(lcur);
		logger.info("mid >>> : " + mid);
		logger.info("lname >>> : " + lname);
		logger.info("lnum >>> : " + lnum);
		logger.info("lfile >>> : " + lfile);
		logger.info("lcur >>> : " + lcur);
		
		//okvo.setLnum(req.getParameter("lnum"));
		logger.info("getParameter >>> : " + obo.getMid());
		
		int nCnt = osKartService.osKartUpdate(obo);
		if (nCnt > 0) {
			logger.info("osKartUpdate 함수 진입 nCnt >>> : " + nCnt);
			
			return "main/osLoginForm";
		}
		return "lecture/osLectureSelectOne";
	}

	
}
