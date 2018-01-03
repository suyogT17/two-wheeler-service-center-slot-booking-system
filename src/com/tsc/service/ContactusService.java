package com.tsc.service;

import org.springframework.stereotype.Service;

import com.tsc.util.SystemConstants;

@Service
public class ContactusService {

	public Boolean sendMail(String username, String msg) {
		// TODO Auto-generated method stub
	
		String body =SystemConstants.FEEDBACK_EMAIL_BODY;
		String mailbody =body.replaceAll("UserName",username).replaceAll("userfeedback",msg);
		String subject = SystemConstants.FEEDBACK_EMAIL_SUBJECT;
		try{
		if(FeedbackEmailService.sendEmaill(mailbody, subject,"custcareshoppingmania@gmail.com"))
		{
		return true;
		}
		/*else
		{
			System.out.println("failed");
			return false;
			
		}*/
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
		return true;
		
	}

}
