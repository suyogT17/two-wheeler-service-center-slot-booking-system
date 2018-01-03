package com.tsc.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;

import com.tsc.dao.RefMasterMaintainDAOImpl;
import com.tsc.model.Service;
import com.tsc.model.ServiceType;
import com.tsc.util.ApplicationConstantsUtil;
import com.tsc.util.SearchParameter;

public class ListCheck {

	@SuppressWarnings("unchecked")
	public static void main(String ...args)
	{
		System.out.println("here1");
		
//List<SearchParameter> search=new ArrayList<SearchParameter>();


	//List<ServiceType> serviceTypeList=new RefMasterMaintainDAOImpl<ServiceType>().findEntityList(ServiceType.class, search, null);
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
	
	int i=0;
	for(List<Service> s:allList)
	{
		System.out.println(serviceTypeList.get(i++).getServiceTypeName());
		for(Service s1:s)
		{	
			System.out.println(s1.getName()+" "+s1.getServiceId());
		}
		

	}
	
	/*for(Object key: hm.keySet())
	{
		System.out.println(key);
		for(Object s: hm.values())
		{
			System.out.println(((Service) s).getName()+" "+((Service) s).getServiceId());
		}
	}
	*/
	}
	
}
