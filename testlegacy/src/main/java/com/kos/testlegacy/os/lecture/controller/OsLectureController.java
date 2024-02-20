package com.kos.testlegacy.os.lecture.controller;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.kos.testlegacy.os.lecture.service.OsLectureService;
import com.kos.testlegacy.os.lecture.vo.OsLectureVO;
import com.kos.testlegacy.common.CommonUtils;

@Controller
public class OsLectureController {
   Logger logger = LogManager.getLogger(OsLectureController.class);
   
   @Autowired
   private OsLectureService osLectureService;
   

      //강의조건조회
      @RequestMapping(value = "osLectureSelect", method = RequestMethod.GET)
      public String osLectureselect(@ModelAttribute OsLectureVO ovo,Model model) {
          logger.info("osLectureselect 함수 진입 >>> : ");
          logger.info(" searchFilter  >>> : " + ovo.getSearchFilter());
          logger.info(" keyword  >>> : " + ovo.getKeyword());
          
//          List<OsLectureVO> searchList = osLectureService.osLectureSelect(new OsLectureVO());
          List<OsLectureVO> searchList = osLectureService.osLectureSelect(ovo);
          int nCnt = searchList.size();
          logger.info(" osLectureselect nCnt >>> : " + nCnt);
         

          if (nCnt > 0) {
              model.addAttribute("searchList", searchList);
              return "lecture/osLectureSelect";
          }

          return "lecture/osLectureSelectForm";
      }
      
      //메인페이지 검색기능
      @RequestMapping(value = "osLectureSelectMain", method = RequestMethod.GET)
      public String osLectureSelectMain(@ModelAttribute OsLectureVO ovo,Model model) {
         logger.info(" getSearchValue  >>> : " + ovo.getSearchValue());
         List<OsLectureVO> searchListMain = osLectureService.osLectureSelectMain(ovo);
         int nCnt = searchListMain.size();
          logger.info(" osLectureselect nCnt >>> : " + nCnt);
         

          if (nCnt > 0) {
              model.addAttribute("searchList", searchListMain);
              return "lecture/osLectureSelect";
          }

          return "lecture/osLectureSelectForm";
      }
   
   //국어게시판조회
   @RequestMapping("osLectureSelectK")
   public String osLectureSelectK(OsLectureVO ovo, Model model){
      logger.info("osLectureSelectAll 컨트롤러 진입>>> : ");
      
      int pageSize = CommonUtils.LECTURE_PAGE_SIZE;
      int groupSize = CommonUtils.LECTURE_GROUP_SIZE;
      int curPage = CommonUtils.LECTURE_CUR_PAGE;
      int totalCount = CommonUtils.LECTURE_TOTAL_COUNT;
      
      if (ovo.getCurPage() !=null){
         curPage = Integer.parseInt(ovo.getCurPage());
      }
      
      ovo.setPageSize(String.valueOf(pageSize));
      ovo.setGroupSize(String.valueOf(groupSize));
      ovo.setCurPage(String.valueOf(curPage));
      ovo.setTotalCount(String.valueOf(totalCount));
      
      logger.info("osLectureSelectK ovo.getPageSize() >>> :    " + ovo.getPageSize());
      logger.info("osLectureSelectK ovo.getGroupSize() >>> :    " + ovo.getGroupSize());
      logger.info("osLectureSelectK ovo.getCurPage() >>> :    " + ovo.getCurPage());
      logger.info("osLectureSelectK ovo.getTotalCount() >>> : " + ovo.getTotalCount());
      
      String lname = "국어";
      ovo.setLname(lname);
      List<OsLectureVO> listAll = osLectureService.osLectureSelectAll(ovo);
      
      logger.info("kosBoardSelectAll listAll.size() >>> : " + listAll.size());
      if (listAll.size() > 0) { 
    	  model.addAttribute("lname", lname);
         model.addAttribute("pagingKBVO", ovo);      
         model.addAttribute("listAll", listAll);
         return "lecture/osLectureSelectAll";
         
      } return "lecture/osLectureSelectAll";
   }
   
