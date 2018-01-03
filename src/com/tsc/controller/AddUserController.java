package com.tsc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tsc.dao.RefMasterMaintainDAOImpl;
import com.tsc.dto.UserRegistrationDto;
import com.tsc.model.User;
import com.tsc.service.UserService;
import com.tsc.util.ApplicationConstantsUtil;
import com.tsc.util.SearchParameter;

@Controller
public class AddUserController {

	@Autowired
	UserService userService;
	
	@SuppressWarnings("rawtypes")
	@Autowired
	RefMasterMaintainDAOImpl refMasterMaintainDAOImpl;
	
	@RequestMapping(value="/adduser.html",method=RequestMethod.GET)
	public ModelAndView addUser()
	{
		ModelAndView view=new ModelAndView("userregistration","adduser",new UserRegistrationDto());
		return view;
	}
	
	@RequestMapping(value="/adduser1.html",method=RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute(value="adduser")UserRegistrationDto userRegistrationDto)
	{
		System.out.println("IN ADD");
		ModelAndView view=new ModelAndView("userregistration","adduser",new UserRegistrationDto());
		userService.addNewUser(userRegistrationDto);
		return view;
	}
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/viewusers.html",method=RequestMethod.GET)
	public ModelAndView viewUsers()
	{
		List<SearchParameter> search=new ArrayList<SearchParameter>();
		System.out.println("1");
		/*SearchParameter s1=new SearchParameter(ApplicationConstantsUtil.MC_EQUAL, "isEnable", "true");
		System.out.println("2");
		*/SearchParameter s2=new SearchParameter(ApplicationConstantsUtil.MC_EQUAL, "role.roleId", 2);
		System.out.println("3");
		//search.add(s1);
		search.add(s2);
		List<User> userList=new ArrayList<User>();
		userList=refMasterMaintainDAOImpl.findEntityList(User.class, search, null);
		ModelAndView view=new ModelAndView("viewusers");
		view.addObject("user", userList);
		return view;
	}
	
	
}
