package com.tsc.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import com.tsc.controller.NearestServiceCenter;
import com.tsc.dao.RefMasterMaintainDAOImpl;
import com.tsc.model.Branch;
import com.tsc.model.Distance;
import com.tsc.model.Service;
import com.tsc.model.ServiceRegistry;
import com.tsc.model.ServiceType;
import com.tsc.model.Slot;
import com.tsc.model.User;
import com.tsc.model.Vehicle;
import com.tsc.util.ApplicationConstantsUtil;
import com.tsc.util.Helper;
import com.tsc.util.SearchParameter;
import com.tsc.util.SystemConstants;

@org.springframework.stereotype.Service
public class SlotBookService {

	@SuppressWarnings("rawtypes")
	@Autowired
	RefMasterMaintainDAOImpl refMasterMaintainDAOImpl;
	
	
	@SuppressWarnings("unchecked")
	public void bookServiceSlot(String[] services, Slot slot) {
		// TODO Auto-generated method stub
		Integer cost=0;
		String OTP=null;
		String msg="<table>";
		for(String s:services)
		{
			System.out.println("inside for each: "+s);
			
			
			
			
			List<SearchParameter> searchList=new ArrayList<SearchParameter>();
			SearchParameter search=new SearchParameter(ApplicationConstantsUtil.MC_EQUAL, "serviceId", Integer.parseInt(s));
			searchList.add(search);
			List<Service> serviceList=refMasterMaintainDAOImpl.findEntityList(Service.class, searchList, null);	
			if(serviceList.size()!=0)
			{
				System.out.println("before cost");
			cost=cost+ serviceList.get(0).getCharges();
			msg=msg+"<tr>";
			msg=msg+"<td>"+serviceList.get(0).getName()+"</td><td>"+serviceList.get(0).getCharges()+"</td></tr>";
			
			System.out.println("after cost");
					
			}		
			else{
				cost=cost+0;
			}
		}
		msg=msg+"</table>";
		System.out.println("cost: "+cost);
		//SystemConstants.ORDER_CONFIRMATION_MAIL.append("cost: "+cost);
		slot.setBcost(cost);
		//cost=0;
		Branch b=(Branch) refMasterMaintainDAOImpl.findById(Branch.class, Integer.parseInt(slot.getBranchIds()));
	
		
		slot.setBranch(b);
		
		
		Vehicle vehicle=(Vehicle) refMasterMaintainDAOImpl.findById(Vehicle.class,Integer.parseInt(slot.getVehicleIds()));
		slot.setVehicle(vehicle);
		
		String username=Helper.getUsername(); 
		Integer userid=0;
		String email=null;
		
		List<SearchParameter> searchList=new ArrayList<SearchParameter>();
		SearchParameter search=new SearchParameter(ApplicationConstantsUtil.MC_EQUAL, "userName", username);
		searchList.add(search);
		List<User> userList=refMasterMaintainDAOImpl.findEntityList(User.class, searchList, null);
		if(userList!=null)
		{
			userid=userList.get(0).getUserId();
			email=userList.get(0).getEmailId();
			slot.setUser(userList.get(0));
		}
		

	
		try {
			 OTP="TWSC"+Helper.generatePin();
			slot.setbOTP(OTP);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		refMasterMaintainDAOImpl.saveEntity(slot);
		int i=0;
		//ServiceRegistry serviceRegistry=new ServiceRegistry();
		//List<ServiceRegistry> servicereg=new ArrayList<ServiceRegistry>();
 		
		for(String s:services)
		{	System.out.println("in for:"+i++);
		ServiceRegistry serviceRegistry=new ServiceRegistry();
			serviceRegistry.setSlot(slot);
			serviceRegistry.setUserviceId(Integer.parseInt(s));
		//	servicereg.add(serviceRegistry)
			refMasterMaintainDAOImpl.saveEntity(serviceRegistry);
	//	refMasterMaintainDAOImpl.batchSaveOrUpdate(boList);
		}
		SystemConstants.ORDER_CONFIRMATION_MAIL.append("Dear "+username+"<br>your JOB TICKET NO:<b>"+OTP+"</b><br>Your service details are<br>"+msg+"<br>Total cost:"+cost);
		
		this.sendMail(OTP,username,email);
		
	}


	private void sendMail(String oTP, String username, String email) {
		// TODO Auto-generated method stub
		
		StringBuffer body =SystemConstants.ORDER_CONFIRMATION_MAIL;
		String subject = SystemConstants.ORDER_COMPLETE_EMAIL_SUBJECT;
		//String emailId= u.getEmailId();
		//System.out.println("meassage service: "+EmailService.sendEmaill(mailbody, subject, emailId));
		
		EmailService.sendEmaill(body.toString(), subject, email);
		
	}


	@SuppressWarnings("unchecked")
	public ModelAndView loadPageDetails() {
		
		// TODO Auto-generated method stub
		List<User> userList=this.getuser();
		
		List<SearchParameter> search=new ArrayList<SearchParameter>();
		SearchParameter s1=new SearchParameter(ApplicationConstantsUtil.MC_EQUAL, "user.userId", userList.get(0).getUserId());
		search.add(s1);
		List<Vehicle> vehicleList=refMasterMaintainDAOImpl.findEntityList(Vehicle.class, search, null);
		
		
		List<SearchParameter> search6=new ArrayList<SearchParameter>();
		List<Branch> branchList=refMasterMaintainDAOImpl.findEntityList(Branch.class, search6, null);
		
		List<ServiceType> serviceTypeList=new RefMasterMaintainDAOImpl<ServiceType>().findEntityList(ServiceType.class, search6, null);
		System.out.println("here6");

		List<List<Service>> allList=new ArrayList<List<Service>>();	
		
		System.out.println("here2");
		
		
		for(ServiceType s3:serviceTypeList)
		{
			List<SearchParameter> search1=new ArrayList<SearchParameter>();
			SearchParameter s=new SearchParameter(ApplicationConstantsUtil.MC_EQUAL, "servicetype.serviceTypeId", s3.getServiceTypeId());
			search1.add(s);
			allList.add(new RefMasterMaintainDAOImpl<Service>().findEntityList(Service.class, search1, null));		
		
			
		}
	
		
		List<Distance> branchList2=this.compareList(branchList);
		
		ModelAndView view=new ModelAndView("bookslot","bookaslot",new Slot());
		view.addObject("allList",allList);
		view.addObject("serviceTypeList", serviceTypeList);
		view.addObject("vehicleList", vehicleList);
		view.addObject("branchList", branchList2);
		
		return view;
	}


	public List<Distance> compareList(List<Branch> branchList) {
		// TODO Auto-generated method stub
		String username=Helper.getUsername();
		double ulng = 0,ulat = 0;
		List<SearchParameter> search=new ArrayList<SearchParameter>();
		SearchParameter s1=new SearchParameter(ApplicationConstantsUtil.MC_EQUAL, "userName", username);
		search.add(s1);
		
		@SuppressWarnings("unchecked")
		List<User> userList=refMasterMaintainDAOImpl.findEntityList(User.class, search, null);				
		if(userList!=null){
		ulng=userList.get(0).getUlongitude();
		ulat=userList.get(0).getUlatitude();
		}
		List<Distance> sortedBranch=new ArrayList<Distance>();
		for(Branch b:branchList)
		{
			Double dist=NearestServiceCenter.distance(b.getLatitude(), b.getLongitude(),ulat, ulng);
			Distance d=new Distance();
			d.setServiceCenterId(b.getBranchId());
			d.setServiceCentername(b.getBranchName());
			d.setMiles(dist);
			sortedBranch.add(d);
		}
		Miles m=new Miles();
		Collections.sort(sortedBranch, m);
		for(Distance d:sortedBranch)
		{
			System.out.println(d.getServiceCenterId()+" "+d.getServiceCentername()+" "+d.getMiles());
		}
		
		return sortedBranch;
		
		}
	

	@SuppressWarnings("unchecked")
	public List<User> getuser()
	{
		String username=Helper.getUsername();
		List<SearchParameter> searchList=new ArrayList<SearchParameter>();
		SearchParameter search=new SearchParameter(ApplicationConstantsUtil.MC_EQUAL, "userName", username);
		searchList.add(search);
		List<User> serviceList=refMasterMaintainDAOImpl.findEntityList(User.class, searchList, null);	
		System.out.println("success fully returned");
		return serviceList;
		
	}
	
	
}
