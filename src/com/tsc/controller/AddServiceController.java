package com.tsc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tsc.model.Service;
import com.tsc.model.ServiceType;
import com.tsc.service.GetServiceDetailsService;

@Controller
public class AddServiceController {

	@Autowired
	private GetServiceDetailsService getServiceDetails;
	
	
	List<ServiceType> serviceTypeList;
	
	@RequestMapping(value="/addservice.html",method=RequestMethod.GET)
	public ModelAndView addService()
	{
		
		
		serviceTypeList=getServiceDetails.getAllServiceType();
		for (ServiceType s : serviceTypeList) {
			System.out.println(s.getServiceTypeName());
			
		}
		
		ModelAndView view=new ModelAndView("addservice", "addnewservice", new Service());
		System.out.println("1");
		view.addObject("serviceTypeList", serviceTypeList);
		System.out.println("done loading");
		return view;
	}
	
	@RequestMapping(value="/addservice1.html",method=RequestMethod.POST)
	public ModelAndView addServiceToDB(@ModelAttribute(value="addnewservice") com.tsc.model.Service service)
	{
		
		
		getServiceDetails.addService(service); 
		System.out.println("done adding");

		ModelAndView view=new ModelAndView("addservice", "addnewservice", new Service());
		
		view.addObject("serviceTypeList", serviceTypeList);
		return view;
		
	
	}
	
}
