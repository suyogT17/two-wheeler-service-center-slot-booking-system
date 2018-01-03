package com.tsc.service;



import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsc.dao.RefMasterMaintainDAOImpl;
import com.tsc.model.Branch;
import com.tsc.model.User;
import com.tsc.model.Vehicle;

@Service
public class VehicleService {

	@SuppressWarnings("rawtypes")
	@Autowired
	RefMasterMaintainDAOImpl refMasterMaintainDAOImpl; 
	
	@SuppressWarnings("unchecked")
	public void addVehicle(Vehicle vehicle) {
		// TODO Auto-generated method stub
		
		vehicle.setNoOfFreeServices(6);
		vehicle.setRegiDate(new Date());
		vehicle.setPurchaseDate(new Date());
		User user=new User();
		user.setUserId(vehicle.getUserIds());
		vehicle.setUser(user);
		
		Branch branch=new Branch();
		branch.setBranchId(vehicle.getBranchIds());
		vehicle.setBranch(branch);
		
		refMasterMaintainDAOImpl.saveEntity(vehicle);
	}

	
}
