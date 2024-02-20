package com.kos.testlegacy.os.rboard.controller;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kos.testlegacy.os.rboard.service.OsRboardService;
import com.kos.testlegacy.os.rboard.vo.OsRboardVO;

@Controller
public class OsRboardController {
   Logger logger = LogManager.getLogger(OsRboardController.class);
   
   // 컨트롤러에서 댓글 서비스 연결 
   @Autowired(required=false)
   private OsRboardService osRboardService;
   
   // 댓글 글쓰기 폼
   @RequestMapping(value = "osRboardForm", method = RequestMethod.GET)
   public String osRboardForm() {
      logger.info("osRboardForm 함수 진입 >>> : ");   
      return "rboard/rboardForm";
   }
   
   // 댓글 등록
   @RequestMapping(value = "rboardInsert", method = RequestMethod.POST)
   @ResponseBody
   public String rboardInsert(OsRboardVO rbvo) {   
      logger.info("osRboardInsert >>> : ");
      logger.info("osRboardInsert rbvo.getBnum() >>> : " + rbvo.getBnum());
                     
      logger.info("rbvo.getBnum() >>> : " + rbvo.getBnum());
      logger.info("rbvo.getRbname() >>> : " + rbvo.getRbname());
      logger.info("rbvo.getRbcontent() >>> : " + rbvo.getRbcontent());      
      
      int nCnt = osRboardService.osRboardInsert(rbvo);
      logger.info("kosRboardInsert nCnt >>> : " + nCnt);
      
      if (1 == nCnt) { return "GOOD"; }
      else { return "BAD"; }
   }
   
   // 댓글 전체 조회   
   @RequestMapping(value = "rboardSelectAll", method = RequestMethod.POST)
   @ResponseBody
   public String rboardSelectAll(OsRboardVO rbvo) {   
      logger.info("osRboardSelectAll >>> : ");
      // rbvo.setSbnum("B0001");
      logger.info("osRboardSelectAll rbvo.getBnum() >>> : " + rbvo.getBnum());
      
      List<OsRboardVO> list  = osRboardService.osRboardSelectAll(rbvo);
      logger.info("osRboardSelectAll list >>> : " + list);
      
      String ss = "";
      String listStr = "";
      for (int i=0; i < list.size(); i++) {
         OsRboardVO _rbvo = list.get(i);
         String s0 = _rbvo.getRbnum();
         String s1 = _rbvo.getRbname();
         String s2 = _rbvo.getRbcontent();
         String s3 = _rbvo.getInsertdate();
         ss = s0+","+s1+","+s2+","+s3;
         listStr += ss+"&";
         logger.info("listStr >>> : " + listStr);
      }
      return listStr;
   }
   
   // 댓글 삭제   
   @RequestMapping(value = "rboardDelete", method = RequestMethod.POST)
   @ResponseBody
   public String rboardDelete(OsRboardVO rbvo) {   
      logger.info("osRboardDelete >>> : ");
      logger.info("osRboardDelete rbvo.getRbnum() >>> : " + rbvo.getRbnum());
   
      int nCnt  = osRboardService.osRboardDelete(rbvo);
      logger.info("osRboardDelete nCnt >>> : " + nCnt);
      
      if (1 == nCnt) { return "GOOD"; }
      else { return "BAD"; }
   }

}