   //영어게시판조회
      @RequestMapping("osLectureSelectE")
      public String osLectureSelectE(OsLectureVO ovo, Model model){
         logger.info("osLectureSelectAll 컨트롤러 진입>>> : ");

         int pageSize = CommonUtils.LECTURE_PAGE_SIZE;
         int groupSize = CommonUtils.LECTURE_GROUP_SIZE;
         int curPage = CommonUtils.LECTURE_CUR_PAGE;
         int totalCount = CommonUtils.LECTURE_TOTAL_COUNT;
         
         if (ovo.getCurPage() !=null){
            curPage = Integer.parseInt(ovo.getCurPage());
         }
         
         ovo.setPageSize(String.valueOf(pageSize));
         ovo.setGroupSize(String.valueOf(groupSize));
         ovo.setCurPage(String.valueOf(curPage));
         ovo.setTotalCount(String.valueOf(totalCount));
         
         logger.info("osLectureSelecte ovo.getPageSize() >>> :    " + ovo.getPageSize());
         logger.info("osLectureSelecte ovo.getGroupSize() >>> :    " + ovo.getGroupSize());
         logger.info("osLectureSelecte ovo.getCurPage() >>> :    " + ovo.getCurPage());
         logger.info("osLectureSelecte ovo.getTotalCount() >>> : " + ovo.getTotalCount());
         
         String lname = "영어";
         ovo.setLname(lname);
         List<OsLectureVO> listAll = osLectureService.osLectureSelectAll(ovo);
         
         logger.info("kosBoardSelectAll listAll.size() >>> : " + listAll.size());
         if (listAll.size() > 0) { 
        	 model.addAttribute("lname", lname);
            model.addAttribute("pagingKBVO", ovo);   
            model.addAttribute("listAll", listAll);
            return "lecture/osLectureSelectAll";
            
         } return "lecture/osLectureSelectAll";
      }
      
      //수학게시판조회
      @RequestMapping("osLectureSelectM")
      public String osLectureSelectM(OsLectureVO ovo, Model model){
         logger.info("osLectureSelectAll 컨트롤러 진입>>> : ");
         
         int pageSize = CommonUtils.LECTURE_PAGE_SIZE;
         int groupSize = CommonUtils.LECTURE_GROUP_SIZE;
         int curPage = CommonUtils.LECTURE_CUR_PAGE;
         int totalCount = CommonUtils.LECTURE_TOTAL_COUNT;
         
         if (ovo.getCurPage() !=null){
            curPage = Integer.parseInt(ovo.getCurPage());
         }
         
         ovo.setPageSize(String.valueOf(pageSize));
         ovo.setGroupSize(String.valueOf(groupSize));
         ovo.setCurPage(String.valueOf(curPage));
         ovo.setTotalCount(String.valueOf(totalCount));
         
         logger.info("osLectureSelectm ovo.getPageSize() >>> :    " + ovo.getPageSize());
         logger.info("osLectureSelectm ovo.getGroupSize() >>> :    " + ovo.getGroupSize());
         logger.info("osLectureSelectm ovo.getCurPage() >>> :    " + ovo.getCurPage());
         logger.info("osLectureSelectm ovo.getTotalCount() >>> : " + ovo.getTotalCount());
         
         String lname = "수학";
         ovo.setLname(lname);
         List<OsLectureVO> listAll = osLectureService.osLectureSelectAll(ovo);
         
         logger.info("kosBoardSelectAll listAll.size() >>> : " + listAll.size());
         if (listAll.size() > 0) { 
        	 model.addAttribute("lname", lname);
            model.addAttribute("pagingKBVO", ovo);      
            model.addAttribute("listAll", listAll);
            return "lecture/osLectureSelectAll";
            
         } return "lecture/osLectureSelectAll";
      }
      
      //강의상세보기
      @RequestMapping("osLectureSelectOne")
      public String osLectureSelectOne(OsLectureVO ovo, Model model){
         logger.info("osLectureSelectOne 컨트롤러 진입>>> : ");
         logger.info("osLectureSelectOne 컨트롤러 진입>>> : " + ovo.getLnum());
         List<OsLectureVO> listAll = osLectureService.osLectureSelectOne(ovo);
         
         logger.info("kosBoardSelectAll listAll.size() >>> : " + listAll.size());
         if (listAll.size() > 0) { 
        	 int bhitCnt = osLectureService.osBoardLhit(ovo);
             logger.info("kosBoardSelect bhitCnt >>> : " + bhitCnt);

            model.addAttribute("listOne", listAll);
            return "lecture/osLectureSelectOne";
            
      } return "lecture/osLectureSelectAll";
   }

   
}