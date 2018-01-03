package com.tsc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsc.dao.RefMasterMaintainDAOImpl;
import com.tsc.model.ServiceType;
import com.tsc.util.SearchParameter;

@Service
public class GetServiceDetailsService {
	
	@SuppressWarnings("rawtypes")
	@Autowired
	private RefMasterMaintainDAOImpl refMasterMaintainDAOImpl;

	@SuppressWarnings("unchecked")
	public List<ServiceType> getAllServiceType()
	{
		List<SearchParameter> searchParameterList = new ArrayList<SearchParameter>();
		List<ServiceType> serviceTypeList = refMasterMaintainDAOImpl.findEntityList(ServiceType.class, searchParameterList, null);
		return serviceTypeList;
		
	}
	
	
	@SuppressWarnings("unchecked")
	public void addService(com.tsc.model.Service service) {
		// TODO Auto-generated method stub
			System.out.println("in this");
			System.out.println(service.getName()+" "+service.getCharges()+" "+service.getTimeToComplete()+" "+service.getServiceTypeIds());
			ServiceType serviceType=new ServiceType();
			serviceType.setServiceTypeId(Integer.parseInt(service.getServiceTypeIds()));
			service.setServicetype(serviceType);
			System.out.println("sett");
			refMasterMaintainDAOImpl.saveEntity(service);
			System.out.println("saved");
		
	}

		
	
}
