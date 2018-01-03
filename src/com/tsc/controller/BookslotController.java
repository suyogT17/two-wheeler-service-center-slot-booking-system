package com.tsc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tsc.dao.RefMasterMaintainDAOImpl;
import com.tsc.model.Branch;
import com.tsc.model.Service;
import com.tsc.model.ServiceType;
import com.tsc.model.Slot;
import com.tsc.model.User;
import com.tsc.model.Vehicle;
import com.tsc.service.SlotBookService;
import com.tsc.util.ApplicationConstantsUtil;
import com.tsc.util.SearchParameter;

@Controller
public class BookslotController {

	@SuppressWarnings("rawtypes")
	@Autowired
	RefMasterMaintainDAOImpl refMasterMaintainDAOImpl;
	
	@Autowired
	SlotBookService slotbook;
	

	
	@RequestMapping(value="/book.html",method=RequestMethod.GET)
	public ModelAndView loadBookSlot()
	{
	
		ModelAndView view=slotbook.loadPageDetails();
		return view;		
	}
	
	
	@RequestMapping(value="/book1.html",method=RequestMethod.POST)
	public  ModelAndView bookSlotDB(@ModelAttribute(value="bookaslot")Slot slot,HttpServletRequest request,HttpServletResponse response)
	{
		System.out.println(slot.getBranchIds()+" "+slot.getVehicleIds()+" "+slot.getBpick()+" "+slot.getBdrop());
		String services[]=request.getParameterValues("service");
		System.out.println("got array!!!");
		slotbook.bookServiceSlot(services,slot);
		ModelAndView view=slotbook.loadPageDetails();
		
		return view;		
	}
	
}
