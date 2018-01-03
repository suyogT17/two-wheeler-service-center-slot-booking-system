package com.tsc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tsc.service.ContactusService;

@Controller
public class ContactusController {

	@Autowired
	ContactusService contactService;
	
	@RequestMapping(value="/contactus.html",method=RequestMethod.GET)
	public String contactUs()
	{
		return "contactus";
	}
	
	
	@RequestMapping(value="/contactus.html",method=RequestMethod.POST)
			public String contactUs1(HttpServletRequest request,HttpServletResponse res)
	{
		 
		String username=request.getParameter("username");
		String email=request.getParameter("email");
		String msg=request.getParameter("msg");
		contactService.sendMail(username,msg);
		return "contactus";
	}
	}
