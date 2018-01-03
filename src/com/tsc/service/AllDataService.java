package com.tsc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tsc.dao.RefMasterMaintainDAOImpl;
import com.tsc.model.Branch;
import com.tsc.model.Service;
import com.tsc.model.ServiceType;
import com.tsc.model.User;
import com.tsc.util.ApplicationConstantsUtil;
import com.tsc.util.SearchParameter;

@org.springframework.stereotype.Service
public class AllDataService {

	@SuppressWarnings("rawtypes")
	@Autowired
	RefMasterMaintainDAOImpl refMasterMaintainDAOImpl;
	
	@SuppressWarnings("unchecked")
	public List<User> getUserDetails() {
		// TODO Auto-generated method stub
		List<User> userList=new ArrayList<User>();
		List<SearchParameter> searchParameter=new ArrayList<SearchParameter>();
		userList=refMasterMaintainDAOImpl.findEntityList(User.class, searchParameter, null);
		
		return userList;
	}

	@SuppressWarnings("unchecked")
	public List<Branch> getBranchList() {
		// TODO Auto-generated method stub
		List<Branch> branchList=new ArrayList<Branch>();
		List<SearchParameter> searchParameter=new ArrayList<SearchParameter>();
		branchList=refMasterMaintainDAOImpl.findEntityList(Branch.class, searchParameter, null);
		
		return branchList;
	}
	
	
	public List<List<Service>> getServicesAndCatagory()
	{
		List<ServiceType> serviceTypeList=new GetServiceDetailsService().getAllServiceType();
		List<List<Service>> allList=new ArrayList<List<Service>>();	
		System.out.println("here2");
		
		
		for(ServiceType s3:serviceTypeList)
		{
			List<SearchParameter> search1=new ArrayList<SearchParameter>();
			SearchParameter s=new SearchParameter(ApplicationConstantsUtil.MC_EQUAL, "servicetype.serviceTypeId", s3.getServiceTypeId());
			search1.add(s);
			allList.add(new RefMasterMaintainDAOImpl<Service>().findEntityList(Service.class, search1, null));		
		
			
		}
		return allList;
		
	}

}
