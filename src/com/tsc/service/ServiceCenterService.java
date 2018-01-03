package com.tsc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsc.dao.RefMasterMaintainDAOImpl;
import com.tsc.model.Branch;

@Service
public class ServiceCenterService {

	@SuppressWarnings("rawtypes")
	@Autowired
	RefMasterMaintainDAOImpl refMasterMaintainDAOImpl;

	@SuppressWarnings("unchecked")
	public void addServiceCenter(Branch branch) {
		// TODO Auto-generated method stub
		
		refMasterMaintainDAOImpl.saveEntity(branch);
		System.out.println("branch added");
		
	}

}
