package com.tsc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sun.research.ws.wadl.Request;

@Controller
public class TestController {

		
		Integer service[]=new Integer[100];
		
		
		public Integer[] getService() {
			return service;
		}


		public void setService(Integer[] service) {
			this.service = service;
		}

		
		@RequestMapping(value="/test2.html",method=RequestMethod.GET)
		public String getServi()
		{
			
			return "test2";
			
		}

		
		
		@RequestMapping(value="/getallparam.html",method=RequestMethod.POST)
		public void getService1(HttpServletRequest request,HttpServletResponse response)
		{
			String myser[]=request.getParameterValues("chk");
			//=testController.getService();
			for(int i=0;i<myser.length;i++)
			{
				System.out.println("item "+i+":"+myser[i]);
			}
			
			
		}
}
