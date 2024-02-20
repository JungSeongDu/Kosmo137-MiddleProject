package com.kos.testlegacy.oracle.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;

import com.kos.testlegacy.oracle.service.EmpService;
import com.kos.testlegacy.oracle.vo.EmpVO;



@Controller
public class EmpController {
	
	Logger logger = LogManager.getLogger(EmpController.class);
			
	//컨트롤러에서 kosSpring 서비스 연결
	@Autowired(required = false)
	@Resource(name = "empService")
	private EmpService empService;

	
	//@RequestMapping(value = "empSelect", method=RequestMethod.GET)
    @GetMapping("empSelect")  //spring 4.3.16 버전
	public String empSelect(Model model) {
		logger.info("empSelect 함수 진입 >>> : ");
		
		List<EmpVO> listAll = empService.empSelect();
		int nCnt = listAll.size();
		logger.info("empSelect nCnt >>> : " + nCnt);
		
		model.addAttribute("listAll",listAll);
		
		return "empSelect";
			
		
	}
}
