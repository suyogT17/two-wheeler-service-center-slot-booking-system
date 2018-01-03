package com.tsc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sun.research.ws.wadl.Request;
import com.tsc.dao.RefMasterMaintainDAOImpl;
import com.tsc.model.Branch;
import com.tsc.model.User;
import com.tsc.model.Vehicle;
import com.tsc.service.AllDataService;
import com.tsc.service.VehicleService;
import com.tsc.util.ApplicationConstantsUtil;
import com.tsc.util.SearchParameter;

@Controller
public class AddVehicleController {

	@Autowired
	AllDataService allDataService;
	
	@Autowired
	VehicleService vehicleService;
	
	@SuppressWarnings("rawtypes")
	@Autowired
	RefMasterMaintainDAOImpl refMasterMaintainDAOImpl;
	
	List<User> userList;
	List<Branch> branchList;

	@RequestMapping(value="/addvehicle.html",method=RequestMethod.GET)
	public ModelAndView addVehicle()
	{
		userList=allDataService.getUserDetails();
		branchList=allDataService.getBranchList();
		
		ModelAndView view=new ModelAndView("addvehicle", "addvehicle", new Vehicle());
		view.addObject("userList", userList);
		view.addObject("branchList",branchList);
		return view;
	}
	
	
	@RequestMapping(value="/addvehicle1.html",method=RequestMethod.POST)
	public ModelAndView addVehicleToDB(@ModelAttribute(value="addvehicle")Vehicle vehicle)
	{
		vehicleService.addVehicle(vehicle);
		ModelAndView view=new ModelAndView("addvehicle", "addvehicle", new Vehicle());
		view.addObject("userList", userList);
		view.addObject("branchList",branchList);
		return view;
	}
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/viewallvehicles.html", method = RequestMethod.GET)
	public ModelAndView showAllVehicles() {
		List<SearchParameter> search=new ArrayList<SearchParameter>();
		List<Vehicle> vehicleList=refMasterMaintainDAOImpl.findEntityList(Vehicle.class, search, null);
		final ModelAndView view = new ModelAndView("viewvehicles");
		view.addObject("vehicle",vehicleList);
				return view;
	}
	
	
	
	
	

}
