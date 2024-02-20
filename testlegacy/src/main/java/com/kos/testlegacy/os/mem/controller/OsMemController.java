package com.kos.testlegacy.os.mem.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kos.testlegacy.common.GooglePwMail;
import com.kos.testlegacy.common.PasswordUtil;
import com.kos.testlegacy.os.kart.vo.OsBuyVO;
import com.kos.testlegacy.os.lecture.vo.OsLectureVO;
import com.kos.testlegacy.os.mem.service.OsMemService;
import com.kos.testlegacy.os.mem.vo.OsMemVO;

@Controller
public class OsMemController {
   Logger logger = LogManager.getLogger(OsMemController.class);
   //서비스 연결
   @Autowired
   private OsMemService osMemService;
   
   //@RequestMapping("mainlink")
   @GetMapping("mainlink")
   public String mainlink() {
      logger.info(" mainlink() 함수 진입 >>> : ");
                     return "main/osMain";
   }
   
   //로그인폼
   @RequestMapping(value= "osLoginForm", method = RequestMethod.GET)
   //@GetMapping("osLoginForm")
   public String loginForm() {
      logger.info("OsLoginController loginForm() 함수 진입 >>> : ");
      return"main/osLoginForm";
   }
   
   //로그인
   @RequestMapping(value = "login",method=RequestMethod.POST)
   //@GetMapping("login" )
   public String login(HttpServletResponse response, HttpServletRequest req, OsMemVO ovo, Model model, OsBuyVO obo) {
      logger.info("login() 함수 진입 >>> : ");
      logger.info("login() 함수 진입 >>> : " + ovo.getMid());
      logger.info("login() 함수 진입 >>> : " + ovo.getMpw());
      String mid = ovo.getMid();
      obo.setMid(mid);
      //자동로그인 쿠키 생성
      if(req.getParameter("chek")!=null) {
            logger.info("remember me..." + ovo.getMid());
           Cookie ck = new Cookie("ID",ovo.getMid());
           Cookie cK_1 = new Cookie("PW",ovo.getMpw());
           ck.setMaxAge(60*30*24);
           cK_1.setMaxAge(60*30*24);
           response.addCookie(ck);
           response.addCookie(cK_1);
        }
      //세션 생성 및 아이디 저장
      HttpSession session = req.getSession();
      session.setAttribute("mid", ovo.getMid());
      logger.info("세션값 >>> :" + session.getAttribute("mid"));
      
      String remoteIP = req.getRemoteAddr();
      String remoteHost = req.getRemoteHost();
      String browser = req.getHeader("User-Agent").toUpperCase();
      String browserName = "";
      
      if (browser.indexOf("CHROME") >= 0) {
            browserName = "CHROME";
      }else if (browser.indexOf("SAFARI") >= 0) {
            browserName = "SAFARI";
      }else if (browser.indexOf("EDG") >= 0) {
            browserName = "EDGE";
      }else if (browserName.indexOf("TRIDENT") >= 0) {
            browserName = "IE";
      }else if(browser.indexOf("FIREFOX") >= 0) {
            browserName = "FIREFOX";
      }else {
         browserName="";
      }
      
      logger.info("remoteIP >>> : " + remoteIP);
      logger.info("remoteHost >>> : " + remoteHost);
      logger.info("browser >>> : " + browser);
      logger.info("browserName >>> : " + browserName);
      
      List<String> remoteInfo = new ArrayList<String>();
      remoteInfo.add(remoteIP);
      remoteInfo.add(browserName);
      
      List<OsMemVO> listLogin = osMemService.loginCheck(ovo);
      logger.info("list size >>> " + listLogin.size());
      
      if (listLogin.size() == 1) { 
         model.addAttribute("listLogin", listLogin);
         
         // 강의목록 조회 서비스 호출 
         // 조회결과 메인페이지로 보내기 
         List<OsBuyVO> listBuy = osMemService.byCheck(obo);
         logger.info("byCheck >>> : 컨트롤러" + obo.getMid());
         model.addAttribute("listBuy", listBuy);
         return "main/osMain";
      }   
      return "main/osLoginForm";
   }
   
   // 로그 아웃   
   @RequestMapping(value="logout", method=RequestMethod.GET)
   public String logout() {   
      logger.info("OsLoginController logout() 함수 진입 >>> : ");      
         
      return "main/osLoginForm";
   }
   
