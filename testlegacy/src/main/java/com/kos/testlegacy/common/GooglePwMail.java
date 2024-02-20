package com.kos.testlegacy.common;

import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;

import com.kos.testlegacy.os.mem.controller.OsMemController;
import com.kos.testlegacy.os.mem.dao.OsMemDAOImpl;
import com.kos.testlegacy.os.mem.service.OsMemService;
import com.kos.testlegacy.os.mem.vo.OsMemVO;


public class GooglePwMail {
	public void pwMail(String resiveMail, String sendMsg, String sendId) {
		
		
		String mailSubject = "임시 비밀번호 메일 입니다.";
		System.out.println("googleMailSender resiveMail >>> "	 	+ resiveMail);
		System.out.println("googleMailSender sendMsg >>> : " 		+ sendMsg);
		System.out.println("googleMailSender sendId >>> : " 		+ sendId);
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		
		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("dgdo7777@gmail.com", "udfe ogxx jwuy ihzb");
			}
		});
		
		
		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(resiveMail, "관리자", "utf-8"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(resiveMail));
			message.setSubject(mailSubject);
			message.setContent("비밀번호:"+sendMsg +"<br> 아이디: <br>"+ sendId, "text/html; charset=utf-8");
			
			Transport.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public static void main(String args[]) {
	
		String resiveMail ="rhdqndyd121@gmail.com"; //""; 이렇게해도 오류는 안뜸 어차피 view에서 입력한 값으로 다시 초기화 됨
		String tempPw = PasswordUtil.randomPW(6);
		String sendMsg = "<h2 style='color:blue'>"+ tempPw +"</h2>";
		String sendId = "";
		
		OsMemVO lvo = null;
		lvo = new OsMemVO();
		
		GooglePwMail gms = new GooglePwMail();
		gms.pwMail(resiveMail, sendMsg, sendId);
		
	}
}
