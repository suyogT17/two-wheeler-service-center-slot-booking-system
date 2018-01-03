package com.tsc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsc.dao.RefMasterMaintainDAOImpl;
import com.tsc.model.PassVerification;
import com.tsc.model.User;
import com.tsc.util.ApplicationConstantsUtil;
import com.tsc.util.Helper;
import com.tsc.util.SearchParameter;
import com.tsc.util.SystemConstants;

@Service
public class PasswordService {

	@SuppressWarnings("rawtypes")
	@Autowired
	RefMasterMaintainDAOImpl refMasterMaintainDAOImpl;
	

	
	@SuppressWarnings("unchecked")
	public void generateVerificationCode(String password) {
		// TODO Auto-generated method stub
		
		try {
			String username=Helper.getUsername();
			//String username="suyog123";
			String code=Helper.generatePin();
			PassVerification passVerification=new PassVerification();
		
			passVerification.setPassword(password);
			passVerification.setUsername(username);
			passVerification.setVerificationCode(code);
			
			
			
			if(this.sendVerificationMail(code,username,password))
			{
			refMasterMaintainDAOImpl.saveEntity(passVerification);
			}

			System.out.println("done code verification");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

	private Boolean sendVerificationMail(String code, String username, String password) {
		// TODO Auto-generated method stub
		
		
		List<User> userList=this.getUsers(username, password);
		
		String email=userList.get(0).getEmailId();
			String body =SystemConstants.CHANGE_PASSWORD_EMAIL_BODY;
			String mailbody =body.replaceAll("FirstName", userList.get(0).getFirstName()).replaceAll("vcode",code).replaceAll("userid", userList.get(0).getUserName());
			String subject = SystemConstants.CHANGE_PASSWORD_EMAIL_SUBJECT;
			if(EmailService.sendEmaill(mailbody, subject, email))
			{	
				return true;
			}
			else 
			{
				return false;
			}
	}
	

		
		



	@SuppressWarnings("unchecked")
	public String verifycode(String password, String code,String username) {
		// TODO Auto-generated method stub
	System.out.println("INSIDE VERIFYCODE()");
		
		//String username=Helper.getUsername();
		System.out.println("username:"+username);
		List<SearchParameter> search=new ArrayList<SearchParameter>();
		
		SearchParameter search1=new SearchParameter(ApplicationConstantsUtil.MC_EQUAL,"Username" , username);
	//	SearchParameter search2=new SearchParameter(ApplicationConstantsUtil.MC_EQUAL,"Password" , password);
		
		search.add(search1);
		//search.add(search2);
		
		List<PassVerification> verifyList=refMasterMaintainDAOImpl.findEntityList(PassVerification.class, search, null);
		int i=-1;
		for(PassVerification p:verifyList)
		
		{
			
			System.out.println(p.getUsername()+" "+p.getPassword()+" "+p.getVerificationCode());
			i=i+1;;
		}
		
		if(null!=verifyList)
		{
			System.out.println("inside verify");
			if(verifyList.get(i).getVerificationCode().equals(code))
			{
				return "success";
			}
			else
			{
				System.out.println("failed");
				return "failure";
				
			}
		}
		else
			return "failure";
	}

	@SuppressWarnings("unchecked")
	public void changePassword(String username,String password) {
		// TODO Auto-generated method stub
		
		/*List<SearchParameter> search=new ArrayList<SearchParameter>();
		
		SearchParameter search1=new SearchParameter(ApplicationConstantsUtil.MC_EQUAL,"userName" , username);
		search.add(search1);
		//search.add(search2);
		System.out.println("user list");
		List<User> userList=refMasterMaintainDAOImpl.findEntityList(User.class, search, null);
		for(User u:userList)
		{
			System.out.println(u.getFirstName()+" "+u.getPassword());
		}
		*/
		System.out.println(username);
		List<User> userList=this.getUsers(username,password);
		System.out.println("got userlist");
		if(null!=userList)
		{
			userList.get(0).setPassword(password);
			refMasterMaintainDAOImpl.saveEntity(userList.get(0));
		}

	}

	@SuppressWarnings("unchecked")
	private List<User> getUsers(String username,String password) {
		// TODO Auto-generated method stub
		List<SearchParameter> search=new ArrayList<SearchParameter>();
		SearchParameter search1=new SearchParameter(ApplicationConstantsUtil.MC_EQUAL,"userName" , username);
		search.add(search1);
		//search.add(search2);
		System.out.println("user list");
		List<User> userList=refMasterMaintainDAOImpl.findEntityList(User.class, search, null);
		for(User u:userList)
		{
			System.out.println(u.getFirstName()+" "+u.getPassword());
		}

		return userList;
	}

	
	
}
