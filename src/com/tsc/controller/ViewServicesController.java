package com.tsc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tsc.dao.RefMasterMaintainDAOImpl;
import com.tsc.model.Service;
import com.tsc.model.ServiceType;
import com.tsc.service.AllDataService;
import com.tsc.service.GetServiceDetailsService;
import com.tsc.util.ApplicationConstantsUtil;
import com.tsc.util.SearchParameter;

@Controller
public class ViewServicesController {

	@Autowired
	GetServiceDetailsService getServiceDetailsService;
	
	@Autowired
	AllDataService allDataService;
	
	@RequestMapping(value="/myservices.html",method=RequestMethod.GET)
	public ModelAndView viewServices()
	{
		System.out.println("here");
		/*List<List<Service>> allList= allDataService.getServicesAndCatagory();
		System.out.println("alllist");
		List<ServiceType> serviceTypeList=getServiceDetailsService.getAllServiceType();
		System.out.println("serviceList");*/

		//List<ServiceType> serviceTypeList=new GetServiceDetailsService().getAllServiceType();
		List<SearchParameter> search=new ArrayList<SearchParameter>();


		List<ServiceType> serviceTypeList=new RefMasterMaintainDAOImpl<ServiceType>().findEntityList(ServiceType.class, search, null);
		List<List<Service>> allList=new ArrayList<List<Service>>();	
		System.out.println("here2");
		
		
		for(ServiceType s3:serviceTypeList)
		{
			List<SearchParameter> search1=new ArrayList<SearchParameter>();
			SearchParameter s=new SearchParameter(ApplicationConstantsUtil.MC_EQUAL, "servicetype.serviceTypeId", s3.getServiceTypeId());
			search1.add(s);
			allList.add(new RefMasterMaintainDAOImpl<Service>().findEntityList(Service.class, search1, null));		
		
			
		}
		
		ModelAndView view=new ModelAndView("userservices");
		view.addObject("allList",allList);
		view.addObject("serviceTypeList", serviceTypeList);
		
		return view;
	}
	
}
