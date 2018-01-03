package com.tsc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tsc.service.PasswordService;
import com.tsc.util.Helper;

@Controller
public class PasswordController {
	
	String pass=null;
	
	@Autowired
	PasswordService passwordService;
	
	public String uname=null;
	@RequestMapping(value="/change.html",method=RequestMethod.GET)
	public String changePassword()
	{
		return "changepassword";
	}
	
	
	@RequestMapping(value="generatecode.do",method=RequestMethod.POST)
	@ResponseBody
	public String generateCode(String password)
	{
		passwordService.generateVerificationCode(password);
		return "ok";
	}
	
	
	
	@RequestMapping(value="verifycode.do",method=RequestMethod.POST)
	@ResponseBody
	public String verify(String password,String code)
	{
		
		//  Authentication auth = SecurityContextHolder.getContext().getAuthentication();		
		 
		
		//System.out.println("in verify.do() "+username);	
		pass=password;
		//uname=Helper.getUsername();
		System.out.println("VERIFYING PASSCODE");
		//String username="suyog";
		
		String status=passwordService.verifycode(pass,code,Helper.getUsername());
		return status;
	}
	
	@RequestMapping(value="/updatepassword.html",method=RequestMethod.POST)
	public String updatePassword()
	{
		
		passwordService.changePassword(Helper.getUsername(), pass);
		return "changepassword";
	}
	
	
}
