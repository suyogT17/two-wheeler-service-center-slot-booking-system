package com.tsc.dto;

import java.util.List;

public class ServiceTransactionDto {

	public Integer vehicleId;
	public Integer branchId;
	public List<Integer> serviceId;
	public List<Integer> accessoryid;
	public String[] mode;
	
	
	public String[] getMode() {
		return mode;
	}
	public void setMode(String[] mode) {
		this.mode = mode;
	}
	public List<Integer> getAccessoryid() {
		return accessoryid;
	}
	public void setAccessoryid(List<Integer> accessoryid) {
		this.accessoryid = accessoryid;
	}
	public Integer getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}
	public Integer getBranchId() {
		return branchId;
	}
	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}
	public List<Integer> getServiceId() {
		return serviceId;
	}
	public void setServiceId(List<Integer> serviceId) {
		this.serviceId = serviceId;
	}
	
	
}
