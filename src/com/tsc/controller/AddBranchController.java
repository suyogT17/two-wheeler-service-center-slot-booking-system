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
import com.tsc.model.Branch;
import com.tsc.model.Distance;
import com.tsc.service.ServiceCenterService;
import com.tsc.service.SlotBookService;
import com.tsc.util.SearchParameter;

@Controller
public class AddBranchController {

	@Autowired
	ServiceCenterService serviceCenterService;
	
	@SuppressWarnings("rawtypes")
	@Autowired
	RefMasterMaintainDAOImpl refMasterMaintainDAOImpl; 
	
	@Autowired
	SlotBookService slotBookService;
	
	List<Branch> branchList=new ArrayList<Branch>();
	
	@RequestMapping(value="/addservicecenter.html",method=RequestMethod.GET)
	public ModelAndView addServiceCenter(){
		
		ModelAndView view=new ModelAndView("addservicecenter","addservicecenter",new Branch());
		return view;
	}
	
	@RequestMapping(value="/addservicecenter1.html",method=RequestMethod.POST)
	public String addServiceCenterToDB(@ModelAttribute(value="addservicecenter")Branch branch)
	{
		serviceCenterService.addServiceCenter(branch);
		return "addservicecenter";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/viewservicecenter.html",method=RequestMethod.GET)
	public ModelAndView showAllServiceCenters()
	{
		
		List<SearchParameter> search=new ArrayList<SearchParameter>();
		branchList=refMasterMaintainDAOImpl.findEntityList(Branch.class, search, null);
		ModelAndView view=new ModelAndView("viewservicecenter");
		view.addObject("branch", branchList);
		return view;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/myservicecenters.html",method=RequestMethod.GET)
	public ModelAndView showNearestCenters()
	{
		List<SearchParameter> search=new ArrayList<SearchParameter>();
		branchList=refMasterMaintainDAOImpl.findEntityList(Branch.class, search, null);
		List<Distance> sortedList=slotBookService.compareList(branchList);
		ModelAndView view=new ModelAndView("myservicecenters");
		view.addObject("sortedList", sortedList);
		return view;
	}
	
	
}
