package com.tsc.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tsc.dto.UserRegistrationDto;
import com.tsc.service.UserService;
import com.tsc.util.Helper;

@Controller
public class ViewProfileController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value="/myprofile.html",method=RequestMethod.GET)
	public ModelAndView viewProfile()
	{
		
		ModelAndView view =new ModelAndView("userprofile");
		String user=Helper.getUsername();
		UserRegistrationDto registrationDto=userService.getAllUserDetails(user);
		if(registrationDto!=null)
		{
			view.addObject("registrationDto",registrationDto);
		}
		return view;
	}
}