   @RequestMapping(value="osMemInsertForm", method=RequestMethod.GET)
   public String osInsertForm() {
      logger.info(" osInsertForm 함수 진입 >>> : ");
         
      return "main/osInsertForm";
      
      }
   //회원가입
   @RequestMapping(value="osMemInsert", method=RequestMethod.GET)
   public String osMemInsert(OsMemVO ovo, Model model) {
      logger.info(" osMemInsert 함수 진입 >>> : ");
      logger.info(" getMid() >>> : " + ovo.getMid());
      logger.info(" getMpw() >>> : " + ovo.getMpw());
      logger.info(" getMname() >>> : " + ovo.getMname());
      logger.info(" getMtel() >>> : " + ovo.getMtel());
      logger.info(" getMemail() >>> : " + ovo.getMemail());
      
      int insertCnt = osMemService.osMemInsert(ovo);
      if(insertCnt > 0){
         logger.info("insertCnt >>> : " + insertCnt);
         model.addAttribute("insertCnt", insertCnt);
         return "main/osInsert";
      }
      
   return "main/osInsertForm";
      
}
   
   //아이디중복체크
   @RequestMapping(value="idCheck", method=RequestMethod.POST)
   @ResponseBody
   public Object idCheck(OsMemVO ovo) {
      logger.info("idCheck 함수 진입 >>> :");      
      logger.info("idCheck ovo.getmid()() >>> : " + ovo.getMid());
      
      List<OsMemVO> list = osMemService.idCheck(ovo);
      logger.info("idCheck list.size() >>> :" + list.size());
      
      String msg = "";
      if(list.size() == 0) {msg = "ID_YES";}
      else { msg = "ID_NO";}
      
      return msg;
   }
      
   //아이디찾기 폼
   @RequestMapping("idFindForm")
   public String idFindForm() {
      
      return "main/osidFindForm" ;
   }
   
   // pw 이메일로 보내기     
   @RequestMapping(value="idFindSelect", method=RequestMethod.GET)
   public String idFindSelect(OsMemVO ovo, Model model) {
      logger.info("idFindSelect >>> :" + ovo.getMid());

         String resiveMail = ovo.getMemail();
         String tempPw = PasswordUtil.randomPW(6);
         String sendMsg = "<h2 style='color:blue'>" + tempPw + "</h2>";
         String sendId = ovo.getMid();
         
         try {
            
            GooglePwMail gms = new GooglePwMail();
            gms.pwMail(resiveMail, sendMsg, sendId);
            
            model.addAttribute("msg", "임시 비밀번호를 확인하시오. !!");
            
         }catch(Exception e) {
            logger.info("SpingLoginController test_tempPwEmail() 에러가  >>> : " + e);
         }
               
         return "main/osLoginForm";
      }
   //마이페이지 로그인
         @RequestMapping("osMypage")
         public String osMypage() {
            
            return "main/osMypage";
         }
         
         @RequestMapping(value = "osMypageForm", method=RequestMethod.GET)
         public String osMypageForm(OsMemVO ovo, Model model) {
            logger.info("osMypageFormcontroller >>> :");
            List<OsMemVO> list = osMemService.mypageCheck(ovo);
            
            if (list.size()>0) {
               
               model.addAttribute("list", list);
               return "main/osMypageForm";
            }
            
            return "main/osMain";
         }
         
         
         @RequestMapping(value="osMypageUpdate", method=RequestMethod.GET)
         public String osMypageUpdate(HttpServletRequest req, OsMemVO ovo_1, Model model) {
            
            logger.info("osMypageUpdate >>> :");
            logger.info("osMypageUpdate 함수 진입 ovo.getMid() >>> : " + ovo_1.getMid());
            
            int nCnt = osMemService.mypageUpdate(ovo_1);
            
            if (nCnt > 0) { 
               logger.info("osMemService nCnt >>> : " + nCnt);
               
               return "main/osMain";
            }
            return "main/osMain";      
         }
         
         @RequestMapping(value = "osMypageDelete", method=RequestMethod.GET)
         public String osMypageDelete(OsMemVO ovo, Model model) {
            logger.info("osMypageDelete >>> :");
            logger.info("osMypageDelete 함수 진입 ovo.getMid() >>> : " + ovo.getMid());
            
            int nCnt = osMemService.mypageDelete(ovo);
            
            if (nCnt > 0) { 
               logger.info("osMemService nCnt >>> : " + nCnt);
               return "main/osLoginForm";
            }
            return "main/osMain";
         }
}