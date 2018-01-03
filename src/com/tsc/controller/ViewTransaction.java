package com.tsc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tsc.dao.RefMasterMaintainDAOImpl;
import com.tsc.model.Service;
import com.tsc.model.ServiceRegistry;
import com.tsc.model.Slot;
import com.tsc.util.ApplicationConstantsUtil;
import com.tsc.util.SearchParameter;

@Controller
public class ViewTransaction {

	@SuppressWarnings("rawtypes")
	@Autowired
	RefMasterMaintainDAOImpl refMasterMaintainDAOImpl;
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/transactions.html",method=RequestMethod.GET)
	public ModelAndView viewAllUsers()
	{
		ModelAndView view=new ModelAndView("transaction");
		
		List<Slot> slotList=new ArrayList<Slot>();
		List<SearchParameter> search=new ArrayList<SearchParameter>();
		slotList=refMasterMaintainDAOImpl.findEntityList(Slot.class, search, null);
		
		
		view.addObject("slotList", slotList);
		return view;
		
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/details.html",method=RequestMethod.POST)
	@ResponseBody
	public String viewDetails(String ticket)
	{
		String data1="";
		System.out.println("ticket="+ticket);
		List<SearchParameter> search=new ArrayList<SearchParameter>();
		SearchParameter s1=new SearchParameter(ApplicationConstantsUtil.MC_EQUAL, "bOTP", ticket);
		search.add(s1);
		List<Slot> slotList=refMasterMaintainDAOImpl.findEntityList(Slot.class,search,null);
		
		if(slotList!=null){
		data1=""+"<br><h4><table><tr><td>Job Ticket No:</td><td> "+ticket
				+"</td></tr><tr><td>User:</td><td> "+slotList.get(0).getUser().getUserName()
				+"</td></tr><tr><td>Branch:</td><td> "+slotList.get(0).getBranch().getBranchName()
				+"</td></tr><tr><td>Pick:</td><td> "+slotList.get(0).getBpick()
				+"</td></tr><tr><td>Drop:</td><td> "+slotList.get(0).getBdrop()
				+"</td></tr><tr><td>Vehicle name:</td><td> "+slotList.get(0).getVehicle().getVehicleName()
				+"</td></tr><tr><td>Vehicle number:</td><td> "+slotList.get(0).getVehicle().getNumber()
				+"</td></tr><tr><td>Vehicle chassis number:</td><td> "+slotList.get(0).getVehicle().getChassisNo()
				+"</td></tr></table><br>Services: </h4><h4><table border=1><tr><th>Service name</th><th>Cost</th></tr>";
		}
		
		List<SearchParameter> search2=new ArrayList<SearchParameter>();
		SearchParameter s2=new SearchParameter(ApplicationConstantsUtil.MC_EQUAL, "slot.bslotId", slotList.get(0).getBslotId());
		search2.add(s2);
		List<ServiceRegistry> sList=refMasterMaintainDAOImpl.findEntityList(ServiceRegistry.class, search2, null);
		
		for(ServiceRegistry s:sList)
		{
			List<SearchParameter> search3=new ArrayList<SearchParameter>();
			SearchParameter s3=new SearchParameter(ApplicationConstantsUtil.MC_EQUAL, "serviceId", s.getUserviceId());
			search3.add(s3);
			List<Service> serviceList=refMasterMaintainDAOImpl.findEntityList(Service.class, search3, null);
			data1=data1+"<tr><td>"+serviceList.get(0).getName()+"</td>\t<td>"+serviceList.get(0).getCharges()+"</td></tr>";
		}
		data1=data1+"<h><tr><td>cost:</td><td> "+slotList.get(0).getBcost()+"</td></tr></h4>";
		System.out.println(data1);
		return data1;
	}
	
	
}
