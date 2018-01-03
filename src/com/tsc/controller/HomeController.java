package com.tsc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.tsc.util.ApplicationConstantsUtil;

@Controller
public class HomeController {

		@RequestMapping(value="/select.html",method=RequestMethod.GET)
		public ModelAndView logIn()
		{
			System.out.println("here in select");
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			System.out.println("got auth:"+auth);
			
	        String role = auth.getAuthorities().toString();
	       System.out.println("i am here !!!!!!"+auth+"   "+role);
	        if(role.contains(ApplicationConstantsUtil.USER_ROLE))
	        {
	        	ModelAndView view = new ModelAndView(new RedirectView("myprofile.html",true));
	    		return view;
	        }
	        else
	        {
	        	
	        	ModelAndView view = new ModelAndView(new RedirectView("viewusers.html",true));
	    		return view;
	        }
		
		}
	
		
		@RequestMapping(value="/login.html",method=RequestMethod.GET)
		public String logInPage()
		{
			return "login";
		}
		
	
		@RequestMapping(value="/homepage.html",method=RequestMethod.GET)
		public String homePage()
		{
			return "homepage";
		}
		
		
		

		
		@RequestMapping(value="/aboutus.html",method=RequestMethod.GET)
		public String aboutus()
		{
			return "aboutus";
		}
		
		
		@RequestMapping(value="/logout", method = RequestMethod.GET)
		public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
		    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		    System.out.println("in logout: "+auth);
		    if (auth != null){    
		        new SecurityContextLogoutHandler().logout(request, response, auth);
		    }
		    return "redirect:/login.html?logout";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
		}
}
